package com.twu.biblioteca.books;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookControllerTest {
    @Test
    public void shouldReturn200WithBookNameListWhenCallGetAllBookNameEndpoint() {
        List<String> bookNameList = Arrays.asList("some_book_1", "some_book_2");
        BookService bookService = () -> bookNameList;
        ResponseEntity response = new BookController(bookService).getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookNameList, response.getBody());
    }
}
