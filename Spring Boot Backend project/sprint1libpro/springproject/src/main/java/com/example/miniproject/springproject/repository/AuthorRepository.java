package com.example.miniproject.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miniproject.springproject.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
