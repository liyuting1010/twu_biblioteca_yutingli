package com.twu.biblioteca.users.records;

import com.twu.biblioteca.repository.RecordRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService {
    private final Connection dbConnection;

    @Autowired
    public RecordsServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Record> get(String username) {
        return new RecordRepositoryImpl(dbConnection).getRecordsById(username);
    }
}
