package com.twu.biblioteca;

import com.twu.biblioteca.db.DBConnectorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class BeanConfiguration {

    @Bean
    public Connection dbConnection() {
        DBConnectorImpl connector = new DBConnectorImpl();
        return connector.getConnection();
    }
}
