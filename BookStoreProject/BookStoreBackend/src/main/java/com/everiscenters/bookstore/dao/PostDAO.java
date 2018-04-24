/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.dao;

import com.everiscenters.bookstore.model.Book;
import com.everiscenters.bookstore.model.Post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fvitordu
 */
public class PostDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public PostDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
            this.jdbcURL = jdbcURL;
            this.jdbcUsername = jdbcUsername;
            this.jdbcPassword = jdbcPassword;
    }

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

    protected void disconnect() throws SQLException {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                    jdbcConnection.close();
            }
    }
    public boolean insertPost(Post post) throws SQLException {
		String sql = "INSERT INTO posts (title) VALUES (?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, post.getTitle());
                
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
        public List<Post> listAllPosts() throws SQLException {
		List<Post> listPost = new ArrayList<>();
		
		String sql = "SELECT * FROM posts";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("idpost");
			String date = resultSet.getString("date");
			String title = resultSet.getString("title");
                        
			Post post = new Post(id, date, title);
			listPost.add(post);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listPost;
	}
        public boolean deletePost(Post post) throws SQLException {
		String sql = "DELETE FROM posts where idpost = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, post.getPostId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
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
        public Post getPost(int id) throws SQLException {
		Post post = null;
		String sql = "SELECT * FROM posts WHERE idpost = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String title = resultSet.getString("title");
                        String date = resultSet.getString("date");
			
			post = new Post(title,date);
		}
		
		resultSet.close();
		statement.close();
		
		return post;
	}
}
