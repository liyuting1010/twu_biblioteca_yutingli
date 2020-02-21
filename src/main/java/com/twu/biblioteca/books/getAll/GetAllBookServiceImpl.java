package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllBookServiceImpl implements GetAllBookService {

    private final Connection dbConnection;

    @Autowired
    public GetAllBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = new ArrayList<>();

        try {
            ResultSet resultSet = dbConnection.createStatement().executeQuery("SELECT id, name, author FROM books");
            while (resultSet.next()) {
                bookList.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author")
                ));
            }
            return bookList;
        } catch (SQLException e) {
            throw new IllegalStateException("could not get all book name list", e);
        }
    }
}
