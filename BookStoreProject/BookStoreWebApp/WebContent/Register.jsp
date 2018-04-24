<%-- 
    Document   : Register
    Created on : Apr 24, 2018, 4:13:02 PM
    Author     : rsantbar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form method="POST" action="Login">
            <h1>Register</h1>
            <label>Username</label>
            <input id="username" type="text" name="username" placeholder="Username">
            </br>
            <label>Password</label>
            <input id="password" type="password" name="password" placeholder="Password">
            </br>
            <input type="submit" value="Register">
        </form>
        
        <form method="POST" action="login">
            <input type="submit" value="Login">
        </form>
    </body>
</html>
