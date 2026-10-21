package me.pieralini.criptoexchange.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import me.pieralini.criptoexchange.modelo.Carteira;

public class CarteiraRepositorio {

    public Carteira buscar(Connection conexao, long investidorId, boolean bloquear) throws SQLException {

        String sql = "SELECT reais, btc, eth, xrp FROM carteiras WHERE investidor_id = ?";

        if (bloquear) {
            sql += " FOR UPDATE";
        }

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, investidorId);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
                    return new Carteira(
                        resultado.getBigDecimal("reais"),
                        resultado.getBigDecimal("btc"),
                        resultado.getBigDecimal("eth"),
                        resultado.getBigDecimal("xrp")
                    );
                }
            }
        }

        throw new SQLException("Carteira não encontrada");
    }

    public void criar(Connection conexao, long investidorId) throws SQLException {

        String sql = "INSERT INTO carteiras (investidor_id) VALUES (?)";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, investidorId);
            comando.executeUpdate();
        }
    }

    public void salvar(Connection conexao, long investidorId, Carteira carteira) throws SQLException {

        String sql = "UPDATE carteiras SET reais = ?, btc = ?, eth = ?, xrp = ? WHERE investidor_id = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setBigDecimal(1, carteira.getReais());
            comando.setBigDecimal(2, carteira.getBitcoin());
            comando.setBigDecimal(3, carteira.getEthereum());
            comando.setBigDecimal(4, carteira.getRipple());
            comando.setLong(5, investidorId);

            int linhasAlteradas = comando.executeUpdate();

            if (linhasAlteradas != 1) {
                throw new SQLException("Carteira não atualizada");
            }
        }
    }
}