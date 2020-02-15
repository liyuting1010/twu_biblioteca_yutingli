package com.twu.biblioteca.books.getSingleBook;

import com.twu.biblioteca.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GetSingleBookServiceImpl implements GetSingleBookService {

    private final Connection dbConnection;

    @Autowired
    public GetSingleBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public Book getBookById(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("SELECT name, author FROM books WHERE id = ?")) {
            statement.setString(1, id.toString());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Book(id, resultSet.getString("name"), resultSet.getString("author"));
            } else {
                throw new IllegalArgumentException("Could not find the book by id = " + id.toString());
            }
        } catch (final SQLException e) {
            throw new IllegalStateException("error while looking up book. ", e);
        }
    }
}
