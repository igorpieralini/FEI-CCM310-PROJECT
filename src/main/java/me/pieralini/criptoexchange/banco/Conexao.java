package me.pieralini.criptoexchange.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USUARIO = "postgres.keugypauglpabfytuvbq";
    private static final String SENHA = "Stepro2020#@#";

    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}