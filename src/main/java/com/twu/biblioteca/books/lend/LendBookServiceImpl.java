package com.twu.biblioteca.books.lend;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import com.twu.biblioteca.repository.RecordRepository;
import com.twu.biblioteca.repository.RecordRepositoryImpl;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class LendBookServiceImpl implements LendBookService {

    private final Connection dbConnection;

    @Autowired
    public LendBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String lend(Integer bookId, String username) {
        BookRepository bookRepository = new BookRepositoryImpl(dbConnection);
        UserRepository userRepository = new UserRepositoryImpl(dbConnection);
        RecordRepository recordRepository = new RecordRepositoryImpl(dbConnection);

        int bookAffected = bookRepository.checkout(bookId);
        int userId = userRepository.getUserId(username);
        int recordAffected = recordRepository.addLendRecord(userId, bookId);
        if (bookAffected == 1 && recordAffected == 1) {
            Integer count = bookRepository.getCount(bookId);
            return String.format("Successfully lend the book with bookId = %d. Available book amount = %d", bookId, count);
        } else {
            throw new IllegalArgumentException("No such book with bookId = " + bookId);
        }
    }
}
