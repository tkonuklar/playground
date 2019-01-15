package com.example.domain;


import com.example.jooq.tables.records.AuthorsRecord;
import com.example.jooq.tables.records.BooksRecord;
import org.jooq.Record;

import java.util.List;

import static com.example.jooq.Tables.AUTHORS;
import static com.example.jooq.Tables.BOOKS;
import static java.util.Arrays.asList;

public class AuthorsAndBooks {

    private String firstName;
    private String lastName;
    private List<Books> books;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }


    public static AuthorsAndBooks toMap(Record record) {
        AuthorsAndBooks dto = new AuthorsAndBooks();
        BooksRecord books = record.into(BOOKS);
        AuthorsRecord authorsRecord = record.into(AUTHORS);
        dto.setBooks(asList(Books.toMap(books)));
        dto.setFirstName(authorsRecord.getFirstName());
        dto.setLastName(authorsRecord.getLastName());
        return dto;
    }
}
