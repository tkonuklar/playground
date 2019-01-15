package com.example.controller;

import com.example.domain.AuthorsAndBooks;
import com.example.services.AuthorsAndBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors-and-books")
public class AuthorsAndBooksController {
    @Autowired
    private AuthorsAndBooksService authorsAndBooksService;

    @GetMapping
    public List<AuthorsAndBooks> getList() {
        return authorsAndBooksService.findAll();
    }

    @GetMapping("/{id}/authors")
    public List<AuthorsAndBooks> getBooksOfAuthor(@PathVariable int id) {
        return authorsAndBooksService.findByAuthorId(id);
    }
}
