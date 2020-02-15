package com.twu.biblioteca.books.getAll;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllController {
    private final GetAllService getAllService;

    public GetAllController(GetAllService getAllService) {
        this.getAllService = getAllService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllBooks() {
        try {
            return ResponseEntity.ok().body(getAllService.getAllBook());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
