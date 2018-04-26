package com.everiscenters.bookstore.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everiscenters.bookstore.dao.BookDAO;
import com.everiscenters.bookstore.dao.UserDAO;
import com.everiscenters.bookstore.model.Book;
import com.everiscenters.bookstore.model.User;
import static javax.swing.JOptionPane.showMessageDialog;

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
        private UserDAO userDAO;

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
				//listUser(request, response);
				break;
                        case "/changeProfile":
				change(request, response);
				break;
                        case "/register":
				showRegister(request, response);
				break;
                        case "/registerComplete":
				register(request, response);
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
            
            //Verificar Sessão (Verificar se é admin)
            HttpSession session=request.getSession(false);  
            String usernameCon=(String)session.getAttribute("sessionUsername");  
            if(usernameCon.equals("rafael")){
                List<Book> listBook = bookDAO.listAllBooks();
                request.setAttribute("listBook", listBook);
                RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
                dispatcher.forward(request, response);
            } else {
                showMessageDialog(null, "Não tem permissões para aceder a esta página!");
            }
	}
        
        private void main(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
	    //Fazer Validações e Verificar Login
            if(request != null && !request.getParameter("username").isEmpty() && userDAO.getUser(request.getParameter("username")) != null){
                if(!request.getParameter("password").isEmpty() &&
                        userDAO.getUser(request.getParameter("username")).getPassword() == request.getParameter("password")) {
                    //Criar Sessão
                    HttpSession session = request.getSession(); 
                    session.setAttribute("sessionUsername", request.getParameter("username"));
                    
                    //Redirect to Main Page
                    RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
                    dispatcher.forward(request, response);
                } else {
                    showMessageDialog(null, "Password Errada!");
                }
            } else {
                showMessageDialog(null, "Username Errado!");
            }
        }
        
        private void logout(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
            //remover sessão
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            
            //Redirect to Login
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}

         private void login(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}
         
        private void change(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
            //Verificar sessao
            //Buscar dados da sessão
            //modificar dados da função
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}
         
        private void register(HttpServletRequest request, HttpServletResponse response) 	throws IOException, ServletException, SQLException {
            //Validar dados
            //SE TIVER SUCESSO
                //enviar para base de dados
            //SE TIVER ERRADO
                //mensagem de aviso
            
            String usernameReq = request.getParameter("username");
            String password1Req = request.getParameter("password1");
            String password2Req = request.getParameter("password2");
            String email = request.getParameter("email");
            String first = request.getParameter("first");
            String second = request.getParameter("second");
            String birth = request.getParameter("birth");
            //Verificar se nao existe dados vazios
            if(request != null && !usernameReq.isEmpty() && !password1Req.isEmpty() && !password2Req.isEmpty() &&
                    !email.isEmpty() && !first.isEmpty() && !second.isEmpty() && !birth.isEmpty()){
                if(password1Req.equals(password2Req)){
                    User user = new User();
                    user.setUsername(usernameReq);
                    user.setPassword(password1Req);
                    user.setEmail(email);
                    user.setFirstName(first);
                    user.setLastName(second);
                    user.setBirthdayDate(birth);
                    
                    if(userDAO.getUser(user.getUsername()) == null && userDAO.getUser(user.getEmail()) == null){
                       
                            userDAO.insertUser(user);
                            
                            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                            dispatcher.forward(request, response);
                      
                    } else {
                        showMessageDialog(null, "Username ou Email já utilizados");
                    }
                } else { showMessageDialog(null, "Password não estão iguais");}
            } else { showMessageDialog(null, "Certifique-se que todos os campos se encontram preenchidos");}      
	}
        
        private void showRegister(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
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
