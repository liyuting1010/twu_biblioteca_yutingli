package com.twu.biblioteca.books;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookServiceImplTest {
    @Test
    public void shouldReturnListOfBookNameWhenDbExecutionSuccess() throws SQLException {
        String testName = "some_book_name";

        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultSet.getString("name")).thenReturn(testName);

        Statement statement = Mockito.mock(Statement.class);
        Mockito.when(statement.executeQuery("SELECT name FROM books")).thenReturn(mockResultSet);

        Connection jdbcConnection = Mockito.mock(Connection.class);
        Mockito.when(jdbcConnection.createStatement()).thenReturn(statement);

        List<String> allBookName = new BookServiceImpl(jdbcConnection).getAllName();

        assertEquals(Collections.singletonList(testName), allBookName);
    }
}
