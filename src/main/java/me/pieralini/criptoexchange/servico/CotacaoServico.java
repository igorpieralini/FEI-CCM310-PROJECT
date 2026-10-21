package me.pieralini.criptoexchange.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import me.pieralini.criptoexchange.banco.Conexao;
import me.pieralini.criptoexchange.repositorio.CotacaoRepositorio;

public class CotacaoServico {

    private final CotacaoRepositorio cotacaoRepositorio = new CotacaoRepositorio();

    public Map<String, BigDecimal> consultar() throws Exception {

        try (Connection conexao = Conexao.abrir()) {
            return cotacaoRepositorio.listar(conexao);
        }
    }

    public Map<String, BigDecimal> atualizar() throws Exception {

        try (Connection conexao = Conexao.abrir()) {

            conexao.setAutoCommit(false);

            try {

                String[] moedas = {"BTC", "ETH", "XRP"};

                for (String moeda : moedas) {

                    BigDecimal cotacaoAnterior = cotacaoRepositorio.buscar(conexao, moeda, true);

                    double variacao = ThreadLocalRandom.current().nextDouble(-0.05, 0.05);

                    BigDecimal fator = BigDecimal.ONE.add(BigDecimal.valueOf(variacao));

                    BigDecimal novaCotacao = cotacaoAnterior.multiply(fator)
                            .setScale(8, RoundingMode.HALF_UP);

                    if (novaCotacao.compareTo(BigDecimal.ZERO) <= 0) {
                        throw new IllegalArgumentException("Cotação inválida");
                    }

                    cotacaoRepositorio.atualizar(conexao, moeda, novaCotacao);
                }

                Map<String, BigDecimal> cotacoesAtualizadas = cotacaoRepositorio.listar(conexao);

                conexao.commit();

                return cotacoesAtualizadas;

            } catch (Exception erro) {

                conexao.rollback();
                throw erro;
            }
        }
    }
}