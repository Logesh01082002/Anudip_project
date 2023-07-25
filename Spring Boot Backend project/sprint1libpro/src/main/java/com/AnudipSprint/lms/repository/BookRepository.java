package com.AnudipSprint.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnudipSprint.lms.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods, if needed
}

