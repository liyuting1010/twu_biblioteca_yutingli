package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
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
        return new BookRepositoryImpl(dbConnection).getAll();
    }
}
