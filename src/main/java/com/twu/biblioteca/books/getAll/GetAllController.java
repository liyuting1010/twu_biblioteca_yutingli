package com.twu.biblioteca.books.getAll;

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
        return ResponseEntity.ok().body(getAllService.getAllName());
    }
}
