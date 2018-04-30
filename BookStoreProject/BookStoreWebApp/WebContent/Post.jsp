<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html> 
<html>
<head>
<title>Post</title>
    <head>
        <style>
        p31{
        margin: 30px;
        background-color: #ffffff;
        border: 1px solid black;
        opacity: 0.6;
        filter: alpha(opacity=60);
        }
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
        .row {
        display: flex;
        }
        .column {
        flex: 50%;
        text-align: center;
}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post</title>
</head>
<body style="background-color: whitesmoke">
        <center>
		<img src="https://www.everis.com/sites/all/themes/everis/logo.png"
			alt="logo" />
	</center>
        <div class="navbar">
            <div class="dropdown">
                <button class="dropbtn">Username(meternome)
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="">EditProfile</a>
                </div>
            </div>
            <div class="dropdown">
                <button class="dropbtn">Posts
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="newpost">AddNewPost</a>
                    <a href="postlist">MyRecentPosts</a>
                    <a href="postlist">RecentPosts</a>
                </div>
            </div>
            <div class="dropdown">
                <button class="dropbtn">Books
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="newbook">AddNewBook</a>
                    <a href="booklist">ListAllBooks</a>
                </div>
            </div>
            <div class="topnav-right">
                <a href="logout">Logout</a>
            </div>
        </div>
    <div style="margin-top: 3cm "align="center">
       
                    <p style="font-size: xx-large"><c:out value="${post.title}" /></p>
                    <p31><c:out value="${post.description}" /></p31> 
                    <p style="margin-left: 300px"><c:out value="${post.date}" /></p> 
                    
    </div>
        <div align="center">
            <form action="newpost" method="post">
                <textarea rows="1" cols="50" name="comment" value="<c:out value='${comment.text}'/>">
                Enter your comment here.....
            </textarea>
                <div>
                 <input type="submit" value="AddComment" />
                </div>
            </form>
                <div>
                <table>
                <c:forEach var="comment" items="${listComments}">
				<tr>
                <h2>en</h2> // nao mostra lista o problema deve ser do postid
                               <td><c:out value="${comment.textcomment}" /></td>
                               <td><c:out value="${comment.date}" /></td>
				</tr>
			</c:forEach>
                 </table>
                </div>
        </div>
       </div>         
    </body>
    <div class="footer">
	<p>&copy: Copyright 2018 everis group</p>
    </div>
</html>
