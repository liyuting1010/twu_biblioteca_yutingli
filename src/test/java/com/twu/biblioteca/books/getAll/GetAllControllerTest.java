package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.getAll.GetAllController;
import com.twu.biblioteca.books.getAll.GetAllService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllControllerTest {

    @Test
    public void shouldReturn200WithBookNameListWhenCallGetAllBookNameEndpoint() {
        List<String> bookNameList = Arrays.asList("some_book_1", "some_book_2");
        GetAllService getAllService = () -> bookNameList;

        ResponseEntity response = new GetAllController(getAllService).getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookNameList, response.getBody());
    }
}
