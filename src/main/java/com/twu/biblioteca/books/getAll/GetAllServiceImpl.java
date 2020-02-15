package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.getAll.GetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllServiceImpl implements GetAllService {

    private final Connection dbConnection;

    @Autowired
    public GetAllServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<String> getAllName() {
        List<String> nameList = new ArrayList<>();

        try {
            ResultSet resultSet = dbConnection.createStatement().executeQuery("SELECT name FROM books");
            while (resultSet.next()) {
                nameList.add(resultSet.getString("name"));
            }
            return nameList;
        } catch (SQLException e) {
            throw new IllegalStateException("could not get all book name list", e);
        }
    }
}
