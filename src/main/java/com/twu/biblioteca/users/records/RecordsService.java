package com.twu.biblioteca.users.records;

import com.twu.biblioteca.books.Book;

import java.util.List;

@FunctionalInterface
public interface RecordsService {
    List<Book> get(Integer userId);
}
