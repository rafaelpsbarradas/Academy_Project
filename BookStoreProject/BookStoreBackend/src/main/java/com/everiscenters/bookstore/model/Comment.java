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
public class Comment {
    int id;
    String textComment;
    String date;

    public Comment(int id, String textComment, String date) {
        this.id = id;
        this.textComment = textComment;
        this.date = date;
    }
    public int getCommentId() {
        return id;
    }

    public void setCommentId(int id) {
        this.id = id;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
