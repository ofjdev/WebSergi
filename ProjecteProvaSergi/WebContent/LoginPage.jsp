<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Sergi (login)</title>
</head>
<body>
	<h1>Login</h1>
	<%=request.getAttribute("Clau") %>
	
	<form action="OperacioLogin" method="POST">
		Usuario:<input type="text" name="user"/><br/><br/>
		Password:<input type="password" name="pass"/><br/><br/>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>