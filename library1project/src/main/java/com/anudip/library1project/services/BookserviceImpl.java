package com.anudip.library1project.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.anudip.library1project.exception.ResourceNotFoundException;
import com.anudip.library1project.models.Book;
import com.anudip.library1project.repository.Bookrepository;

@Service
public class BookserviceImpl implements BookService {
    private Bookrepository bookrepository;

    public BookserviceImpl(Bookrepository bookrepository) {
    	super();
        this.bookrepository = bookrepository;
    }
  //  @Override
	public Book saveBook(Book book) {
		return bookrepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookrepository.findAll();
	}

	public Book getBookById(Long bid) {
		return  bookrepository.findById(bid).orElseThrow(() -> 
		            new ResourceNotFoundException("Book", "bid", bid));  
	}
	@Override
	public Book updateBook(Long id, Book book) {
		
		// we need to check whether employee with given id is exist in DB or not
		Book existingBook = bookrepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Book", "bid", id)); 
		
		existingBook.setBookName(book.getBookName());
		existingBook.setAuthorName(book.getAuthorName());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setCategory(book.getCategory());
		existingBook.setCopies(book.getCopies());
		existingBook.setYear(book.getYear());
		existingBook.setStatus(book.getStatus());
		
		
		// save existing employee to DB
		bookrepository.save(existingBook);
		return existingBook;
	}	

	//  @Override
 	public void deleteBook(Long bid) {
		
		// check whether a employee exist in a DB or not
		bookrepository.findById(bid).orElseThrow(() -> 
								new ResourceNotFoundException("Book", "bid", bid));
		bookrepository.deleteById(bid);
	}
}

