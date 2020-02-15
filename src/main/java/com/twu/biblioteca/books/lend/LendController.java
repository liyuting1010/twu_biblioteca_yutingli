package com.twu.biblioteca.books.lend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendController {

    @PostMapping("/lend/{id}")
    public ResponseEntity lendBookById(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }
}
