package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllControllerTest {

    @Test
    public void shouldReturn200WithBookNameListWhenCallGetAllBookNameEndpoint() {
        List<Book> bookList = Collections.singletonList(new Book(1, "some_name", "some_author"));
        GetAllService getAllService = () -> bookList;

        ResponseEntity response = new GetAllController(getAllService).getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookList, response.getBody());
    }
}
