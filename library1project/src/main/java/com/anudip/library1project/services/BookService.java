package com.anudip.library1project.services;


import java.util.List;

import com.anudip.library1project.models.Book;


public interface BookService
{
	public Book saveBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Long id);
	public Book updateBook(Long id, Book book);
	public void deleteBook(Long id);
	
}