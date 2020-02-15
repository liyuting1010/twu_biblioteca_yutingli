package com.twu.biblioteca.books.getOne;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class GetOneBookControllerTest {

    @Test
    public void shouldReturn200WhenCallGetBookById() {
        Book book = new Book(1, "some_name", "some_author");
        GetOneBookService getOneBookService = id -> book;

        ResponseEntity response = new GetOneBookController(getOneBookService).getBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }
}
