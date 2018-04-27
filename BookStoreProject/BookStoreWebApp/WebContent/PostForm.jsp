<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>NewPost</title>
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
.navbar {
    overflow: hidden;
    background-color: #9aae04;
    font-family: Arial, Helvetica, sans-serif;
    }

    .navbar a {
        float: left;
        font-size: 16px;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    .dropdown {
        float: left;
        overflow: hidden;
    }

    .dropdown .dropbtn {
        font-size: 16px;    
        border: none;
        outline: none;
        color: white;
        padding: 14px 16px;
        background-color: #9aae04;
        font-family: inherit;
        margin: 0;
    }

    .navbar a:hover, .dropdown:hover .dropbtn {
        background-color: #a0b3b0;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #9aae04;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .dropdown-content a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
    }

    .dropdown-content a:hover {
        background-color: #a0b3b0;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }
    .topnav-right {
        float: right;
    }
    input[type=number]::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
</head>
<body>
	<center>
		<img src="https://www.everis.com/sites/all/themes/everis/logo.png"
			alt="logo" />
	</center>
<div class="navbar">    
                <a href="main">MainPage</a>
                <a href="booklist">BookList</a>
                <a href="postlist">PostList</a>
            <div class="topnav-right">
                <a href="logout">Logout</a>
            </div>
        </div>
            <div align="center">
			<form action="insertpost" method="post">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Add New Post</h2>
                                </caption>
                                <tr>
                                        <th>Title:</th>
                                        <td><input type="text" name="title" size="" required="true"
                                                value="<c:out value='${post.title}' />" /></td>
                                </tr>
                                <tr>
                                        <th>BookId:</th>
                                        <td><input type="number" name="bookid" size="13" required="true"
                                                value="<c:out value='${book.id}' />" /></td>
                                </tr>
                                <tr>
                                        <th>Description:</th>
                                        <td><input type="text" name="description" size=""
                                                value="<c:out value='${post.description}' />" /></td>
                                </tr>
                                <tr>
                                        <td colspan="2" align="center"><input type="submit"
                                                value="AddPost" /></td>
			</tr>
		</table>
		</form>
	</div>
	<div class="footer">
		<p>&copy; Copyright 2018 everis group</p>
	</div>
</body>
</html>
