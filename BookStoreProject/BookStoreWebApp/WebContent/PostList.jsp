<%--   
    Document   : PostList  
    Created on : Apr 26, 2018, 9:44:11 AM  
    Author     : admin  
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>  
<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
    <title>Posts</title>
    <style>
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: #9aae04;
        color: white;
        text-align: center;
    }
    </style>
</head>  
<body>
    <center>
        <div>
            <img src="https://www.everis.com/sites/all/themes/everis/logo.png"  
                    alt="logo" />  
            <h1>PostList</h1>
        </div>
        <div>  
            <table border="1" cellpadding="5">  
                <caption>  
                    <h2>AllPosts</h2>  
                </caption>
                <tr colspan="3">  
                    <td>Title</td>  
                    <td>Description</td>  
                    <td>Date</td>  
                    <%--<td>Descri&ccedil;&atilde;o</td>--%>  
                </tr>
                <c:forEach var="post" items="${listPost}">  
                    <tr>
                        <td><c:out value="${post.title}" /></td>
                        <td><c:out value="${post.description}" /></td>  
                        <td><c:out value="${post.date}" /></td>  
                    </tr>  
                </c:forEach>  
            </table>
        </div>  
    </center>
    <div class="footer">
	<p>&copy; Copyright 2018 everis group</p>
    </div>
</body>
</html>
