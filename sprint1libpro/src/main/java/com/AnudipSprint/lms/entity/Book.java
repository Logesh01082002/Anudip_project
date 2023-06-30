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
    private String description;
    private int page;
    private String genre;
    private int year;
    private double price;
    private double no_of_books;
    
    @ManyToOne
    @JoinColumn(name = "aid")
    private Author author;

    public Book() {
    	
    }
     
	public Book(Long id, String name, String description,int page,String genre,int year,double price,double no_of_books,char sub_code, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.page = page;
		this.genre = genre;
		this.year = year;
		this.price = price;
		this.no_of_books = no_of_books;
		this.author = author;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public double getNo_of_books() {
		return no_of_books;
	}

	public void setNo_of_books(double no_of_books) {
		this.no_of_books = no_of_books;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description+ ", page =" + page + ", genre =" + genre + ", year = " + year + ", price = "+ price + ", no_of_books = " + no_of_books + " author=" + author + "]";
	}

    
    
    
    
}

