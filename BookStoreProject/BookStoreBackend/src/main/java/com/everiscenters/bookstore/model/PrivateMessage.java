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
public class PrivateMessage {

    int id;
    String messageText;
    
    public PrivateMessage(int id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }
    public int getPrivateMessageId() {
        return id;
    }

    public void setPrivateMessageId(int id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
