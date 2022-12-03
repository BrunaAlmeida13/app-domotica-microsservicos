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
		<br>
		<h3>Lista de moradores cadastrados</h3>
		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr class="table-secondary">
					<th scope="col">Nome</th>
					<th scope="col">E-mail</th>
					<th scope="col">Senha</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${listagem}">
					<tr class="table-dark">
						<td>${m.nome}</td>
						<td>${m.email}</td>
						<td>${m.senha}</td>
						<td><a href="/morador/${m.email}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
	</div>
</body>

</html>