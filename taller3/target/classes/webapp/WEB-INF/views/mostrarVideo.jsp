<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle del Video</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

</head>
<body>
	<jsp:include page="includes/menu.jsp" />
	<div class="container theme-showcase" role="main">

		<!-- Marketing messaging -->
		<div class="container marketing">

			<div class="page-header">
				<h2>${video.name}</h2>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<p class="text-center">
						<img class="img-rounded" src="${urlPublic}/images/${video.path}"
							alt="Generic placeholder image" width="155" height="220">
					</p>
				</div>
				<div class="col-sm-9">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">DETALLES</h3>
						</div>
						<div class="panel-body">
							<p>
								Titulo : ${video.name} <br> Descripcion : ${video.description}<br>
								Categoria: ${video.categoria }<br>
								Estado: ${video.status } <br>
								Fecha : ${video.date} <br>
								Autor:  ${video.detalle.autor} <br>
								Fecha Filmacion: ${video.detalle.fechaFilmacion} <br>
								Resumen: ${video.detalle.resumen} <br>
							</p>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="includes/footer.jsp" />

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