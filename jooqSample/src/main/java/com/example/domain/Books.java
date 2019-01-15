package com.example.domain;

import com.example.jooq.tables.records.BooksRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jooq.Record;

public class Books {
    @JsonIgnore
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Books toMap(Record record) {
        if (record instanceof BooksRecord) {
            BooksRecord booksRecord = (BooksRecord) record;
            Books dto = new Books();
            dto.setTitle(booksRecord.getTitle());
            return dto;
        }
        return null;
    }
}
