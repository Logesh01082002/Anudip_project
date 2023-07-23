package com.AnudipSprint.lms.services;

import java.util.List;

import com.AnudipSprint.lms.entity.Author;


public interface AuthorService {
	
	Author saveAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long aid);
    Author updateAuthor(Author author, long aid);
    void deleteAuthor(Long aid);
}
