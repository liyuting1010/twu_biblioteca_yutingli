package com.twu.biblioteca.repository;

import com.twu.biblioteca.books.Record;

import java.util.List;

public interface RecordRepository {
    List<Record> getRecordsById(Integer userId);
}
