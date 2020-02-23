package com.twu.biblioteca.books.lend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendBookController {
    private final LendBookService lendBookService;

    public LendBookController(LendBookService lendBookService) {
        this.lendBookService = lendBookService;
    }

    @PostMapping("/lend/{id}")
    public ResponseEntity lendBookById(@PathVariable("id") Integer bookId,
                                       @RequestParam String username) {
        try{
            return ResponseEntity.ok().body(lendBookService.lend(bookId, username));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
