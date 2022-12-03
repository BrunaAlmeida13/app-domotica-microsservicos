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
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
		<h2>Login</h2>
		<form action="/login" method="post">
			<div class="mb-3 mt-3">
				<label for="email">Email</label> <input type="email"
					class="form-control" placeholder="Digite seu e-mail..."
					name="email">
			</div>
			<div class="mb-3">
				<label for="pwd">Senha</label> <input type="password"
					class="form-control" placeholder="Digite sua senha..."
					name="senha">
			</div>
			<button type="submit" class="btn btn-dark">Submit</button>
		</form>
	</div>
</body>

</html>