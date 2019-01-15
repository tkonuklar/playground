package com.example.domain;


import com.example.jooq.tables.records.AuthorsRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jooq.Record;

public class Authors {

    @JsonIgnore
    private int id;
    private String firstName;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public static Authors toMap(Record record) {
        if (record instanceof AuthorsRecord) {
            AuthorsRecord authorsRecord = (AuthorsRecord) record;
            Authors dto = new Authors();
            dto.setFirstName(authorsRecord.getFirstName());
            dto.setId(authorsRecord.getId());
            dto.setLastName(authorsRecord.getLastName());
            return dto;
        }
        return null;
    }
}
