<html>
<head>
<title>Books Store Application</title>
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
        background-color: inherit;
        font-family: inherit;
        margin: 0;
    }

    .navbar a:hover, .dropdown:hover .dropbtn {
        background-color: red;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
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
        background-color: #ddd;
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
    }
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
</head>
    <body>
        <header><img src="https://www.everis.com/sites/all/themes/everis/logo.png"
			alt="logo" /></header>
        <div class="navbar">
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
              <a href="">Logout</a>
            </div>
        </div>
        <div align="center">
             <div class="row">
                 <div class="column">
                     <ul>
                     <h1>MyPosts</h1>
                        <li><a href="#" class="list-group-item list-group-item-action">Recent</a></li>
                        <li><a href="#" class="list-group-item list-group-item-action">to</a></li>
                        <li><a href="#" class="list-group-item list-group-item-action">Old Post</a></li>
                     </ul>
                 </div>
                 <div class="column">
                      <ul1>
                      <h2>RecentPosts</h2>
                        <li><a href="#" class="list-group-item list-group-item-action">Recent</a></li>
                        <li><a href="#" class="list-group-item list-group-item-action">to</a></li>
                        <li><a href="#" class="list-group-item list-group-item-action">Old Post</a></li>
                      </ul1>
                 </div>
            </div> 
        </div>
    </body>
    <div class="footer">
	<p>@ Copyright 2018 everis group</p>
    </div>
</html>