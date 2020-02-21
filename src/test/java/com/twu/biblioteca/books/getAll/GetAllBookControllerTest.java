package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllBookControllerTest {

    @Test
    public void shouldReturn200WithBookNameListWhenGetAllBookSuccess() {
        List<Book> bookList = Collections.singletonList(new Book(1, "some_name", "some_author"));
        GetAllBookService getAllBookService = () -> bookList;

        ResponseEntity response = new GetAllBookController(getAllBookService).getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookList, response.getBody());
    }

    @Test
    public void shouldReturn500WhenGetAllBookFailed() {
        String errorMessage = "some error";

        GetAllBookService getAllBookService = () -> {
            throw new IllegalStateException(errorMessage);
        };

        ResponseEntity response = new GetAllBookController(getAllBookService).getAllBooks();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }
}
