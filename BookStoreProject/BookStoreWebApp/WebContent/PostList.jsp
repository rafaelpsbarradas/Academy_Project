<%-- 
    Document   : PostList
    Created on : Apr 27, 2018, 10:30:33 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

<%--  
    Document   : PostList 
    Created on : Apr 26, 2018, 9:44:11 AM 
    Author     : admin 
--%> 
 
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
        <title>Posts</title> 
        <style> 
        #general { 
                margin: 0; 
                border: 0; 
                padding: 1%; 
                width: 98%; 
                color: black; 
                text-align: left; 
                align-self: left; 
        } 
        .footer { 
                position: fixed; 
                left: 0; 
                bottom: 0; 
                width: 100%; 
                background-color: #9aae04; 
                color: white; 
                text-align: center; 
                align-content: center; 
        } 
        .footer .header { 
                position: relative; 
                color: black; 
        } 
        </style> 
    </head> 
<body id="general"> 
    <center> 
        <div class="footer header"> 
            <img src="https://www.everis.com/sites/all/themes/everis/logo.png" 
                    alt="logo" /> 
            <h1>Books Management</h1> 
            <h2> 
                <a href="list">Posts do User</a> 
            </h2> 
        </div> 
  <div> 
            <table border="1" cellpadding="5"> 
                <caption> 
                    <h2>Posts do User</h2> 
                </caption> 
                <tr colspan="3"> 
                    <td>Post ID</td> 
                    <td>Data</td> 
                    <td>T&iacute;tulo</td> 
                    <%--<td>Descri&ccedil;&atilde;o</td>--%> 
                </tr> 
                <c:forEach var="a" items="${PostDAO.listAllPosts()}"> 
                    <tr> 
                        <td><c:out value="${a.getPostId()}" /></td> 
                        <td><c:out value="${a.getDate()}" /></td> 
                        <td><c:out value="${a.getTitle()}" /></td> 
                        <%--<td><c:out value="${a.description" /></td>--%> 
                    </tr> 
                </c:forEach> 
            </table> 
  </div> 
  <div class="footer"> 
            <p>&copy; Copyright 2018 everis group</p> 
  </div> 
    </center> 
</body> 
</html>
