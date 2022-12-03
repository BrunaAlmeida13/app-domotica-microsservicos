<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Software Domótica</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastro de luz</h2>

		<form action="/luz/incluir" method="post">

			<c:import url="/WEB-INF/jsp/aparelho/cadastro.jsp" />

			<div class="mb-3 mt-3">
				<label>Cor</label> <input type="text" class="form-control"
					name="cor">
			</div>
			<div class="mb-3 mt-3">
				<label>Intensidade</label> <select name="intensidade">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</div>
			<div class="mb-3">
				<label>Volume do Som</label> <input type="number"
					class="form-control" min="0" max="100" name="volumeSom">
			</div>
			<div class="mb-3">
				<label>Power</label> <select name="power">
					<option value="true">Ligada</option>
					<option value="false">Desligada</option>
				</select>
			</div>
			<button type="submit" class="btn btn-dark">Cadastrar</button>
		</form>
	</div>
</body>

</html>