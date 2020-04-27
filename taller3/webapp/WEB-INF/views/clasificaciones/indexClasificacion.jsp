<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administracion de Clasificaciones</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/clasificaciones/create" var="urlForm" />
<spring:url value="/clasificaciones/edit" var="urlEdit"/>
<spring:url value="/clasificaciones/delete" var="urlDelete"/>
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

</head>
<body>

	<jsp:include page="../includes/menu.jsp" />
	<div class="container theme-showcase" role="main">

		<h3>Listado de Clasificaciones</h3>

		<c:if test="${mensaje!=null}">
			<div class="alert alert-success" role="alert">${mensaje}</div>
		</c:if>
		<a href="${urlForm}" class="btn btn-success" role="button"
			title="Nuevo Video">Nueva</a> <br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Descripcion</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${clasificaciones}" var="clasificacion">
					<tr>

						<td>${clasificacion.id}</td>
						<td>${clasificacion.nombre}</td>
						<td><a href="${urlEdit}/${clasificacion.id} " class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${urlDelete}/${clasificacion.id}" onclick='return confirm("¿Desea eliminar el registro?")' class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../includes/footer.jsp" />
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