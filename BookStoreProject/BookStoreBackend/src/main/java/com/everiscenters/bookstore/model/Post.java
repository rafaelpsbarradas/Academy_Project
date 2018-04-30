/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

import java.util.Date;

/** Classe que representa a entidade Post.
 *
 * @author fvitordu
 */
public class Post {
    private int idPost;
    private String title;
    private Date date;
    private String description;
    
    public Post() {
        super();
    }
    
    public Post(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    
    public Post(int idPost) {
        this.idPost = idPost;
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    public Post(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public Post(int idPost, Date date,String title) {
        this.idPost = idPost;
        this.date = date;
    }

    /**
     * @return the idPost
     */
    public int getIdPost() {
        return idPost;
    }

    /**
     * @param idPost the idPost to set
     */
    public void setIdPost(int idPost) {
        this.idPost = idPost;
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
