<%-- 
    Document   : EditProfile
    Created on : Apr 27, 2018, 10:43:42 AM
    Author     : rsantbar
--%>

<%@page language = "java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User Profile</title>
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
            <img src="https://www.everis.com/sites/all/themes/everis/logo.png" alt="logo" />
        </center>
    
        <div align="center" >
        <form method="POST" action="changeProfile">
            <h1>User: <c:out value="${username}" /></h1>
            <label>Password</label>
            <input id="password1" type="password" name="password1" placeholder="Password" value="<c:out value="${password}" />" />
            <br/>
            <label>Confirm Password</label>
            <input id="password2" type="password" name="password2" placeholder="Password" value="<c:out value="${password}" />" />
            <br/>
            <label>Email</label>
            <input id="email" type="email" name="email" placeholder="Email" value="<c:out value="${email}" />" />
            <br/>
            <label>First Name</label>
            <input id="first" type="text" name="first" placeholder="First Name" value="<c:out value="${first}" />" />
            <br/>
            <label>Last Name</label>
            <input id="second" type="text" name="second" placeholder="Last Name" value="<c:out value="${second}" />" />
            <br/>
            
            <input type="submit" value="Change" />
            <input type="reset" value="Reset" />
        </form>
        </div>
        
        <div align="center" >
        <form method="POST" action="voltarMain">
            <input type="submit" value="Voltar" />
        </form>
        </div>
    </body>
</html>
