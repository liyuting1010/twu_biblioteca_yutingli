package com.twu.biblioteca.repository;

import com.twu.biblioteca.users.records.Record;

import java.util.List;

public interface RecordRepository {
    List<Record> getRecordsById(String username);
}
