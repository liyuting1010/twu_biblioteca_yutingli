package com.twu.biblioteca.books.lend;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class LendBookControllerTest {
    @Test
    public void shouldReturn200WithSuccessMessageWhenLendABookSuccess() {
        String message = "some message";
        LendBookService lendBookService = id -> message;

        ResponseEntity response = new LendBookController(lendBookService).lendBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void shouldReturn500WhenLendABookFailed() {
        String errorMessage = "some error";

        LendBookService lendBookService = id -> {
            throw new IllegalStateException(errorMessage);
        };

        ResponseEntity response = new LendBookController(lendBookService).lendBookById(1);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }
}
