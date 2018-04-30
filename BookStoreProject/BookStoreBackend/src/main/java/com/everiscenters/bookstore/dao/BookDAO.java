package com.everiscenters.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.everiscenters.bookstore.model.Book;

/**
 * AbstractDAO.java
 * 
 * Esta classe pertencente ao DAO possibilita operações CRUD na base de dados para a tabela livros.
 * 
 *  @author Copyright 2018 everis group
 *
 */
public class BookDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
        public BookDAO() {
            super();
            jdbcURL = null;
            jdbcUsername = null;
            jdbcPassword = null;
            jdbcConnection = null;
        }
        
	public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
        /** Método que tenta estabelecer uma ligação à base de dados.
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
	
        /** Método que desconecta-se da base de dados.
         * @throws SQLException 
         */
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
        /** Método que possibilita a inserção de um novo livro na Base de Dados, 
         *  recorrendo a informação encapsulada num objecto do tipo Book.
         * @param book
         * @return
         * @throws SQLException 
         */
	public boolean insertBook(Book book, int fk_user) throws SQLException {
		String sql = "INSERT INTO book (book_id, title, author, price, publish_year, publisher, FK_user) VALUES (?, ?, ?, ?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                statement.setInt(1, book.getId());
		statement.setString(2, book.getTitle());
		statement.setString(3, book.getAuthor());
		statement.setFloat(4, book.getPrice());
                statement.setDate(5, book.getPublishYear());
                statement.setString(6, book.getPublisher());
                statement.setInt(7, fk_user);
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
        /** Método que devolve uma listagem completa de todos os livros presentes
         *  na Base de Dados.
         * @return
         * @throws SQLException 
         */
	public List<Book> listAllBooks() throws SQLException {
		List<Book> listBook = new ArrayList<Book>();
		
		String sql = "SELECT * FROM book";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("book_id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
                        java.sql.Date publishYear = resultSet.getDate("publish_year");
                        String publisher = resultSet.getString("publisher");
			
			Book book = new Book(id, title, author, price, publishYear, publisher);
			listBook.add(book);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listBook;
	}
	
        /** Método que possibilita a eliminação de um registo da Base de Dados
         *  relativo a um livro.
         * @param book
         * @return
         * @throws SQLException 
         */
	public boolean deleteBook(Book book) throws SQLException {
		String sql = "DELETE FROM book where book_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, book.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
        /** Método que actualiza a informação pertinente a um livro previamente 
         *  presente na Base de Dados.
         * @param book
         * @return
         * @throws SQLException 
         */
	public boolean updateBook(Book book) throws SQLException {
		String sql = "UPDATE book SET title = ?, author = ?, price = ?";
		sql += " WHERE book_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setFloat(3, book.getPrice());
		statement.setInt(4, book.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
        /** Método que devolve informação pertinente a um livro presente na Base de 
         *  Dados, mediante a apresentação de informação acerca do mesmo.
         * @param id
         * @return
         * @throws SQLException 
         */
	public Book getBook(int id) throws SQLException {
		Book book = null;
		String sql = "SELECT * FROM book WHERE book_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
			java.sql.Date sqlDate = resultSet.getDate("publisher_year");
                        
			book = new Book(id, title, author, price, sqlDate, author);
		}
		
		resultSet.close();
		statement.close();
		
		return book;
	}
}
