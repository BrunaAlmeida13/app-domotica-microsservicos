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
		<h3>Classe: Responsavel</h3>
		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr class="table-secondary">
					<th scope="col">ID</th>
					<th scope="col">Login</th>
					<th scope="col">Senha</th>
					<th scope="col">CPF</th>
					<th scope="col">Telefone</th>
					<th scope="col">Morador</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${listagem}">
					<tr class="table-dark">
						<td>${r.id}</td>
						<td>${r.login}</td>
						<td>${r.senha}</td>
						<td>${r.cpf}</td>
						<td>${r.telefone}</td>
						<td>${r.morador.email}</td>
						<td><a href="/responsavel/${r.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="nav-link" href="/responsavel">Cadastrar um responsável</a>
	</div>
</body>

</html>