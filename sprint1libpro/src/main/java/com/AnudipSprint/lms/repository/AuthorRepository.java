package com.AnudipSprint.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnudipSprint.lms.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Custom query methods, if needed
}
