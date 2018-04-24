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
public class Comment extends Post{
    int id;
    String textComment;
    Date commentDate;

    public Comment(int idPost) {
        super(idPost);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
