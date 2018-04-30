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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>MainPage</title>
</head>
<body>
    <center>
        <img src="https://www.everis.com/sites/all/themes/everis/logo.png" alt="logo" />
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
                <a href="booklist">MyRecentPosts</a>
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
    <div align="center">
        <div class="row">
            <div class="column">
                <h1>MyPosts</h1>
                <ul>
                    <li><a href="#" class="list-group-item list-group-item-action">Recent</a></li>
                    <li><a href="#" class="list-group-item list-group-item-action">to</a></li>
                    <li><a href="#" class="list-group-item list-group-item-action">Old Post</a></li>
                 </ul>
            </div>
            <div class="column">
                <h2>RecentPosts</h2>
                <ul>
                    <li><a href="#" class="list-group-item list-group-item-action">Recent</a></li>
                    <li><a href="#" class="list-group-item list-group-item-action">to</a></li>
                    <li><a href="#" class="list-group-item list-group-item-action">Old Post</a></li>
                </ul>
            </div>
        </div> 
    </div>
    <div class="footer">
        <p>&copy; Copyright 2018 everis group</p>
    </div>
</body>
</html>