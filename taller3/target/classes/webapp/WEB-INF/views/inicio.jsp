<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido Videos Acedemicos</title>
</head>
<body>
	<h1>Lista de Videos</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Fecha</th>
				<th>Imagen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="video">
				<tr>
					<td>${video.id}</td>
					<td>${video.name}</td>
					<td>${video.date}</td>
					<td>${video.path}</td>  
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
</body>
</html>