package com.example.miniproject.springproject.service;

import java.util.List;

import com.example.miniproject.springproject.entity.Author;

public interface AuthorService {

	public List<Author> findAllAuthors();

	public Author findAuthorById(Long id);

	public void createAuthor(Author author);

	public void updateAuthor(Author author);

	public void deleteAuthor(Long id);

}
