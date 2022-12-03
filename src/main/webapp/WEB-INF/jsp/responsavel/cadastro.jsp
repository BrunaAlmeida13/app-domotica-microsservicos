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
		<h2>Cadastro do responsável</h2>

		<form action="/responsavel/incluir" method="post">
			<div class="mb-3 mt-3">
				<label>Login</label> <input type="text" class="form-control"
					name="login">
			</div>
			<div class="mb-3 mt-3">
				<label>senha</label> <input type="password" class="form-control"
					name="senha">
			</div>
			<div class="mb-3 mt-3">
				<label>CPF</label> <input type="text" class="form-control"
					name="cpf" required>
			</div>
			<div class="mb-3 mt-3">
				<label>Telefone</label> <input type="text" class="form-control"
					name="telefone">
			</div>
			<br>
			<button type="submit" class="btn btn-dark">Cadastrar</button>
		</form>
	</div>
</body>

</html>