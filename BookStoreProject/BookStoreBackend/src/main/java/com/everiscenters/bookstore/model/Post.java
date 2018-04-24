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
    String date;

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Post(int idPost, String date) {
        this.idPost = idPost;
        this.date = date;
    }
}
