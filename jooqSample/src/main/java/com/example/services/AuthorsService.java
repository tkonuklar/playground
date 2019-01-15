package com.example.services;

import com.example.domain.Authors;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.jooq.Tables.AUTHORS;


@Service
public class AuthorsService {

    @Autowired
    private DSLContext dsl;

    public List<Authors> findAllAuthors() {
        return dsl.selectFrom(AUTHORS).fetchInto(AUTHORS)
                .stream()
                .map(Authors::toMap).collect(Collectors.toList());
    }

    public Optional<Authors> findById(int id) {
        return dsl.selectFrom(AUTHORS)
                .where(AUTHORS.ID.eq(id))
                .fetch()
                .stream()
                .map(Authors::toMap)
                .findFirst();
    }

    public void createAuthor(Authors request) {
        dsl.insertInto(AUTHORS)
                .set(AUTHORS.ID, request.getId())
                .set(AUTHORS.FIRST_NAME, request.getFirstName())
                .set(AUTHORS.LAST_NAME, request.getLastName())
                .execute();
    }
}
