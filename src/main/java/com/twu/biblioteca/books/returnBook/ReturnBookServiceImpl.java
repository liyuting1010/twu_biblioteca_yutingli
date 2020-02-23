package com.twu.biblioteca.books.returnBook;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import com.twu.biblioteca.repository.RecordRepository;
import com.twu.biblioteca.repository.RecordRepositoryImpl;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
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
    public String returnBook(Integer bookId, String username) {
        BookRepository bookRepository = new BookRepositoryImpl(dbConnection);
        UserRepository userRepository = new UserRepositoryImpl(dbConnection);
        RecordRepository recordRepository = new RecordRepositoryImpl(dbConnection);

        Integer bookAffected = bookRepository.returnBook(bookId);
        Integer userId = userRepository.getUserId(username);
        Integer recordAffected = recordRepository.updateReturnRecord(userId, bookId);

        if (bookAffected == 0 || recordAffected == 0) {
            throw new IllegalArgumentException("No such book with id = " + bookId);
        } else
            return "Successfully return a book with id = " + bookId;
    }
}
