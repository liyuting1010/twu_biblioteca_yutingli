package com.twu.biblioteca.books.getAll;

import com.twu.biblioteca.books.Book;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllBookServiceImplTest {
    @Test
    public void shouldReturnListOfBookWhenDbExecutionSuccess() throws SQLException {
        String testName = "some_book_name";
        String testAuthor = "some_author";

        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultSet.getString("name")).thenReturn(testName);
        Mockito.when(mockResultSet.getString("author")).thenReturn(testAuthor);

        Statement statement = Mockito.mock(Statement.class);
        Mockito.when(statement.executeQuery("SELECT id, name, author, publication_year FROM books")).thenReturn(mockResultSet);

        Connection jdbcConnection = Mockito.mock(Connection.class);
        Mockito.when(jdbcConnection.createStatement()).thenReturn(statement);

        List<Book> allBook = new GetAllBookServiceImpl(jdbcConnection).getAllBook();

        assertEquals(testName, allBook.get(0).getName());
        assertEquals(testAuthor, allBook.get(0).getAuthor());
    }
}
