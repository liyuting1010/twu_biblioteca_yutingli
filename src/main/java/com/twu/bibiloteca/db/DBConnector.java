package com.twu.bibiloteca.db;

import java.sql.Connection;

@FunctionalInterface
public interface DBConnector {
    Connection getConnection();
}
