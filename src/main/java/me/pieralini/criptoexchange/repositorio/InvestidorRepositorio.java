package me.pieralini.criptoexchange.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import me.pieralini.criptoexchange.modelo.Investidor;

public class InvestidorRepositorio {

    public Investidor buscarPorCpf(Connection conexao, String cpf) throws SQLException {

        String sql = "SELECT id, nome, cpf, senha_hash FROM investidores WHERE cpf = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, cpf);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
                    return new Investidor(
                        resultado.getLong("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getString("senha_hash")
                    );
                }
            }
        }

        return null;
    }

    public long cadastrar(Connection conexao, String nome, String cpf, String senhaHash) throws SQLException {

        String sql = "INSERT INTO investidores (nome, cpf, senha_hash) VALUES (?, ?, ?) RETURNING id";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, nome);
            comando.setString(2, cpf);
            comando.setString(3, senhaHash);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
                    return resultado.getLong("id");
                }
            }
        }

        throw new SQLException("Não foi possível cadastrar o investidor");
    }
}