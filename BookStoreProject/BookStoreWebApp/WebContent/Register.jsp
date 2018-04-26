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
        <form method="POST" action="register">
            <h1>Register</h1>
            <label>Username</label>
            <input id="username" type="text" name="username" placeholder="Username">
            </br>
            <label>Password</label>
            <input id="password1" type="password" name="password1" placeholder="Password">
            </br>
            <label>Confirm Password</label>
            <input id="password2" type="password" name="password2" placeholder="Password">
            </br>
            <label>Email</label>
            <input id="email" type="email" name="email" placeholder="Email">
            </br>
            <label>First Name</label>
            <input id="first" type="text" name="first" placeholder="First Name">
            </br>
            <label>Last Name</label>
            <input id="second" type="text" name="second" placeholder="Last Name">
            </br>
            <label>Birthday</label>
            <input id="birth" type="date" name="birth" placeholder="Birthday" max="1900-01-01" min="datetime-local">
            <!--<input id="birth" type="text" name="birth" placeholder="Birthday">-->
            </br>
            
            <input type="submit" value="Register">
            <input type="reset" value="Reset">
        </form>
        
        <form method="POST" action="login">
            <input type="submit" value="Login">
        </form>
    </body>
</html>
