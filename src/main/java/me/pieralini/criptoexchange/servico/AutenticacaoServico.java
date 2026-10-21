package me.pieralini.criptoexchange.servico;

import java.sql.Connection;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import me.pieralini.criptoexchange.banco.Conexao;
import me.pieralini.criptoexchange.modelo.Investidor;
import me.pieralini.criptoexchange.repositorio.InvestidorRepositorio;
import me.pieralini.criptoexchange.repositorio.CarteiraRepositorio;

public class AutenticacaoServico {

    private final InvestidorRepositorio investidorRepositorio = new InvestidorRepositorio();
    private final CarteiraRepositorio carteiraRepositorio = new CarteiraRepositorio();

    public Investidor autenticar(String cpf, String senha) throws Exception {

        validarCredenciais(cpf, senha);

        try (Connection conexao = Conexao.abrir()) {

            Investidor investidor = investidorRepositorio.buscarPorCpf(conexao, cpf);

            if (investidor == null || !verificarSenha(senha, investidor.getSenhaHash())) {
                throw new IllegalArgumentException("CPF ou senha inválidos");
            }

            return investidor;
        }
    }

    public boolean confirmarSenha(Investidor investidor, String senha) throws Exception {

        if (investidor == null || senha == null || !senha.matches("\\d{6}")) {
            return false;
        }

        try (Connection conexao = Conexao.abrir()) {

            Investidor investidorAtual = investidorRepositorio.buscarPorCpf(conexao, investidor.getCpf());

            if (investidorAtual == null) {
                return false;
            }

            return verificarSenha(senha, investidorAtual.getSenhaHash());
        }
    }

    public Investidor cadastrar(String nome, String cpf, String senha) throws Exception {

        validarCredenciais(cpf, senha);

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome");
        }

        try (Connection conexao = Conexao.abrir()) {

            conexao.setAutoCommit(false);

            try {

                String senhaHash = gerarHash(senha);

                long id = investidorRepositorio.cadastrar(
                    conexao, nome.trim(), cpf, senhaHash
                );

                carteiraRepositorio.criar(conexao, id);

                conexao.commit();

                return investidorRepositorio.buscarPorCpf(conexao, cpf);

            } catch (Exception erro) {

                conexao.rollback();
                throw erro;
            }
        }
    }

    private void validarCredenciais(String cpf, String senha) {

        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter 11 números");
        }

        if (senha == null || !senha.matches("\\d{6}")) {
            throw new IllegalArgumentException("Senha deve conter 6 números");
        }
    }

    private String gerarHash(String senha) throws Exception {

        byte[] sal = new byte[16];

        SecureRandom gerador = new SecureRandom();
        gerador.nextBytes(sal);

        byte[] hash = gerarSenhaCriptografada(senha, sal);

        String salTexto = Base64.getEncoder().encodeToString(sal);
        String hashTexto = Base64.getEncoder().encodeToString(hash);

        return salTexto + ":" + hashTexto;
    }

    private boolean verificarSenha(String senha, String senhaArmazenada) throws Exception {

        if (senhaArmazenada == null) {
            return false;
        }

        String[] partes = senhaArmazenada.split(":", -1);

        if (partes.length != 2) {
            return false;
        }

        byte[] sal = Base64.getDecoder().decode(partes[0]);
        byte[] hashArmazenado = Base64.getDecoder().decode(partes[1]);

        byte[] hashInformado = gerarSenhaCriptografada(senha, sal);

        return MessageDigest.isEqual(hashArmazenado, hashInformado);
    }

    private byte[] gerarSenhaCriptografada(String senha, byte[] sal) throws Exception {

        PBEKeySpec configuracao = new PBEKeySpec(
            senha.toCharArray(), sal, 120000, 256
        );

        try {
            SecretKeyFactory fabrica = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            return fabrica.generateSecret(configuracao).getEncoded();

        } finally {
            configuracao.clearPassword();
        }
    }
}