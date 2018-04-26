<%-- 
    Document   : Login
    Created on : Apr 24, 2018, 2:32:37 PM
    Author     : rsantbar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="POST" action="main">
            <h1>LOGIN</h1>
            <label>Username</label>
            <input id="username" type="text" name="username" placeholder="Username">
            </br>
            <label>Password</label>
            <input id="password" type="password" name="password" placeholder="Password">
            </br>
            <input type="submit" value="Sign In">
        </form>
        
        <form method="POST" action="register">
            <input type="submit" value="Sign Up">
        </form>
        
    </body>
</html>
