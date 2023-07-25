package com.AnudipSprint.lms.services;

import java.util.List;

import com.AnudipSprint.lms.entity.Book;

public interface BookService {
	
	    List<Book> getAllBooks();
	    Book getBookById(Long id);
	    Book saveBook(Book book);
	    Book updateBook(Book book,long id);
	    void deleteBook(Long id);
	}


