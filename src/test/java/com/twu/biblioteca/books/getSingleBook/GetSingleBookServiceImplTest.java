package com.twu.biblioteca.books.getSingleBook;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class GetSingleBookServiceImplTest {
    private Connection jdbcConnection = Mockito.mock(Connection.class);
    private ResultSet mockResultSet = Mockito.mock(ResultSet.class);
    private PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

    @Test
    public void shouldReturnListOfBookNameWhenDbExecutionSuccess() throws SQLException {
        Book testBook = new Book(1, "some_book_name", "some_author");

        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultSet.getString("name")).thenReturn(testBook.getName());
        Mockito.when(mockResultSet.getString("author")).thenReturn(testBook.getAuthor());

        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(jdbcConnection.prepareStatement("SELECT name, author FROM books WHERE id = ?")).thenReturn(preparedStatement);
        Mockito.when(preparedStatement.executeQuery()).thenReturn(mockResultSet);

        Book book = new GetSingleBookServiceImpl(jdbcConnection).getBookById(1);

        assertEquals(testBook.getId(), book.getId());
        assertEquals(testBook.getName(), book.getName());
        assertEquals(testBook.getAuthor(), book.getAuthor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNoBookReturn() throws SQLException {

        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockResultSet.next()).thenReturn(false);
        Mockito.when(jdbcConnection.prepareStatement("SELECT name, author FROM books WHERE id = ?")).thenReturn(preparedStatement);
        Mockito.when(preparedStatement.executeQuery()).thenReturn(mockResultSet);

        new GetSingleBookServiceImpl(jdbcConnection).getBookById(1);
    }
}
