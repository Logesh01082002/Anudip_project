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
import org.springframework.web.bind.annotation.RestController;

import com.AnudipSprint.lms.entity.Author;
import com.AnudipSprint.lms.exception.ResourceNotFoundException;
import com.AnudipSprint.lms.services.AuthorService;

@RestController
@RequestMapping("/api/Authors")
@CrossOrigin("http://localhost:4200")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
		return new ResponseEntity<Author>(authorService.saveAuthor(author), HttpStatus.CREATED);
	}
    
    //ISBN stands for International Standard Book Number
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("{aid}")
        public ResponseEntity<String> getAuthorById(@PathVariable("aid") long aid){
    	
    	try {
    		Author autObject = authorService.getAuthorById(aid);
			return new ResponseEntity<String>(autObject.toString(), HttpStatus.OK);
    	}
    	catch (ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}


    @PutMapping("{aid}")
    public ResponseEntity<String> updateAuthor(@PathVariable("aid") long aid
			  ,@RequestBody Author author){
       try {
     Author updatedAuthor = authorService.updateAuthor(author, aid);
     return new ResponseEntity<String>(updatedAuthor.toString(), HttpStatus.OK);
     } 
      catch (ResourceNotFoundException e) {
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
     }

    
    @DeleteMapping("{aid}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("did") long did){
		try {
		// delete Author from DB
			authorService.deleteAuthor(did);
		return new ResponseEntity<String>("Author deleted successfully!.", HttpStatus.OK);
	       } 
		catch (ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
                      }
               }
           }

