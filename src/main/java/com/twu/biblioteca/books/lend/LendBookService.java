package com.twu.biblioteca.books.lend;

@FunctionalInterface
public interface LendBookService {
    String lend(Integer id, String username);
}
