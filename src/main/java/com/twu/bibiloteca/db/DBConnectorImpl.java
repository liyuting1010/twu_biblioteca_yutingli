package com.twu.bibiloteca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DBConnectorImpl implements DBConnector {

    @Override
    public Connection getConnection() {
        Map<String, String> envs = System.getenv();

        String dbJdbcUrl = envs.get("DB_JDBC_URL");
        String dbUsername = envs.get("DB_USERNAME");
        String dbPassword = envs.get("DB_PASSWORD");

        try {
            return DriverManager.getConnection(dbJdbcUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new IllegalArgumentException("db connection failed", e);
        }
    }
}
