<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido Videos Acedemicos</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	<h1>Lista de Videos</h1>

	<div class="table-responsive">
		<table border="1" class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Imagen</th>
				</tr>
			</thead>
			<tbody class="table-responsive">
				<c:forEach items="${lista}" var="video">
					<tr>
						<td>${video.id}</td>
						<td>${video.name}</td>
						<td>${video.date}</td>
						<td>${video.path}</td>
						<td><img alt="" src="${urlPublic}/images/${video.path}"
							width="50" height="50"></td>
						<td>
							<form action="consultar" method="post">
								<div class="form-group">
	    							<label for="id">Id</label>
									<input class="form-control" type="text" name="id" value="${video.id}"> 
									
									<label for="Titulo">Titulo</label>
									<input class="form-control" type="text" name="titulo" value="${video.name}">
									<button type="submit" class="btn btn-primary">Consultar</button>
								</div>
							</form> 
							
							<a href="consultar?id=${video.id}&titulo=${video.name}"
							role="button" class="btn btn-primary">Consultar Video</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>