<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creacion de Clasificaciones</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/clasificaciones/save" var="urlForm"></spring:url>
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

</head>
<body>
	<jsp:include page="../includes/menu.jsp" />
	<div class="container theme-showcase" role="main">
		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Datos de la Clasificacion</span>
			</h3>
		</div>
		<spring:hasBindErrors name="clasificacion">
			<div class="alert alert-danger" role="alert">
				Se encontraron los siguientes errores:
				<ul>
					<c:forEach var="error" items="${error.allErrors }">
						<li><spring:message message="${error}"></spring:message></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
		
		<form:form action="${urlForm}" method="post" modelAttribute="clasificacion">
		${clasificacion}
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label for="nombre">nombre</label>
						<form:hidden path="id"/>
						<form:input type="text" class="form-control" path="nombre"
							id="nombre" required="required" />
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

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
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</body>
</html>