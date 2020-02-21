package com.twu.biblioteca.books.returnBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class ReturnBookServiceImpl implements ReturnBookService {

    private final Connection dbConnection;

    @Autowired
    public ReturnBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String returnBook(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("UPDATE books SET count = count + 1 WHERE id = ?")) {
            statement.setInt(1, id);

            int rowAffected = statement.executeUpdate();
            if (rowAffected == 0) {
                throw new IllegalArgumentException("No such book with id = " + id);
            } else
                return "Successfully return a book with id = " + id;
        } catch (final SQLException e) {
            throw new IllegalStateException("error while return book. ", e);
        }
    }
}
