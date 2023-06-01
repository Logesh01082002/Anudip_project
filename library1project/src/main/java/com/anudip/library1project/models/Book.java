package com.anudip.library1project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Book_info")
public class Book {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bid;
	
	@Column(name = "book_name", nullable = false)
	private String bookName;
	
	@Column(name = "Author_name")
	private String authorName;
	
	@Column(name = "Publisher")
	private String publisher;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "No.of.copies")
	private String copies;
	
	@Column(name = "year")
	private double year;
	
	@Column(name = "status")
	private String status;

	public Book() {
		
	}
	public Book(long bid,String bookName, String authorName, String publisher, String category, String copies,double year, String status) 
	{
		super();
		this.bid=bid;
		this.bookName=bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.category = category;
		this.copies = copies;
		this.year = year;
		this.status = status;
	}

	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCopies() {
		return copies;
	}

	public void setCopies(String copies) {
		this.copies = copies;
	}

	public double getYear() {
		return year;
	}

	public void setYear(double year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

