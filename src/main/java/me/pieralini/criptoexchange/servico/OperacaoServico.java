package me.pieralini.criptoexchange.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.List;
import me.pieralini.criptoexchange.banco.Conexao;
import me.pieralini.criptoexchange.modelo.Bitcoin;
import me.pieralini.criptoexchange.modelo.Carteira;
import me.pieralini.criptoexchange.modelo.Ethereum;
import me.pieralini.criptoexchange.modelo.Investidor;
import me.pieralini.criptoexchange.modelo.Movimentacao;
import me.pieralini.criptoexchange.modelo.Ripple;
import me.pieralini.criptoexchange.modelo.Tarifacao;
import me.pieralini.criptoexchange.repositorio.CarteiraRepositorio;
import me.pieralini.criptoexchange.repositorio.CotacaoRepositorio;
import me.pieralini.criptoexchange.repositorio.MovimentacaoRepositorio;

public class OperacaoServico {

    private final CarteiraRepositorio carteiraRepositorio = new CarteiraRepositorio();
    private final CotacaoRepositorio cotacaoRepositorio = new CotacaoRepositorio();
    private final MovimentacaoRepositorio movimentacaoRepositorio = new MovimentacaoRepositorio();
    private final AutenticacaoServico autenticacaoServico = new AutenticacaoServico();

    private static final int ESCALA = 8;

    public Carteira consultarSaldo(Investidor investidor, String senha) throws Exception {

        exigirSenha(investidor, senha);

        try (Connection conexao = Conexao.abrir()) {
            return carteiraRepositorio.buscar(conexao, investidor.getId(), false);
        }
    }

    public List<Movimentacao> consultarExtrato(Investidor investidor, String senha) throws Exception {

        exigirSenha(investidor, senha);

        try (Connection conexao = Conexao.abrir()) {
            return movimentacaoRepositorio.listar(conexao, investidor.getId());
        }
    }

    public Carteira depositar(Investidor investidor, BigDecimal valor) throws Exception {

        validarValor(valor);

        try (Connection conexao = Conexao.abrir()) {

            conexao.setAutoCommit(false);

            try {

                Carteira carteiraAnterior = carteiraRepositorio.buscar(
                    conexao, investidor.getId(), true
                );

                Carteira novaCarteira = new Carteira(
                    carteiraAnterior.getReais().add(valor),
                    carteiraAnterior.getBitcoin(),
                    carteiraAnterior.getEthereum(),
                    carteiraAnterior.getRipple()
                );

                carteiraRepositorio.salvar(conexao, investidor.getId(), novaCarteira);

                movimentacaoRepositorio.registrar(
                    conexao,
                    investidor.getId(),
                    "DEPOSITO",
                    "BRL",
                    valor,
                    null,
                    BigDecimal.ZERO,
                    novaCarteira
                );

                conexao.commit();

                return novaCarteira;

            } catch (Exception erro) {

                conexao.rollback();
                throw erro;
            }
        }
    }

    public Carteira sacar(Investidor investidor, BigDecimal valor) throws Exception {

        validarValor(valor);

        try (Connection conexao = Conexao.abrir()) {

            conexao.setAutoCommit(false);

            try {

                Carteira carteiraAnterior = carteiraRepositorio.buscar(
                    conexao, investidor.getId(), true
                );

                if (carteiraAnterior.getReais().compareTo(valor) < 0) {
                    throw new IllegalArgumentException("Saldo em reais insuficiente");
                }

                Carteira novaCarteira = new Carteira(
                    carteiraAnterior.getReais().subtract(valor),
                    carteiraAnterior.getBitcoin(),
                    carteiraAnterior.getEthereum(),
                    carteiraAnterior.getRipple()
                );

                carteiraRepositorio.salvar(conexao, investidor.getId(), novaCarteira);

                movimentacaoRepositorio.registrar(
                    conexao,
                    investidor.getId(),
                    "SAQUE",
                    "BRL",
                    valor.negate(),
                    null,
                    BigDecimal.ZERO,
                    novaCarteira
                );

                conexao.commit();

                return novaCarteira;

            } catch (Exception erro) {

                conexao.rollback();
                throw erro;
            }
        }
    }

    public Carteira comprar(Investidor investidor, String senha, String moeda,
                           BigDecimal valorReais) throws Exception {

        exigirSenha(investidor, senha);
        validarValor(valorReais);

        Tarifacao tarifacao = buscarTarifacao(moeda);

        try (Connection conexao = Conexao.abrir()) {

            conexao.setAutoCommit(false);

            try {

                Carteira carteiraAnterior = carteiraRepositorio.buscar(
                    conexao, investidor.getId(), true
                );

                BigDecimal cotacao = cotacaoRepositorio.buscar(conexao, moeda, false);

                BigDecimal taxa = valorReais.multiply(tarifacao.getTaxaCompra())
                        .setScale(ESCALA, RoundingMode.HALF_UP);

                BigDecimal custoTotal = valorReais.add(taxa);

                if (carteiraAnterior.getReais().compareTo(custoTotal) < 0) {
                    throw new IllegalArgumentException("Saldo insuficiente para compra e taxa");
                }

                BigDecimal quantidade = valorReais.divide(
                    cotacao, ESCALA, RoundingMode.DOWN
                );

                if (quantidade.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new IllegalArgumentException("Valor muito pequeno para compra");
                }

                BigDecimal novoSaldoReais = carteiraAnterior.getReais().subtract(custoTotal);

                Carteira novaCarteira = alterarCarteira(
                    carteiraAnterior, moeda, quantidade, novoSaldoReais
                );

                carteiraRepositorio.salvar(conexao, investidor.getId(), novaCarteira);

                movimentacaoRepositorio.registrar(
                    conexao,
                    investidor.getId(),
                    "COMPRA",
                    moeda,
                    quantidade,
                    cotacao,
                    taxa,
                    novaCarteira
                );

                conexao.commit();

                return novaCarteira;

            } catch (Exception erro) {

                conexao.rollback();
                throw erro;
            }
        }
    }

    public Carteira vender(Investidor investidor, String senha, String moeda,
                          BigDecimal quantidade) throws Exception {

        exigirSenha(investidor, senha);
        validarValor(quantidade);

        Tarifacao tarifacao = buscarTarifacao(moeda);

        try (Connection conexao = Conexao.abrir()) {

            conexao.setAutoCommit(false);

            try {

                Carteira carteiraAnterior = carteiraRepositorio.buscar(
                    conexao, investidor.getId(), true
                );

                if (carteiraAnterior.getSaldo(moeda).compareTo(quantidade) < 0) {
                    throw new IllegalArgumentException("Saldo de criptomoeda insuficiente");
                }

                BigDecimal cotacao = cotacaoRepositorio.buscar(conexao, moeda, false);

                BigDecimal valorBruto = quantidade.multiply(cotacao)
                        .setScale(ESCALA, RoundingMode.HALF_UP);

                BigDecimal taxa = valorBruto.multiply(tarifacao.getTaxaVenda())
                        .setScale(ESCALA, RoundingMode.HALF_UP);

                BigDecimal valorLiquido = valorBruto.subtract(taxa);

                BigDecimal novoSaldoReais = carteiraAnterior.getReais().add(valorLiquido);

                Carteira novaCarteira = alterarCarteira(
                    carteiraAnterior, moeda, quantidade.negate(), novoSaldoReais
                );

                carteiraRepositorio.salvar(conexao, investidor.getId(), novaCarteira);

                movimentacaoRepositorio.registrar(
                    conexao,
                    investidor.getId(),
                    "VENDA",
                    moeda,
                    quantidade.negate(),
                    cotacao,
                    taxa,
                    novaCarteira
                );

                conexao.commit();

                return novaCarteira;

            } catch (Exception erro) {

                conexao.rollback();
                throw erro;
            }
        }
    }

    private Carteira alterarCarteira(Carteira carteira, String moeda,
                                    BigDecimal diferenca, BigDecimal reais) {

        BigDecimal bitcoin = carteira.getBitcoin();
        BigDecimal ethereum = carteira.getEthereum();
        BigDecimal ripple = carteira.getRipple();

        switch (moeda) {

            case "BTC":
                bitcoin = bitcoin.add(diferenca);
                break;

            case "ETH":
                ethereum = ethereum.add(diferenca);
                break;

            case "XRP":
                ripple = ripple.add(diferenca);
                break;

            default:
                throw new IllegalArgumentException("Moeda inválida: " + moeda);
        }

        return new Carteira(reais, bitcoin, ethereum, ripple);
    }

    private Tarifacao buscarTarifacao(String moeda) {

        if (moeda == null) {
            throw new IllegalArgumentException("Moeda inválida");
        }

        switch (moeda) {

            case "BTC":
                return new Bitcoin();

            case "ETH":
                return new Ethereum();

            case "XRP":
                return new Ripple();

            default:
                throw new IllegalArgumentException("Moeda inválida: " + moeda);
        }
    }

    private void validarValor(BigDecimal valor) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0 || valor.scale() > 8) {
            throw new IllegalArgumentException(
                "Informe um valor positivo com até 8 casas decimais"
            );
        }
    }

    private void exigirSenha(Investidor investidor, String senha) throws Exception {

        if (!autenticacaoServico.confirmarSenha(investidor, senha)) {
            throw new IllegalArgumentException("Senha inválida");
        }
    }
}