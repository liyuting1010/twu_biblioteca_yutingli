package com.twu.biblioteca.books.returnBook;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class ReturnBookControllerTest {
    @Test
    public void shouldReturn200WithSuccessMessageWhenReturnABookSuccess() {
        String message = "some message";
        ReturnBookService returnBookService = id -> message;

        ResponseEntity response = new ReturnBookController(returnBookService).returnBook(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void shouldReturn500WhenReturnABookFailed() {
        String errorMessage = "some error";

        ReturnBookService returnBookService = id -> {
            throw new IllegalStateException(errorMessage);
        };

        ResponseEntity response = new ReturnBookController(returnBookService).returnBook(1);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }
}
