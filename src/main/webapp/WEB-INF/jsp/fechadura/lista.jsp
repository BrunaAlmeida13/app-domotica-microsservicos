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
			<div class="alert alert-info" role="alert">
				<strong>Infomação: </strong> ${mensagem}
			</div>
		</c:if>
	
		<h3>Classe: Fechadura estende Aparelho</h3>
		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr class="table-secondary">
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Status</th>
					<th scope="col">Timer Inicio</th>
					<th scope="col">Timer Fim</th>
					<th scope="col">Senha</th>
					<th scope="col">Trancada</th>
					<th scope="col">Alarme</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="f" items="${listagem}">
					<tr class="table-dark">
						<td>${f.id}</td>
						<td>${f.nome}</td>
						<td>${f.status}</td>
						<td>${f.timerInicio}</td>
						<td>${f.timerFim}</td>
						<td>${f.senha}</td>
						<c:if test="${f.trancada == true}">
						<td>Trancada</td>
						</c:if>
						<c:if test="${f.trancada == false}">
						<td>Destrancada</td>
						</c:if>
						<c:if test="${f.alarme == true}">
						<td>Ligado</td>
						</c:if>
						<c:if test="${f.alarme == false}">
						<td>Desligado</td>
						</c:if>
						<td><a href="/fechadura/${f.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="nav-link"	href="/fechadura">Cadastrar uma fechadura</a>
	</div>
</body>

</html>