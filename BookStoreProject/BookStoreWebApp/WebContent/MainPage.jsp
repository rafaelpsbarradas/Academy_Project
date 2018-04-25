<%-- 
    Document   : MainPage
    Created on : 24/abr/2018, 20:18:39
    Author     : Fernas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
        a{
         color: blue;
        }    
        h2{
        font-size: 16px;
        font-family: Arial;
        color: #ffffff;
        }    
        divCol1{
        position: relative;
        height: 158px;
        bottom: -200px;
        width: -10px;
        background-color: #333;
        border-radius: 10%;
        border-color: #4CAF50;
        }
        divCol2{
         position: relative;
        height: 158px;
        bottom: -200px;
        width: -10px;
        background-color: #333;
        border-radius: 10%;
        border-color: #4CAF50;
        }
        divCol3{
        height: 120px;
        bottom: 100px;
        width: 200px;
        }
        .column {
        float: left;
        width: 10%;
        text-align: center;
        position: relative;
        
        }

        /* Clear floats after the columns */
        .row:after {
        content: "";
        display: table;
        clear: both;
        }   
        /* Navbar container */
        .navbar {
        overflow: hidden;
        background-color: #333;
        font-family: Arial;
        }

        /* Links inside the navbar */
        .navbar a {
        float: left;
        font-size: 16px;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        }

        /* The dropdown container */
        .dropdown {
        float: left;
        overflow: hidden;
        }

        /* Dropdown button */
        .dropdown .dropbtn {
        font-size: 16px;
        border: none;
        outline: none;
        color: white;
        padding: 14px 16px;
        background-color: inherit;
        font-family: inherit; /* Important for vertical align on mobile phones */
        margin: 0; /* Important for vertical align on mobile phones */
        }

        /* Add a red background color to navbar links on hover */
        .navbar a:hover, .dropdown:hover .dropbtn {
        background-color: red;
        }

        /* Dropdown content (hidden by default) */
        .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        }

        /* Links inside the dropdown */
        .dropdown-content a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
        }

        /* Add a grey background color to dropdown links on hover */
        .dropdown-content a:hover {
        background-color: #ddd;
        }

        /* Show the dropdown menu on hover */
        .dropdown:hover .dropdown-content {
        display: block;
        }
        /* Add a black background color to the top navigation */
        .topnav {
        background-color: #333;
        overflow: hidden;
        }

        /* Style the links inside the navigation bar */
        .topnav a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
        }

        /* Change the color of links on hover */
        .topnav a:hover {
        background-color: #ddd;
        color: black;
        }

        /* Add a color to the active/current link */
        .topnav a.active {
        background-color: #4CAF50;
        color: white;
        }

        /* Right-aligned section inside the top navigation */
        .topnav-right {
        float: right;
        }
        </style>
  <title>MainPage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a>EviConnected</a>
            </div>
            <div class="dropdown">
                <button class="dropbtn">Username(meternome)
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="#">EditProfile</a>
                </div>
            </div>
                <a href="">NewPost</a>
                <a href="">BookList</a>
            <div class="topnav-right">
              <a href="#home">Logout</a>
            </div>
        </div> 
    </div>
    <div class="list-group-item" style="text-align: center">
        <divCol3 class="row">
            <divCol1 class="column">
         <ul0>
            <h2>MyPostList</h2>
            <li><a href="#" class="list-group-item list-group-item-action">Recent</a></li>
            <li><a href="#" class="list-group-item list-group-item-action">to</a></li>
            <li><a href="#" class="list-group-item list-group-item-action">Old Post</a></li>
         </ul0>
         </divCol1>
         <divCol2 class="column">   
         <ul1>
         <h2>GeneralPostList</h2>
            <li><a href="#" class="list-group-item list-group-item-action">Recent</a></li>
            <li><a href="#" class="list-group-item list-group-item-action">to</a></li>
            <li><a href="#" class="list-group-item list-group-item-action">Old Post</a></li>
         </ul1>
        </divCol2>
        </divCol3>
        </div> 
</body>
</html>
 <div class="row">
  <div class="column"></div>
  <div class="column"></div>
</div> 