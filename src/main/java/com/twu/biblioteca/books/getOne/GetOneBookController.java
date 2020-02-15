package com.twu.biblioteca.books.getOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOneBookController {
    private final GetOneBookService getOneBookService;

    public GetOneBookController(GetOneBookService getOneBookService) {
        this.getOneBookService = getOneBookService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBookById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(getOneBookService.getBookById(id));
    }
}
