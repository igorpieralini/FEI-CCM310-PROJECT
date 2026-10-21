package me.pieralini.criptoexchange.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CotacaoRepositorio {

    public Map<String, BigDecimal> listar(Connection conexao) throws SQLException {

        Map<String, BigDecimal> cotacoes = new LinkedHashMap<>();

        String sql = "SELECT moeda, valor FROM cotacoes ORDER BY moeda";

        try (PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                String moeda = resultado.getString("moeda");
                BigDecimal valor = resultado.getBigDecimal("valor");

                cotacoes.put(moeda, valor);
            }
        }

        return cotacoes;
    }

    public BigDecimal buscar(Connection conexao, String moeda, boolean bloquear) throws SQLException {

        String sql = "SELECT valor FROM cotacoes WHERE moeda = ?";

        if (bloquear) {
            sql += " FOR UPDATE";
        }

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, moeda);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
                    return resultado.getBigDecimal("valor");
                }
            }
        }

        throw new SQLException("Cotação não encontrada: " + moeda);
    }

    public void atualizar(Connection conexao, String moeda, BigDecimal valor) throws SQLException {

        String sql = "UPDATE cotacoes SET valor = ?, atualizada_em = NOW() WHERE moeda = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setBigDecimal(1, valor);
            comando.setString(2, moeda);

            int linhasAlteradas = comando.executeUpdate();

            if (linhasAlteradas != 1) {
                throw new SQLException("Cotação não atualizada");
            }
        }
    }
}