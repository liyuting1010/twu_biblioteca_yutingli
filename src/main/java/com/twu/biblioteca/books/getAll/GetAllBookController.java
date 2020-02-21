package com.twu.biblioteca.books.getAll;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllBookController {
    private final GetAllBookService getAllBookService;

    public GetAllBookController(GetAllBookService getAllBookService) {
        this.getAllBookService = getAllBookService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllBooks() {
        try {
            return ResponseEntity.ok().body(getAllBookService.getAllBook());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
