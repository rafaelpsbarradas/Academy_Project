/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

import java.util.Date;

/**
 *
 * @author fvitordu
 */
public class Post {
    int idPost;

    public Post(int idPost) {
        this.idPost = idPost;
    }
    String title;
    Date date;

    public Post(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public Post(int idPost, Date date,String title) {
        this.idPost = idPost;
        this.date = date;
    }
    public int getPostId() {
        return idPost;
    }

    public void setPostId(int idPost) {
        this.idPost = idPost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
