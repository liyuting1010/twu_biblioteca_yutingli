package com.twu.biblioteca.books;

public class Book {
    private final Integer id;
    private final String name;
    private final String author;
    private final Integer publicationYear;

    public Book(Integer id, String name, String author, Integer publicationYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }
}
