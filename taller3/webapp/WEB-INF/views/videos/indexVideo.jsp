<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Administracion de Videos</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/videos/create" var="urlForm" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">My VideoApp</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Acerca</a></li>
					<li><a href="#">Login</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Videos</h3>

		<a href="${urlForm}" class="btn btn-success" role="button"
			title="Nuevo Video">Nuevo</a><br>
		<br>

		<div class="table-responsive">
			
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Descripcion</th>
					<th>Categoria</th>
					<th>Fecha</th>
					<th>Estatus</th>
					<th>Opciones</th>
					<th>Autor</th>
					<th>FechaFilmacion</th>
					<th>Resumen</th>
				</tr>
				<c:forEach items="${videos}" var="video">
					<tr>

						<td>${video.name}</td>
						<td>${video.description}</td>
						<td>${video.categoria}</td>
						<td><fmt:formatDate value="${video.date}" pattern="dd-MM-yyyy" /></td>
						<td><c:choose>
								<c:when test="${video.status=='Activo'}">
									<span class="label label-success">Activo</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">Inactivo</span>
								</c:otherwise>
							</c:choose></td>
						<td>${video.detalle.autor}</td>
						<td>${video.detalle.fechaFilmacion}</td>
						<td>${video.detalle.resumen}</td>
						<td><a href="#" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="#" class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${mensaje!=null}">
				<div class="alert alert-success" role="alert">${mensaje}</div>
			</c:if>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				&copy; 2020 My VideoApp, Inc. &middot; <a href="#">Privacy</a>
				&middot; <a href="#">Terms</a>
			</p>
		</footer>



	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
