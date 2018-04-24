/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everiscenters.bookstore.dao;

import com.everiscenters.bookstore.model.Comment;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fvitordu
 */
public class CommentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public CommentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
        public boolean insertComment(Comment comment) throws SQLException {
		String sql = "INSERT INTO comments ( comment_text, date) VALUES ( ?, ?)";
		connect();
// Erro na formatação não consegue converter String para date		
//                Date date = new Date();
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, comment.getTextComment());
//		statement.setDate(2, (dateFormat.format(date)));
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
        public List<Comment> listComments() throws SQLException {
		List<Comment> listComment = new ArrayList<>();
		
		String sql = "SELECT * FROM comments";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			//int id = resultSet.getInt("book_id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
                        int publishYear = resultSet.getInt("publish_year");
                        String publisher = resultSet.getString("publisher");
			
			Comment comment = new Comment(publishYear);
			listComment.add(comment);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listComment;
	}
}
