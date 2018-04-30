package com.everiscenters.bookstore.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everiscenters.bookstore.dao.BookDAO;
import com.everiscenters.bookstore.dao.PostDAO;
import com.everiscenters.bookstore.dao.UserDAO;
import com.everiscenters.bookstore.model.Book;

import com.everiscenters.bookstore.model.User;
import static java.lang.System.out;

import static javax.swing.JOptionPane.showMessageDialog;
import com.everiscenters.bookstore.model.Post;
import com.everiscenters.bookstore.model.User;

import com.everiscenters.bookstore.model.User;
import static java.lang.System.out;
import static javax.swing.JOptionPane.showMessageDialog;
import com.everiscenters.bookstore.model.Post;
import com.everiscenters.bookstore.model.User;


/**
 * ControllerServlet.java
 * 
 * Este servlet actua como um controlador de página para a aplicação, processando todos os pedidos HTTP
 * provenientes da máquina do(a) utilizador(a).
 *
 *  @author Copyright 2018 everis group
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
        private PostDAO postDAO;
        private UserDAO userDAO;
        private String usernameCon;
        /** Método de inicialização da instância; atenção, não é suposto ser método de classe, mas apenas um método
         *  cuja invocação é da máxima prioridade quando comparado com os restantes métodos de instância.
            */
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
                userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
                postDAO = new PostDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}
        
        /** Método que invoca doGet com os respectivos compatíveis parâmetros, invocação essa
         *  que é resultado do despoletar de um botão do tipo "submit" num formulário.
         *  @param request
         *  @param response
         * @throws ServletException
         * @throws IOException
         */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
        
        /** Método cuja invocação corresponde a um pedido HTTP, semelhante ao método de cima,
         *  método este que trata, numa tabela de jumps (um switch), de reencaminhar para a 
         *  página correspondente ao pedido realizado, de acordo com os parâmetros presentes
         *  no header da camada HTTP.
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException 
         */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newbook":
				showNewBookForm(request, response);
				break;
                        case "/newpost":
				showNewPostForm(request, response);
				break;
			case "/insertbook":
				insertBook(request, response);
				break;
                        case "/insertpost":
				insertPost(request, response);
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
                        case "/booklist":
				listBook(request, response);
				break;
                        case "/postlist":
				listPost(request, response);
				break;
                        case "/main":
				main(request, response);
				break;
                        case "/showEditProfile":
				showEditProfile(request, response);
				break; 
                        case "/listUser":
				break;
				//listUser(request, response);
//				listUser(request, response);
                        case "/changeProfile":
				change(request, response);
				break;
                        case "/voltarMain":
                                voltarMain(request, response);
                            break;
                        case "/showRegister":
				showRegister(request, response);
				break;
                        case "/register":
				register(request, response);
				break;
                        case "/logout":
				logout(request, response);
				break;
                        case "/deletePost":
				deletePost(request, response);
				break;
			case "/editPost":
				showEditPost(request, response);
				break;
                        case "/updatePost":
				updatePost(request, response);
				break;
                            case "/myPost":
				myPost(request, response);
				break;
			default:
				login(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
        
        /** Método a ser invocado para popular um parâmetro no header 
         *  HTTP com uma listagem pertinente aos livros presentes na Base de Dados,
         *  recorrendo ao método listAllBooks da classe BookDAO presente no pacote (package)
         *  correspondente aos Objectos de Acesso a Dados.
         *  Após preenchimento do parâmetro, redirecciona o(a) utilizador(a) para
         *  a página de listagem de livros caso esteja autenticado(a); caso a 
         *  autenticação não suceda, é apresentada uma caixa de mensagem informando
         *  desse facto.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException
         * @throws ServletException 
         */
	private void listBook(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
            
            //Verificar Sessão (Verificar se é admin)
            HttpSession session=request.getSession(false);  
            String usernameCon=(String)session.getAttribute("sessionUsername");  
            if(usernameCon.equals("rafael") || usernameCon.equals("fernando") || usernameCon.equals("luis")){
                List<Book> listBook = bookDAO.listAllBooks();
                request.setAttribute("listBook", listBook);
                RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
                dispatcher.forward(request, response);
            } else {
                System.out.println("Não tem permissões para aceder a esta página!");
            }
	}
        
        /** Método a ser invocado para popular um parâmetro no header HTTP com uma listagem
         *  pertinente aos posts realizados até à data, reencaminhando posteriormente
         *  para a página devidamente concebida para mostrar esses dados.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException
         * @throws ServletException 
         */
        private void listPost(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            
            if(usernameCon != null){
                List<Post> listPost = postDAO.listAllPosts();
                request.setAttribute("listPost", listPost);
                RequestDispatcher dispatcher = request.getRequestDispatcher("PostList.jsp");
                dispatcher.forward(request, response);
            } else {
                System.out.println("Utilizador sem conta activa");;
            }
	}
	
        /** Método que se destina a autenticar terceiros que constem na base de 
         *  dados da aplicação.
         * @param request
         * @param response
         * @throws IOException
         * @throws ServletException
         * @throws SQLException 
         */
        private void main(HttpServletRequest request, HttpServletResponse response) 	throws IOException, ServletException, SQLException {
	    //Fazer Validações e Verificar Login
            if(request != null && !request.getParameter("username").isEmpty() && userDAO != null && 
                    userDAO.getUser(request.getParameter("username")) != null){
                if(!request.getParameter("password").isEmpty() &&
                        userDAO.getUser(request.getParameter("username")).getPassword().equals(request.getParameter("password"))) {
                    //Criar Sessão
                    HttpSession session = request.getSession(); 
                    session.setAttribute("sessionUsername", (usernameCon = request.getParameter("username")));
                    
                    //Redirect to Main Page
                    RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
                    dispatcher.forward(request, response);
                } else {
                    System.out.println("Password Errada!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                System.out.println("Username Errado!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response); 
            }
        }
        
        /** Método que trata de efectuar o logout do(a) corrente utilizador(a) na
         *  página correspondente para o efeito.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException
         * @throws ServletException 
         */
        private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            //remover sessão
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            
            if(usernameCon != null) {
                usernameCon = null;
            }
            
            //Redirecciona para a página do Login
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}
        
        /** Método que redirecciona o(a) utilizador(a) para a página de Login.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException
         * @throws ServletException 
         */
        private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
	}
        
        /** Método que permite mudar as credenciais com que terceiros se autenticaram
         *  perante o site da aplicação.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException
         * @throws ServletException 
         */
        private void change(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            //Verificar sessão
            //Buscar dados da sessão
            String password1Req = request.getParameter("password1");
            String password2Req = request.getParameter("password2");
            String email = request.getParameter("email");
            String first = request.getParameter("first");
            String second = request.getParameter("second");
            //Verificar se nao existe dados vazios
            if(request != null && usernameCon != null && password1Req != null && 
                    password2Req != null && email != null && first != null && second != null) {
                if(!usernameCon.isEmpty() && !password1Req.isEmpty() && 
                        !password2Req.isEmpty() && !email.isEmpty() && !first.isEmpty() && !second.isEmpty()){
                if(password1Req.equals(password2Req)){
                    
                    User user = new User();
                    user.setUsername(usernameCon);
                    user.setPassword(password1Req);
                    user.setEmail(email);
                    user.setFirstName(first);
                    user.setLastName(second);
                    
                    if(userDAO.getUser(user.getEmail()) == null){
                       
                        userDAO.updateUser(user);

                        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
                      
                    } else {
                            System.out.println("Email já utilizados");
                            response.sendRedirect("editprofile");
                        }
                } else { 
                        System.out.println("Password não estão iguais");
                        response.sendRedirect("editprofile");
                    }
            } else { 
                    System.out.println("Certifique-se que todos os campos se encontram preenchidos");
                    response.sendRedirect("editprofile");
                }
            } else { 
                    System.out.println("Certifique-se que todos os campos se encontram preenchidos");
                    response.sendRedirect("editprofile");
                }
	}
        
        /** Método que possibilita a criação de um novo utilizador mediante preenchimento
         *  de todos os campos de texto presentes no formulário da página.
         * @param request
         * @param response
         * @throws IOException
         * @throws ServletException
         * @throws SQLException 
         */
        private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
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
            //Verificar se nao existe dados vazios
            if(request != null && usernameReq != null && password1Req != null && 
                    password2Req != null && email != null && first != null && second != null) {
                if(!usernameReq.isEmpty() && !password1Req.isEmpty() && 
                        !password2Req.isEmpty() && !email.isEmpty() && !first.isEmpty() && !second.isEmpty()){
                    if(password1Req.equals(password2Req)){
                        User user = new User();
                        user.setUsername(usernameReq);
                        user.setPassword(password1Req);
                        user.setEmail(email);
                        user.setFirstName(first);
                        user.setLastName(second);


                        if(userDAO.getUser(user.getUsername()) == null && userDAO.getUser(user.getEmail()) == null){

                                userDAO.insertUser(user);

                                response.sendRedirect("login");
                      
                        } else {
                            System.out.println("Username ou Email já utilizados");
                            response.sendRedirect("register");
                        }
                } else { 
                    System.out.println("Password não estão iguais");
                    response.sendRedirect("register");
                }
            } else { 
                    System.out.println("Certifique-se que todos os campos se encontram preenchidos");
                    response.sendRedirect("register");
                }
            } else { 
                System.out.println("Certifique-se que todos os campos se encontram preenchidos");
                //request.getRequestDispatcher("register").forward(request, response);
                response.sendRedirect("register");
                    
                }
	}
        
        /** Método que redirecciona o(a) utilizador(a) da página actual para a 
         *  página de registo.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException
         * @throws ServletException 
         */
        private void showRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);
	}
        
        /** Método que redirecciona o(a) utilizador(a) para o formulário relativo à 
         *  adição de novos livros na Base de Dados.
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException 
         */
	private void showNewBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);
	}
        
        /** Método responsável por redireccionar da página actual para a página de 
         *  adição de novos posts.
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException 
         */
        private void showNewPostForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                RequestDispatcher dispatcher = request.getRequestDispatcher("PostForm.jsp");
		dispatcher.forward(request, response);
	}
        
        /** Método que redirecciona da página actual para a página que possibilita
         *  listar e adicionar novos livros à Base de Dados.
         * @param request
         * @param response
         * @throws SQLException
         * @throws ServletException
         * @throws IOException 
         */
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDAO.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}
        
        /** Método que, após inserir novo livro na Base de Dados, redirecciona o(a)
         *  utilizador(a) para a página sobre a qual é possível visualizar todos os
         *  livros inseridos no sistema.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException 
         */
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
                int book_id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
                int publisher_year = Integer.parseInt(request.getParameter("publisherYear"));
		float price = Float.parseFloat(request.getParameter("price"));
                String publisher = request.getParameter("publisher");
                //usar parâmetros aqui
		Book newBook = new Book(book_id, title, author, price, publisher_year, publisher);
		bookDAO.insertBook(newBook);
		response.sendRedirect("insertBook");
	}
        
        /** Método que permite inserir um Post na Base de Dados relativo a um livro,
         *  posteriormente redireccionando para a página que permite adicionar novos Posts.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException 
         */
        private void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
            
            if(request != null && request.getParameter("title") != null && request.getParameter("bookid") != null && 
                    request.getParameter("description") != null && usernameCon != null) {
                
                String title = request.getParameter("title");
                int id = Integer.parseInt(request.getParameter("bookid"));
                String description = request.getParameter("description");

                HttpSession session=request.getSession(false);  
                String usernameCon = (String)session.getAttribute("sessionUsername"); 

                int userid = userDAO.getUser(usernameCon).getUserId();

                postDAO.insertPost(title, description, id, userid);
                response.sendRedirect("newpost");
            } else{
                System.out.println("certifique-se que preencheu todos os campos");
            }
	}
        
        /** Método que possibilita a modificação de dados relativos a um dado
         *  livro.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException 
         */
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book book = new Book(id, title, author, price);
		bookDAO.updateBook(book);
		response.sendRedirect("list");
	}
        
        /** Método que apaga um livro da Base de Dados, mediante apresentação
         *  da respectiva identificação do mesmo.
         * @param request
         * @param response
         * @throws SQLException
         * @throws IOException 
         */
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new Book(id);
		bookDAO.deleteBook(book);
		response.sendRedirect("list");
	}
    /**
     * 
     * @param request
     * @param response 
     */
    private void showEditProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        User user = userDAO.getUser(usernameCon);
        request.setAttribute("username", user.getUsername());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("first", user.getFirstName());
        request.setAttribute("second", user.getLastName());
        request.setAttribute("password", user.getPassword());
        
        
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
    }

    private void voltarMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("MainPage.jsp").forward(request, response); 
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void showEditPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//            int id = Integer.parseInt(request.getParameter("id"));
//            Post existingPost = postDAO.getPost(id);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("PostForm.jsp");
//            request.setAttribute("post", existingPost);
//            dispatcher.forward(request, response);
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = new Post(id);
        postDAO.deletePost(post);
        response.sendRedirect("postlist");
    }

    private void myPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        if(usernameCon != null){
                int userId = userDAO.getUser(usernameCon).getUserId();
                List<Post> listPost = postDAO.listUserPost(userId);
                request.setAttribute("listPost", listPost);
                RequestDispatcher dispatcher = request.getRequestDispatcher("PostList.jsp");
                dispatcher.forward(request, response);
            } else {
                System.out.println("Não tem sessão activa!");
            }
    }
}
