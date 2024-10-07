package com.example.Config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String URL = "jdbc:postgresql://localhost:5432/nome_do_banco";
    private static final String USER = "usuario";
    private static final String PASSWORD = "senha";

    public static java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o PostgreSQL", e);
        }
    }
}
