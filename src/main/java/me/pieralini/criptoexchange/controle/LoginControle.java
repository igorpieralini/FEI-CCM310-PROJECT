package me.pieralini.criptoexchange.controle;

import me.pieralini.criptoexchange.modelo.Investidor;
import me.pieralini.criptoexchange.servico.AutenticacaoServico;

public class LoginControle {

    private final AutenticacaoServico autenticacaoServico = new AutenticacaoServico();

    public Investidor entrar(String cpf, String senha) throws Exception {
        return autenticacaoServico.autenticar(cpf, senha);
    }

    public Investidor cadastrar(String nome, String cpf, String senha) throws Exception {
        return autenticacaoServico.cadastrar(nome, cpf, senha);
    }
}