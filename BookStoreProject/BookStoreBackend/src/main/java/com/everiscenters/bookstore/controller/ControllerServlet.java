package com.everiscenters.bookstore.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everiscenters.bookstore.dao.BookDAO;
import com.everiscenters.bookstore.dao.UserDAO;
import com.everiscenters.bookstore.model.Book;

/**
 * ControllerServlet.java
 * 
 * This servlet acts as a page controller for the application, handling all requests from the user.
 *
 *  @author Copyright 2018 everis group
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
                        case "/list":
				listBook(request, response);
				break;
                        case "/main":
				main(request, response);
				break;
                        case "/listUser":
				listUser(request, response);
				break;
                        case "/changeProfile":
				change(request, response);
				break;
                        case "/register":
				register(request, response);
				break;
                        case "/registerComplete":
				registerComplete(request, response);
				break;
                        case "/logout":
				logout(request, response);
				break;
			default:
				login(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
            
            //Verificar Sessão
            //SE ADMIN -> BookList.jsp
            //SE NÃO -> MENSAGEM DE AVISO
            
            List<Book> listBook = bookDAO.listAllBooks();
            request.setAttribute("listBook", listBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
            dispatcher.forward(request, response);
	}
        
        private void main(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
		
            //Fazer validaçoes
            //Verificar Login
            //Criar Sessão
            //SE Sim -> Main.jsp
            //SE Nao -> Login.jsp com mensagem
            
            //Fazer Validações
//            if(request != null && !request.getParameter("username").isEmpty() && UserDAO.getUser(request.getParameter("username"))){
//                if(!request.getParameter("password") && UserDAO.getPassword(request.getParameter("password"))) {
                    
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
                    dispatcher.forward(request, response);
//                } 
//            }
        }
        
        private void logout(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
		
            //remover sessão
            //iR PARA O LOGIN
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}

         private void login(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}
         
        private void change(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}
         
        private void register(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
		dispatcher.forward(request, response);
	}
        
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)	throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDAO.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book newBook = new Book(title, author, price);
		bookDAO.insertBook(newBook);
		response.sendRedirect("list");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book book = new Book(id, title, author, price);
		bookDAO.updateBook(book);
		response.sendRedirect("list");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Book book = new Book(id);
		bookDAO.deleteBook(book);
		response.sendRedirect("list");
                    
	}
}
