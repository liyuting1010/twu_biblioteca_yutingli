package com.twu.biblioteca.users.records;

import java.util.List;

@FunctionalInterface
public interface RecordsService {
    List<Record> get(String username);
}
