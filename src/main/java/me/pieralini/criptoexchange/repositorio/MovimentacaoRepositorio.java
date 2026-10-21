package me.pieralini.criptoexchange.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import me.pieralini.criptoexchange.modelo.Carteira;
import me.pieralini.criptoexchange.modelo.Movimentacao;

public class MovimentacaoRepositorio {

    public void registrar(Connection conexao, long id, String tipo, String moeda,
                         BigDecimal valor, BigDecimal cotacao, BigDecimal taxa,
                         Carteira saldo) throws SQLException {

        String sql = "INSERT INTO movimentacoes "
                + "(investidor_id, tipo, moeda, valor, cotacao, taxa, "
                + "saldo_reais, saldo_btc, saldo_eth, saldo_xrp) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, id);
            comando.setString(2, tipo);
            comando.setString(3, moeda);
            comando.setBigDecimal(4, valor);
            comando.setBigDecimal(5, cotacao);
            comando.setBigDecimal(6, taxa);
            comando.setBigDecimal(7, saldo.getReais());
            comando.setBigDecimal(8, saldo.getBitcoin());
            comando.setBigDecimal(9, saldo.getEthereum());
            comando.setBigDecimal(10, saldo.getRipple());

            comando.executeUpdate();
        }
    }

    public List<Movimentacao> listar(Connection conexao, long id) throws SQLException {

        List<Movimentacao> movimentacoes = new ArrayList<>();

        String sql = "SELECT data_hora, tipo, moeda, valor, cotacao, taxa, "
                + "saldo_reais, saldo_btc, saldo_eth, saldo_xrp "
                + "FROM movimentacoes WHERE investidor_id = ? "
                + "ORDER BY data_hora, id";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, id);

            try (ResultSet resultado = comando.executeQuery()) {

                while (resultado.next()) {

                    Movimentacao movimentacao = new Movimentacao(
                        resultado.getTimestamp("data_hora").toLocalDateTime(),
                        resultado.getString("tipo"),
                        resultado.getString("moeda"),
                        resultado.getBigDecimal("valor"),
                        resultado.getBigDecimal("cotacao"),
                        resultado.getBigDecimal("taxa"),
                        resultado.getBigDecimal("saldo_reais"),
                        resultado.getBigDecimal("saldo_btc"),
                        resultado.getBigDecimal("saldo_eth"),
                        resultado.getBigDecimal("saldo_xrp")
                    );

                    movimentacoes.add(movimentacao);
                }
            }
        }

        return movimentacoes;
    }
}