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
public class Like {
    int id;
    int likeCounter;

    public Like(int id, int likeCounter) {
        this.id = id;
        this.likeCounter = likeCounter;
    }
    public int getLikeId() {
        return id;
    }

    public void setLikeId(int id) {
        this.id = id;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

}
