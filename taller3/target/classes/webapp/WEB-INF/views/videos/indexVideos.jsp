<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">
</head>

<body>

	<jsp:include page="../includes/menu.jsp" />

	<div class="container theme-showcase" role="main">

		<h3>Listado de Videos</h3>

		<c:if test="${mensaje!=null}">
			<div class="alert alert-success" role="alert">${mensaje}</div>
		</c:if>
		<a href="${urlForm}" class="btn btn-success" role="button"
			title="Nuevo Video">Nuevo</a> <br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Descripcion</th>
					<th>Categoria</th>
					<th>Fecha</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${videos}" var="video">
					<tr>

						<td>${video.name}</td>
						<td>${video.description}</td>
						<td>${video.categoria}</td>
						<td><fmt:formatDate value="${video.date}"
								pattern="dd-MM-yyyy" /></td>
						<td><c:choose>
								<c:when test="${video.status=='Activo'}">
									<span class="label label-success">Activo</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">Inactivo</span>
								</c:otherwise>
							</c:choose></td>


						<td><a href="#" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="#" class="btn btn-danger btn-sm" role="button"
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>