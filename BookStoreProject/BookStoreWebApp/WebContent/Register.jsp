<%-- 
    Document   : Register
    Created on : Apr 24, 2018, 4:13:02 PM
    Author     : rsantbar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
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
    <form method="POST" action="register">
        <h1>Register</h1>
        <label for="username">Username</label>
        <input id="username" type="text" name="username" placeholder="Username">
        <br />
        <label for="password1">Password</label>
        <input id="password1" type="password" name="password1" placeholder="Password">
        <br />
        <label for="password2">Confirm Password</label>
        <input id="password2" type="password" name="password2" placeholder="Password">
        <br />
        <label for="email">Email</label>
        <input id="email" type="email" name="email" placeholder="Email">
        <br />
        <label for="first">First Name</label>
        <input id="first" type="text" name="first" placeholder="First Name">
        <br />
        <label for="second">Last Name</label>
        <input id="second" type="text" name="second" placeholder="Last Name">
        <br />
<!--        <label for="birth">Birthday</label>
        <input id="birth" type="date" name="birth" placeholder="Birthday" max="1900-01-01" min="datetime-local" format/>
        <input id="birth" type="text" name="birth" placeholder="Birthday">
        <br />-->
        <input type="submit" value="Register" />
        <input type="reset" value="Reset" />
    </form>
    </div>    
    
    <div align="center" >
    <form method="POST" action="login">
        <input type="submit" value="Login" />
    </form>
    </div>
</body>
</html>
