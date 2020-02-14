package com.twu.biblioteca.db;

import java.sql.Connection;

@FunctionalInterface
public interface DBConnector {
    Connection getConnection();
}
