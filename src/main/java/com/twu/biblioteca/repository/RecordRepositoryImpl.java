package com.twu.biblioteca.repository;

import com.twu.biblioteca.users.records.Record;
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
    public List<Record> getRecordsById(String username) {
        List<Record> recordList = new ArrayList<>();
        try (final PreparedStatement statement = dbConnection.prepareStatement(
                "SELECT books.id, books.name, borrow_records.borrow_date, borrow_records.return_date " +
                        "FROM borrow_records JOIN books ON books.id = borrow_records.bid " +
                        "JOIN users ON users.id = borrow_records.uid " +
                        "WHERE users.username = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Record record = new Record(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("borrow_date"),
                        resultSet.getTimestamp("return_date")
                );
                recordList.add(record);
            }
            return recordList;
        } catch (final SQLException e) {
            throw new IllegalStateException("error while get user record. ", e);
        }
    }

    @Override
    public Integer addLendRecord(Integer userId, Integer bookId) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO borrow_records(uid, bid, borrow_date, return_date) VALUES (?, ?, now(), NULL)")) {
            statement.setInt(1, userId);
            statement.setInt(2, bookId);

            return statement.executeUpdate();
        } catch (final SQLException e) {
            throw new IllegalStateException("error while add record.", e);
        }
    }

    @Override
    public Integer updateReturnRecord(Integer userId, Integer bookId) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("UPDATE borrow_records SET return_date = now() WHERE uid = ? AND bid = ?")) {
            statement.setInt(1, userId);
            statement.setInt(2, bookId);

            return statement.executeUpdate();
        } catch (final SQLException e) {
            throw new IllegalStateException("error while add record.", e);
        }
    }
}
