package com.example.controller;

import com.example.domain.Authors;
import com.example.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    public List<Authors> getList() {
        return authorsService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public Authors getAuthorById(@PathVariable int id) {
        return authorsService.findById(id).orElseThrow(() -> new RuntimeException("Bad bad Bad"));
    }

    @PostMapping
    public void createAuthors(@RequestBody Authors request) {
        authorsService.createAuthor(request);
    }

}
