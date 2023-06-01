package com.anudip.library1project.services;
import java.util.List;
import com.anudip.library1project.models.Book;

public interface BookService
{
	 Book saveBook(Book book);
	 List<Book> getAllBooks();
	 Book getBookById(long id);
	 Book updateBook(long id, Book book);
	 void deleteBook(long id);
}
