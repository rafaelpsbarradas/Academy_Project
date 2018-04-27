/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

import java.sql.SQLType;
import java.util.Date;

/**
 *
 * @author fvitordu
 */
public class Comment extends Post{
    private int id;
    private String textComment;
    private Date commentDate;
    
    public Comment() {
        super();
    }
    
    public Comment(int idPost) {
        super(idPost);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Date getcommentDate() {
        return commentDate;
    }

    public void setcommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

}
