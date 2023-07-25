package com.AnudipSprint.lms.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.AnudipSprint.lms.entity.Author;
import com.AnudipSprint.lms.entity.Book;
import com.AnudipSprint.lms.entity.DeleteResponse;
import com.AnudipSprint.lms.exception.ResourceNotFoundException;
import com.AnudipSprint.lms.services.AuthorService;
import com.AnudipSprint.lms.services.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/books")

public class BookController {

    private  BookService bookService;
    private  AuthorService authorService;

    public BookController(BookService bookService,AuthorService authorService) {
    	super();
        this.bookService = bookService;
        this.authorService = authorService;
    }

   
    @PostMapping("{aid}")
    public ResponseEntity<Book> saveBook(@PathVariable("aid") Long aid, @RequestBody Book book) {
        // Retrieve the author by ID
        Author author = authorService.getAuthorById(aid);
        
        // Set the author for the book
        book.setAuthor(author);
        
        // Save the book
        Book savedBook = bookService.saveBook(book);
        
        return new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
    }

    
    
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id){
    	
    	try {
    		Book bookObject = bookService.getBookById(id);
			return new ResponseEntity<Book>(bookObject, HttpStatus.OK);
    	}
    	catch (ResourceNotFoundException e) {
			return new ResponseEntity<Book>( HttpStatus.BAD_REQUEST);
		}
		
	}


    @PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id
												  ,@RequestBody Book book){
    	try {
    	     Book updatedBook = bookService.updateBook(book, id);
		     return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
	    } 
    	catch (ResourceNotFoundException e) {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
    }
	
    
    @DeleteMapping("/delete/{id}")
	public DeleteResponse deleteBook(@PathVariable("id") long id){
		try {
		// delete book from DB
		bookService.deleteBook(id);		
		return new DeleteResponse(true, "Book deleted successfully!.", null);
	    } 
		catch (ResourceNotFoundException e) {
			return new DeleteResponse(false, e.getMessage(), null);
         }
    }
}