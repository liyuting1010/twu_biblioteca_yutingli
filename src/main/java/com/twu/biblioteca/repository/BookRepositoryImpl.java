package com.twu.biblioteca.repository;

import com.twu.biblioteca.books.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final Connection dbConnection;

    @Autowired
    public BookRepositoryImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();

        try {
            ResultSet resultSet = dbConnection.createStatement().executeQuery("SELECT id, name, author, publication_year FROM books");
            while (resultSet.next()) {
                bookList.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("publication_year")
                ));
            }
            return bookList;
        } catch (SQLException e) {
            throw new IllegalStateException("could not get all book name list", e);
        }
    }

    @Override
    public Book getById(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("SELECT name, author, publication_year FROM books WHERE id = ?")) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Book(id, resultSet.getString("name"), resultSet.getString("author"), resultSet.getInt("publication_year"));
            } else {
                throw new IllegalArgumentException("Could not find the book by id = " + id.toString());
            }
        } catch (final SQLException e) {
            throw new IllegalStateException("error while looking up a book. ", e);
        }
    }

    @Override
    public Integer checkout(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("UPDATE books SET count = count - 1 WHERE id = ?")) {
            statement.setInt(1, id);

            return statement.executeUpdate();
        } catch (final SQLException e) {
            throw new IllegalStateException("error while lend book. No available book", e);
        }
    }

    @Override
    public Integer getCount(Integer id) {
        try (final PreparedStatement queryStatement = dbConnection.prepareStatement("SELECT count FROM books WHERE id = ?")) {
            queryStatement.setInt(1, id);
            ResultSet resultSet = queryStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("count");
            } else {
                throw new IllegalStateException("error while lend book");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("error while search book amount. ", e);
        }

    }

    @Override
    public Integer returnBook(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("UPDATE books SET count = count + 1 WHERE id = ?")) {
            statement.setInt(1, id);

            return statement.executeUpdate();
        } catch (final SQLException e) {
            throw new IllegalStateException("error while return book. ", e);
        }
    }
}
