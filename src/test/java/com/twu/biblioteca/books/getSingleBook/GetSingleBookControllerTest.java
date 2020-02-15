package com.twu.biblioteca.books.getSingleBook;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.getSingleBook.GetSingleBookController;
import com.twu.biblioteca.books.getSingleBook.GetSingleBookService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class GetSingleBookControllerTest {

    @Test
    public void shouldReturn200WhenCallGetBookById() {
        GetSingleBookService getSingleBookService = id -> new Book(1, "some_name", "some_author");

        ResponseEntity response = new GetSingleBookController(getSingleBookService).getBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
