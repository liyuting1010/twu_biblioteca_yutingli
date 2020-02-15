package com.twu.biblioteca.books.getOne;

import com.twu.biblioteca.books.Book;

@FunctionalInterface
public interface GetOneBookService {
    Book getBookById(Integer id);
}
