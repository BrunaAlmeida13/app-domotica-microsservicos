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

		<h2>Cadastro do Ar Condicionado</h2>

		<form action="/arcondicionado/incluir" method="post">

			<c:import url="/WEB-INF/jsp/aparelho/cadastro.jsp" />

			<div class="mb-3 mt-3">
				<label>Temperatura °C</label> <input type="number"
					class="form-control" name="temperatura">
			</div>
			<div class="mb-3">
				<label>Ventilação</label> <select name="ventilacao">
					<option value="true">Ligado</option>
					<option value="false">Desligado</option>
				</select>
			</div>
			<div class="mb-3">
				<label>Power</label> <select name="power">
					<option value="true">Ligado</option>
					<option value="false">Desligado</option>
				</select>
			</div>
			<br>
			<button type="submit" class="btn btn-dark">Cadastrar</button>
		</form>
	</div>
</body>

</html>