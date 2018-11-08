<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordre de forces</title>
</head>
<body>
	<h1>Llista de Jugadors</h1>
	
	<%@page import="EstructuraDeDades.Jugador"%>
	<%@page import="java.util.List"%>
	
	<%
		List<Jugador> ordreForces = (List<Jugador>) request.getAttribute("PlayerList");
	%>
	
	<table style="width:100%">
	  <tr>
	    <th>Nom Jugador</th>
	    <th>ELO</th> 
	    <th>Club</th>
	  </tr>
	  <% for(Jugador jugador : ordreForces){ %>
		<tr>
	    	<td><%=jugador.getNomJugador() %></td>
	    	<td><%=jugador.getElo()%> </td> 
	    	<td><%=jugador.getClub()%> </td>
	  	</tr>
	  <% } %>
	</table>
	
	
</body>
</html>