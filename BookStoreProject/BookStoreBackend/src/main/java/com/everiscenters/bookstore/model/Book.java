package com.everiscenters.bookstore.model;

import java.sql.Date;
import java.text.*;

/**
 * Book.java
 * 
 * Classe que representa a entidade Livro.
 * 
 *  @author Copyright 2018 everis group
 *
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private float price;
    private Date publishYear;
    private String publisher;

    public Book() {
        super();
    }

    public Book(int id){
        this.id=id;
    }
    public Book(String title, String author, float price, Date publishYear, String publisher) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishYear = publishYear;
        this.publisher = publisher;
    }

    public Book(int id, String title, String author, float price, Date publishYear, String publisher) {
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



    /**
     * @return the publishYear
     */
    public Date getPublishYear() {
        return publishYear;
    }

    /**
     * @param publishYear the publishYear to set
     */
    public void setPublishYear(Date publishYear) {
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
