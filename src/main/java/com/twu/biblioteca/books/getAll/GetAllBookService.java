package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.Book;

import java.util.List;

@FunctionalInterface
public interface GetAllBookService {
    List<Book> getAllBook();
}
