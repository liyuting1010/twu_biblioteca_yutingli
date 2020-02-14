package com.twu.bibiloteca.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class WriteRepositoryImpl implements WriteRepository {
    private final Connection dbConnection;

    @Autowired
    public WriteRepositoryImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<String> getAllName() {
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM books");
            List<String> nameList = new ArrayList<>();

            while(resultSet.next()) {
                nameList.add(resultSet.getString("name"));
            }
            return nameList;
        } catch (SQLException e) {
            throw new IllegalStateException("could not select the books table", e);
        }
    }
}
