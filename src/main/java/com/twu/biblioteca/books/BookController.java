package com.twu.biblioteca.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAllBookName")
    public ResponseEntity getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllName());
    }
}
