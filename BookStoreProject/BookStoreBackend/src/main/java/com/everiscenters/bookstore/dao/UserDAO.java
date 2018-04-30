/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.dao;

import com.everiscenters.bookstore.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Esta classe pertencente ao DAO possibilita operações CRUD na base de dados para a tabela Users.
 *
 * @author fvitordu
 */
public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public UserDAO() {
        super();
        jdbcURL = null;
        jdbcUsername = null;
        jdbcPassword = null;
        jdbcConnection = null;
    }
    
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
            this.jdbcURL = jdbcURL;
            this.jdbcUsername = jdbcUsername;
            this.jdbcPassword = jdbcPassword;
    }
    
    /** Método que adquire uma conexão para a Base de Dados através dos parâmetros 
     *  fornecidos pelo utilizador.
     * @throws SQLException 
     */
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                    Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                                                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    
    /** Método que efectivamente encerra a ligação da Base de Dados.
     * @throws SQLException 
     */
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    /** Método que possibilita a inserção de um(a) utilizador(a) na Base de Dados.
     * @param user
     * @return
     * @throws SQLException 
     */
    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, email, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getFirstName());
        statement.setString(5, user.getLastName());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    /** Método que lista e devolve todos os utilizadores da Base de Dados.
     * @return
     * @throws SQLException 
     */
    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();

        String sql = "SELECT * FROM users";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                User user = new User(username, password, email,firstName, lastName);
                listUser.add(user);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listUser;
    }
    
    /** Método que permite apagar um utilizador da Base de Dados, cf. informação 
     *  encapsulada no objecto parâmetro do tipo User.
     * @param user
     * @return
     * @throws SQLException 
     */
    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM users where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getUserId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;	
    }
    
    /** Método que possibilita a actualização de informação de Utilizador presente 
     * na Base de Dados.
     * @param user
     * @return
     * @throws SQLException 
     */
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET  password=?, email=?, first_name=?, last_name=?, data_nascimento=?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getPassword());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getFirstName());
        statement.setString(4, user.getLastName());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;	
    }
    
    /** Método que retorna informação pertinente a um(a) utilizador(a) encapsulado 
     *  num objecto do tipo User.
     * @param usernameReq
     * @return
     * @throws SQLException 
     */
    public User getUser(String usernameReq) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, usernameReq);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int userid = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            user = new User(userid, username, password, email, firstName, lastName);
        }

        resultSet.close();
        statement.close();

        return user;
    }
}
