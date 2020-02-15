package com.twu.biblioteca.books.getSingleBook;

import com.twu.biblioteca.books.Book;

@FunctionalInterface
public interface GetSingleBookService {
    Book getBookById(Integer id);
}
