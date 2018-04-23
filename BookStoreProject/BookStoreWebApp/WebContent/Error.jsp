<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
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
		<img src="https://www.everis.com/sites/all/themes/everis/logo.png"
			alt="logo" />
		<h1>Error</h1>
		<h2><%=exception.getMessage()%><br />
		</h2>
	</center>
	<div class="footer">
		<p>@ Copyright 2018 everis group</p>
	</div>
</body>
</html>