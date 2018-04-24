package com.everiscenters.bookstore.model;
/**
 * Book.java
 * 
 * This is a model class represents a book entity
 * 
 *  @author Copyright 2018 everis group
 *
 */
public class Book {

	protected int id;
	protected String title;
	protected String author;
	protected float price;
        private int publishYear;
        private String publisher;
        
        public Book(int id){
            this.id=id;
        }
        public Book(String title, String author, float price, int publishYear, String publisher) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.publishYear = publishYear;
            this.publisher = publisher;
        }

        public Book(int id, String title, String author, float price, int publishYear, String publisher) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.price = price;
            this.publishYear = publishYear;
            this.publisher = publisher;
        }

        public Book(int id, String title, String author, float price) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
        }
        
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

        /**
         * @return the publishYear
         */
        public int getPublishYear() {
            return publishYear;
        }

        /**
         * @param publishYear the publishYear to set
         */
        public void setPublishYear(int publishYear) {
            this.publishYear = publishYear;
        }

        /**
         * @return the publisher
         */
        public String getPublisher() {
            return publisher;
        }

        /**
         * @param publisher the publisher to set
         */
        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

}
