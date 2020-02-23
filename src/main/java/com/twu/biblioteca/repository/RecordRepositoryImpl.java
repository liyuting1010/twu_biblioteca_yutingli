package com.twu.biblioteca.repository;

import com.twu.biblioteca.books.Record;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordRepositoryImpl implements RecordRepository {
    private final Connection dbConnection;

    @Autowired
    public RecordRepositoryImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Record> getRecordsById(Integer userId) {
        List<com.twu.biblioteca.books.Record> recordList = new ArrayList<>();
        try (final PreparedStatement statement = dbConnection.prepareStatement("SELECT books.id, books.name, borrow_records.borrow_date, borrow_records.return_date FROM borrow_records JOIN books ON books.id = borrow_records.bid WHERE uid = ?")) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                com.twu.biblioteca.books.Record record = new com.twu.biblioteca.books.Record(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("borrow_date"),
                        resultSet.getInt("return_date")
                );
                recordList.add(record);
            }
            return recordList;
        } catch (final SQLException e) {
            throw new IllegalStateException("error while get user record. ", e);
        }
    }
}
