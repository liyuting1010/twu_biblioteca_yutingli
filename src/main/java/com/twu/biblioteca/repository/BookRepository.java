package com.twu.biblioteca.repository;

import com.twu.biblioteca.books.Record;

import java.util.List;

public interface BookRepository {
    List<Record> getAll();
    Record getById(Integer id);
    Integer checkout(Integer id);
    Integer getCount(Integer id);
}
