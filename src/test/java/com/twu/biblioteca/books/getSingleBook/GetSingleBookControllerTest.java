package com.twu.biblioteca.books.getSingleBook;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class GetSingleBookControllerTest {

    @Test
    public void shouldReturn200WhenCallGetBookById() {
        Book book = new Book(1, "some_name", "some_author");
        GetSingleBookService getSingleBookService = id -> book;

        ResponseEntity response = new GetSingleBookController(getSingleBookService).getBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }
}
