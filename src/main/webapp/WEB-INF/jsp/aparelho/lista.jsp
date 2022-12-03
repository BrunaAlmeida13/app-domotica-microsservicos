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

	<br>
	<div class="container mt-3">
		<h3>Aparelhos</h3>
		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr class="table-secondary">
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Status</th>
					<th scope="col">Timer Início</th>
					<th scope="col">Timer Fim</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ap" items="${listagem}">
					<tr class="table-dark">
						<td>${ap.id}</td>
						<td>${ap.nome}</td>
						<td>${ap.status}</td>
						<td>${ap.timerInicio}</td>
						<td>${ap.timerFim}</td>
						<td><a href="/aparelho/${ap.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>