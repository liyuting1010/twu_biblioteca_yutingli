package com.twu.biblioteca.books.getOne;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class GetOneBookControllerTest {

    @Test
    public void shouldReturn200WhenGetBookByIdSuccess() {
        Book book = new Book(1, "some_name", "some_author");
        GetOneBookService getOneBookService = id -> book;

        ResponseEntity response = new GetOneBookController(getOneBookService).getBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    public void shouldReturn400WhenIdNotExist() {
        String errorMessage = "some error";
        GetOneBookService getOneBookService = id -> {
            throw new IllegalArgumentException(errorMessage);
        };

        ResponseEntity response = new GetOneBookController(getOneBookService).getBookById(1);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }

    @Test
    public void shouldReturn500WhenGetBookByIdFailed() {
        String errorMessage = "some error";
        GetOneBookService getOneBookService = id -> {
            throw new IllegalStateException(errorMessage);
        };

        ResponseEntity response = new GetOneBookController(getOneBookService).getBookById(1);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }
}
