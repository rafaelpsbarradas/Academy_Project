/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

import java.sql.SQLType;
import java.util.Date;

/** Classe que representa a entidade Comentário.
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
     * @return the textComment
     */
    public String getTextComment() {
        return textComment;
    }

    /**
     * @param textComment the textComment to set
     */
    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    /**
     * @return the commentDate
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * @param commentDate the commentDate to set
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
