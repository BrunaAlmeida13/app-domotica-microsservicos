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

		<c:if test="${not empty mensagem}">
			<div class="alert alert-info">
				<strong>Infomação: </strong> ${mensagem}
			</div>
		</c:if>

		<h3>Classe: ArCondicionado estende Aparelho</h3>
		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr class="table-secondary">
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Status</th>
					<th scope="col">Timer Início</th>
					<th scope="col">Timer Fim</th>
					<th scope="col">Temperatura</th>
					<th scope="col">Ventilação</th>
					<th scope="col">Power</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${listagem}">
					<tr class="table-dark">
						<td>${a.id}</td>
						<td>${a.nome}</td>
						<td>${a.status}</td>
						<td>${a.timerInicio}</td>
						<td>${a.timerFim}</td>
						<td>${a.temperatura}</td>
						<c:if test="${a.ventilacao == true}">
							<td>Ligada</td>
						</c:if>
						<c:if test="${a.ventilacao == false}">
							<td>Desligada</td>
						</c:if>
						<c:if test="${a.power == true}">
							<td>Ligado</td>
						</c:if>
						<c:if test="${a.power == false}">
							<td>Desligado</td>
						</c:if>
						<td><a href="/arcondicionado/${a.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="nav-link" href="/arcondicionado">Cadastrar um Ar
			Condicionado</a>
	</div>
</body>
</html>