package com.twu.biblioteca.books.returnBook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnBookController {

    private final ReturnBookService returnBookService;

    public ReturnBookController(ReturnBookService returnBookService) {
        this.returnBookService = returnBookService;
    }

    @PostMapping("/return/{id}")
    public ResponseEntity returnBook(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok().body(returnBookService.returnBook(id));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
