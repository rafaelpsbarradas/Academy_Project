/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.dao;

import com.everiscenters.bookstore.model.Book;
import com.everiscenters.bookstore.model.Post;
import com.everiscenters.bookstore.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/** Esta classe pertencente ao DAO possibilita operações CRUD na base de dados para a tabela Posts.
 *
 * @author fvitordu
 */
public class PostDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public PostDAO() {
        super();
        jdbcURL = null;
        jdbcUsername = null;
        jdbcPassword = null;
        jdbcConnection = null;
    }
    
    public PostDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    /** Método que possibilita a inserção de um Post relativo a um determinado livro
     *  sob a autoria de um utilizador que, previamente tenha efectuado login na aplicação.
     * @param title
     * @param description
     * @param bookid
     * @param userid
     * @return
     * @throws SQLException 
     */
    public boolean insertPost(String title, String description, int bookid, int userid) throws SQLException {
        String sql = "INSERT INTO posts (date, FK_user, FK_book, title, description) VALUES (?,?,?,?,?)";
        connect();
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setDate(1, date);
        statement.setInt(2, userid);
        statement.setInt(3, bookid);
        statement.setString(4, title);
        statement.setString(5, description);

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    /** Método que devolve uma listagem com todos os Posts presentes na Base de Dados.
     * @return
     * @throws SQLException 
     */
    public List<Post> listAllPosts() throws SQLException {
        List<Post> listPost = new ArrayList<>();

        String sql = "SELECT * FROM posts";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date");
                String description = resultSet.getString("description");

                Post post = new Post(title, description, date);
                listPost.add(post);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listPost;
    }
    
    /** Método que apaga um Post da Base de Dados, mediante fornecimento de um
     *  parâmetro para o efeito.
     * @param post
     * @return
     * @throws SQLException 
     */
    public boolean deletePost(Post post) throws SQLException {
        String sql = "DELETE FROM posts where idpost = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, post.getIdPost());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    
    /** Método que permite actualizar dados pertinentes ao Post eem questão,
     *  Post esse indentificável através do parâmetro fornecido à "rotina" em
     *  questão.
     * @param post
     * @return
     * @throws SQLException 
     */
    public boolean updatePost(Post post) throws SQLException {
        String sql = "UPDATE posts SET title = ?";
        sql += " WHERE idpost = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, post.getTitle());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;		
    }
    
    /** Método que retorna dados relacionados com um Post, mediante um 
     *  parâmetro fornecido aquando da invocação do mesmo.
     * @param id
     * @return
     * @throws SQLException 
     */
    public Post getPost(int id) throws SQLException {
        Post post = null;
        String sql = "SELECT * FROM posts WHERE idpost = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date");

                post = new Post(title,date);
        }

        resultSet.close();
        statement.close();

        return post;
    }

    public List<Post> listUserPost(int userId) throws SQLException {
        List<Post> listPost = new ArrayList<>();

        String sql = "SELECT * FROM posts WHERE FK_user = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
//        if(resultSet.next()){
        while (resultSet.next()) {
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date");
                String description = resultSet.getString("description");

                Post post = new Post(title, description, date);
                listPost.add(post);
        }
//        } else {
//            String title = resultSet.getString("title");
//            Date date = resultSet.getDate("date");
//            String description = resultSet.getString("description");
//            Post post = new Post(title, description, date);
//            listPost.add(post);
//        }

        resultSet.close();
        statement.close();

        disconnect();

        return listPost;
    }
}