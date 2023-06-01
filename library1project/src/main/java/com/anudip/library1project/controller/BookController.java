package com.anudip.library1project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.library1project.models.Book;
import com.anudip.library1project.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
    	super();
        this.bookService = bookService;
    }

    //create book REST API 
    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

 //build to get book by id REST API    
    @GetMapping("/Allbooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //build to get book by id REST API
    //http://localhost:8080/api/books/1
    @GetMapping("/{bid}")
    public ResponseEntity<Book> getBookById(@PathVariable("bid") long bid) {
        Book book = bookService.getBookById(bid);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{bid}")
    public ResponseEntity<Book> updateBook(@PathVariable("bid") long bid, @RequestBody Book book) 
    {
        Book updatedBook = bookService.updateBook(bid, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }
    
    @DeleteMapping("/{bid}")
    public ResponseEntity<String> deleteBook(@PathVariable("bid") long bid) {
        bookService.deleteBook(bid);
        return new ResponseEntity<>("Book deleted successfully!", HttpStatus.OK);
    }
}
