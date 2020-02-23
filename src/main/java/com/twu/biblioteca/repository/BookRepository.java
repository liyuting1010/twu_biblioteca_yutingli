package com.twu.biblioteca.repository;

import com.twu.biblioteca.books.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();
    Book getById(Integer id);
    Integer checkout(Integer id);
    Integer getCount(Integer id);
}
