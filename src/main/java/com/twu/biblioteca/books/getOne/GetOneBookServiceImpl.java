package com.twu.biblioteca.books.getOne;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class GetOneBookServiceImpl implements GetOneBookService {

    private final Connection dbConnection;

    @Autowired
    public GetOneBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public Book getBookById(Integer id) {
        return new BookRepositoryImpl(dbConnection).getById(id);
    }
}
