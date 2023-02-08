package com.example.demojpa.repository;

import com.example.demojpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{

}
