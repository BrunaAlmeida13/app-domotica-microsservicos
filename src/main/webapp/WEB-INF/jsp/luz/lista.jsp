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
		<c:if test="${not empty mensagem}">
			<div class="alert alert-info">
				<strong>Infomação: </strong> ${mensagem}
			</div>
		</c:if>
		<br>
		<h3>Classe: Luz estende Aparelho</h3>
		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr class="table-secondary">
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Status</th>
					<th scope="col">Timer Inicio</th>
					<th scope="col">Timer Fim</th>
					<th scope="col">Cor</th>
					<th scope="col">Intensidade</th>
					<th scope="col">Volume Som</th>
					<th scope="col">Power</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${listagem}">
					<tr class="table-dark">
						<td>${l.id}</td>
						<td>${l.nome}</td>
						<td>${l.status}</td>
						<td>${l.timerInicio}</td>
						<td>${l.timerFim}</td>
						<td>${l.cor}</td>
						<td>${l.intensidade}</td>
						<td>${l.volumeSom}</td>
						<c:if test="${l.power == true}">
							<td>Ligada</td>
						</c:if>
						<c:if test="${l.power == false}">
							<td>Desligada</td>
						</c:if>
						<td><a href="/luz/${l.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="nav-link" href="/luz">Cadastrar uma luz</a> <br>
	</div>
</body>

</html>