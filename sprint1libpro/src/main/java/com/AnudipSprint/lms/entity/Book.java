package com.AnudipSprint.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String serialName;
    
    private String description;
   
    @ManyToOne
    @JoinColumn(name = "aid")
    private Author author;

    public Book() {
    	
    }
     
	public Book(Long id, String name, String serialName, String description, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.serialName = serialName;
		this.description = description;
		this.author = author;
	}
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSerialName() {
		return serialName;
	}
	public void setSerialName(String serialName) {
		this.serialName = serialName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", serialName=" + serialName + ", description="
				+ description+ ", author=" + author + "]";
	}

    
    
    
    
}

