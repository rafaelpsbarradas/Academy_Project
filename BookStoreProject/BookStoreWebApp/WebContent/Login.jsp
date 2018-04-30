<%-- 
    Document   : Login
    Created on : Apr 24, 2018, 2:32:37 PM
    Author     : rsantbar
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
</head>
<body>
    <center>
        <img src="https://www.everis.com/sites/all/themes/everis/logo.png" alt="logo" />
    </center>
    <div align="center" >
        <form method="POST" action="main">
            <h1>LOGIN</h1>
            <label for="username">Username</label>
            <input id="username" type="text" name="username" placeholder="Username" />
            </br>
            <label for="password">Password</label>
            <input id="password" type="password" name="password" placeholder="Password" />
            <br />
            <input type="submit" value="Sign In" />
            <input type="reset" value="Reset" />
        </form>
        <form method="POST" action="showRegister">
            <input type="submit" value="Sign Up" />
        </form>
    </div>
    <div class="footer">
	<p>&copy; Copyright 2018 everis group</p>
    </div>
</body>
</html>