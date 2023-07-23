package com.AnudipSprint.lms.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AnudipSprint.lms.entity.Book;
import com.AnudipSprint.lms.exception.ResourceNotFoundException;
import com.AnudipSprint.lms.repository.BookRepository;
import com.AnudipSprint.lms.services.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book","id",id));
    }
    

    @Override
    public Book updateBook(Book book, long id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book","id",id));
        
        existingBook.setName(book.getName());
        existingBook.setSerialName(book.getSerialName());
        existingBook.setDescription(book.getDescription()); 
   

        return bookRepository.save(existingBook);
    }
    
	@Override
	public void deleteBook(Long id) {
		
		// check whether a employee exist in a DB or not
		bookRepository.findById(id).orElseThrow( 
				() -> new ResourceNotFoundException("Book", "id", id));
		bookRepository.deleteById(id);
	}
    }

