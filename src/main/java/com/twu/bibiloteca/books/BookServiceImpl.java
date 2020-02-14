package com.twu.bibiloteca.books;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final WriteRepository writeRepository;

    public BookServiceImpl(WriteRepository writeRepository) {
        this.writeRepository = writeRepository;
    }

    @Override
    public List<String> getAllName() {
        return writeRepository.getAllName();
    }
}
