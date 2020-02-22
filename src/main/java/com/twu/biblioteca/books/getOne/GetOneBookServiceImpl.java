package com.twu.biblioteca.books.getOne;

import com.twu.biblioteca.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GetOneBookServiceImpl implements GetOneBookService {

    private final Connection dbConnection;

    @Autowired
    public GetOneBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public Book getBookById(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("SELECT name, author, publication_year FROM books WHERE id = ?")) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Book(id, resultSet.getString("name"), resultSet.getString("author"), resultSet.getInt("publication_year"));
            } else {
                throw new IllegalArgumentException("Could not find the book by id = " + id.toString());
            }
        } catch (final SQLException e) {
            throw new IllegalStateException("error while looking up book. ", e);
        }
    }
}
