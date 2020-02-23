package com.twu.biblioteca.books.lend;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImpl;
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
    public String lend(Integer id) {
        BookRepository bookRepository = new BookRepositoryImpl(dbConnection);

        int rowAffected = bookRepository.checkout(id);
        if (rowAffected == 1) {
            Integer count = bookRepository.getCount(id);
            return String.format("Successfully lend the book with id = %d. Available book amount = %d", id, count);
        } else {
            throw new IllegalArgumentException("No such book with id = " + id);
        }
    }
}
