package com.twu.biblioteca.books.lend;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class LendControllerTest {
    @Test
    public void shouldReturn200WhenLendABookById() {
        ResponseEntity response = new LendController().lendBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
