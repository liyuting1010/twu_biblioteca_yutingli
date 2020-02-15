package com.twu.biblioteca.books.getSingleBook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSingleBookController {
    private final GetSingleBookService getSingleBookService;

    public GetSingleBookController(GetSingleBookService getSingleBookService) {
        this.getSingleBookService = getSingleBookService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBookById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().build();
    }
}
