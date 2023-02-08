package com.example.demojpa.controller;

import com.example.demojpa.exceptions.PersonNotFoundException;
import com.example.demojpa.models.Person;
import com.example.demojpa.request.CreatePersonRequest;
import com.example.demojpa.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController
{
    @Autowired
    PersonService personService;
    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @PostMapping("/person")
    public void createPerson(@RequestBody @Valid CreatePersonRequest createPersonRequest)
    {
        personService.createPerson(createPersonRequest);
    }
    @GetMapping("/person")
    public Person getPersonById(@RequestParam("id") int id) throws PersonNotFoundException {
        return personService.getPerson(id);
    }
    @GetMapping("/person/all")
    public List<Person> getPeople()
    {
        return personService.getPeople();
    }
}
