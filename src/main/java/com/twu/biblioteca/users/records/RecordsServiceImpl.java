package com.twu.biblioteca.users.records;

import com.twu.biblioteca.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService {
    private final Connection dbConnection;

    @Autowired
    public RecordsServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Book> get(Integer userId) {
        List<Book> recordList = new ArrayList<>();
        try (final PreparedStatement statement = dbConnection.prepareStatement("SELECT books.id, books.name, books.author, book.publication_year FROM borrow_records JOIN books ON books.id = borrow_records.bid WHERE uid = ?")) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("publication_year")
                );
                recordList.add(book);
            }
            return recordList;
        } catch (final SQLException e) {
            throw new IllegalStateException("error while get book record. ", e);
        }
    }
}
