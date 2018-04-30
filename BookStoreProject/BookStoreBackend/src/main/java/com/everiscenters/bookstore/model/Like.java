/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

/** Classe que representa os Likes.
 *
 * @author fvitordu
 */
public class Like {
    private int id;
    private int likeCounter;

    public Like(int id, int likeCounter) {
        this.id = id;
        this.likeCounter = likeCounter;
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
     * @return the likeCounter
     */
    public int getLikeCounter() {
        return likeCounter;
    }

    /**
     * @param likeCounter the likeCounter to set
     */
    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }
}
