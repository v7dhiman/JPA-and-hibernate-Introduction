package com.example.demojpa.service;

import com.example.demojpa.exceptions.PersonNotFoundException;
import com.example.demojpa.models.Person;
import com.example.demojpa.repository.PersonRepository;
import com.example.demojpa.request.CreatePersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService
{
    @Autowired
    PersonRepository personRepository;

    private static Logger logger = LoggerFactory.getLogger(PersonService.class);

    public void createPerson(CreatePersonRequest createPersonRequest)
    {
        Person person = createPersonRequest.to();

        Person personFromDB = personRepository.save(person);
        logger.info("Person saved - {}", personFromDB);

//        if(person.getCountryCode() == "+91")
//        {
//
//        }
//        else
//        {
//
//        }
    }
    public Person getPerson(int id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person with id " + id + " not present"));
    }
    //Even though we would be passing age from controller, but the underlying repository layer will
    //search in primary key column
//    public Person getPerson2(int age)
//    {
//        return personRepository.findById(age).get();
//    }
    public List<Person> getPeople()
    {
        return personRepository.findAll();
    }
}
