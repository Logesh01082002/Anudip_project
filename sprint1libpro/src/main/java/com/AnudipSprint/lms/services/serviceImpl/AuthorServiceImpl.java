package com.AnudipSprint.lms.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AnudipSprint.lms.entity.Author;
import com.AnudipSprint.lms.exception.ResourceNotFoundException;
import com.AnudipSprint.lms.repository.AuthorRepository;
import com.AnudipSprint.lms.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
 

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long aid) {
        return authorRepository.findById(aid)
                .orElseThrow(() -> new ResourceNotFoundException("Author","aid",aid));
    }

   
    @Override
    public  Author updateAuthor(Author author, long aid) {
        Author existingAuthor = authorRepository.findById(aid)
                .orElseThrow(() -> new ResourceNotFoundException("Author","aid",aid));

        existingAuthor.setName(author.getName());
        existingAuthor.setDescription(author.getDescription());
        existingAuthor.setAge(author.getAge());
        existingAuthor.setCountry(author.getCountry());
        existingAuthor.setRating(author.getRating());

        return authorRepository.save(existingAuthor);
    }
    
	@Override
	public void deleteAuthor(Long aid) {
		
		// check whether a employee exist in a DB or not
		authorRepository.findById(aid).orElseThrow( 
				() -> new ResourceNotFoundException("Author", "aid", aid));
		authorRepository.deleteById(aid);
	}

}


