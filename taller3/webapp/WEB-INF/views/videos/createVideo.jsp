<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Creacion de Videos</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/videos/save" var="urlForm"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>

	<jsp:include page="../includes/menu.jsp" />
	<div class="container theme-showcase" role="main">
		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Datos del Video</span>
			</h3>
		</div>
		<form:form action="${urlForm}" method="post" modelAttribute="video">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="name">Titulo</label>
						<form:input type="text" class="form-control" path="name" id="name"
							required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="description">Descripcion</label>

						<form:input type="text" class="form-control" path="description"
							id="description" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="categoria" class="control-label">Categoria</label>
						<form:select id="categoria" path="categoria" class="form-control"
							items="${clasificaciones}" itemValue="id" itemLabel="nombre">

						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="date">Fecha</label>

						<form:input type="text" class="form-control" path="date" id="date"
							required="required" />
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="status" class="control-label">Estatus</label>

						<form:select id="status" path="status" class="form-control"
							items="${statuses}">

						</form:select>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="path">Imagen</label>

						<form:input type="file" id="archivoImagen" path="path" />
						<p class="help-block">Imagen del video</p>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="autor">Autor</label>

						<form:input type="text" class="form-control" path="detalle.autor"
							id="autor" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						
						<label for="date">Fecha Filmacion</label>
						<form:input type="text" class="form-control"
							path="detalle.fechaFilmacion" id="fechaFilmacion"
							required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="resumen">Resumen</label>

						<form:input type="text" class="form-control"
							path="detalle.resumen" id="resumen" required="required" />
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
	<script>
		$(function() {
			$("#date").datepicker({
				dateFormat : 'dd-mm-yy'
			});

			$("#fechaFilmacion").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
