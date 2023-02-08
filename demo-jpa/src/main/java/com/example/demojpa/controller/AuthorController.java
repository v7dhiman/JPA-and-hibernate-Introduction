package com.example.demojpa.controller;

import com.example.demojpa.models.Author;
import com.example.demojpa.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController
{
    @Autowired
    AuthorRepository authorRepository;
    @PostMapping("/author")
    public Author createAuthor(@RequestParam("age") int age, @RequestParam("name") String name)
    {
        Author author = Author.builder()
                .age(age)
                .name(name)
                .build();
        return authorRepository.save(author);
    }
}
