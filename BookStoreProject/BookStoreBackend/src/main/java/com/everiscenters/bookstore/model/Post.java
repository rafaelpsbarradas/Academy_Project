/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

/**
 *
 * @author fvitordu
 */
public class Post {
    int idPost;
    String title;
    String date;

    public Post(int idPost, String date,String title) {
        this.idPost = idPost;
        this.date = date;
    }
    public int getPostId() {
        return idPost;
    }

    public void setPostId(int idPost) {
        this.idPost = idPost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
