/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.model;

/** Classe que representa um(a) Utilizador(a).
 *
 * @author fvitordu
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    

    public User() {
        super();
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public User(int userid, String username, String password, String email, String firstName, String lastName) {
        this.id = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    
    /**
     * 
     * @return the UserId.
     */
    public int getUserId() {
        return id;
    }
    /**
     * 
     * @param id 
     */
    public void setUserId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return the UserName.
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 
     * @return the Password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 
     * @return the email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * 
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
