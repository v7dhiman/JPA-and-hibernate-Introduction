package com.example.demojpa.repository;

import com.example.demojpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>
{

}
