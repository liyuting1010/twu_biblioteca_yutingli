package com.twu.biblioteca.books.lend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendController {
    private final LendService lendService;

    public LendController(LendService lendService) {
        this.lendService = lendService;
    }

    @PostMapping("/lend/{id}")
    public ResponseEntity lendBookById(@PathVariable Integer id) {
        try{
            lendService.lend(id);
            return ResponseEntity.ok().body("Successfully lend the book with id = " + id.toString());
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
