package com.example.services;

import com.example.domain.AuthorsAndBooks;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.jooq.Tables.*;


@Service
public class AuthorsAndBooksService {

    @Autowired
    private DSLContext dsl;

   public List<AuthorsAndBooks> findAll() {
        return dsl.select(AUTHORS.FIRST_NAME, AUTHORS.LAST_NAME, BOOKS.TITLE)
                .from(AUTHORS)
                .join(AUTHORBOOK)
                .on(AUTHORS.ID.eq(AUTHORBOOK.AUTHOR_ID))
                .join(BOOKS)
                .on(AUTHORBOOK.BOOK_ID.eq(BOOKS.ID))
                .fetch().stream().map(AuthorsAndBooks::toMap).collect(Collectors.toList());
    }

    public List<AuthorsAndBooks> findByAuthorId(int authorId) {
        return dsl.select(AUTHORS.FIRST_NAME, AUTHORS.LAST_NAME)
                .select(BOOKS.TITLE)
                .from(AUTHORS)
                .join(AUTHORBOOK)
                .on(AUTHORS.ID.eq(AUTHORBOOK.AUTHOR_ID))
                .join(BOOKS)
                .on(AUTHORBOOK.BOOK_ID.eq(BOOKS.ID))
                .where(AUTHORS.ID.eq(authorId))
                .fetch()
                .stream()
                .map(AuthorsAndBooks::toMap)
                .collect(Collectors.toList());
    }


}
