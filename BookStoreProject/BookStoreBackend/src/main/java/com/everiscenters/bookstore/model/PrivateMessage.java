/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

/** Classe que representa uma Mensagem Privada.
 *
 * @author fvitordu
 */
public class PrivateMessage {

    private int id;
    private String messageText;
    
    public PrivateMessage(int id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }
    
    public PrivateMessage() {
        super();
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
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
