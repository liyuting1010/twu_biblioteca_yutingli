package com.twu.biblioteca.users.records;

import java.sql.Timestamp;

public class Record {
    private final Integer bookId;
    private final Integer userId;
    private final String bookName;
    private final Timestamp borrowDate;
    private final Timestamp returnDate;

    public Record(Integer bookId, Integer userId, String bookName, Timestamp borrowDate, Timestamp returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getBookName() {
        return bookName;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }
}
