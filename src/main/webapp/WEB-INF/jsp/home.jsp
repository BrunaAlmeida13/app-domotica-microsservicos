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
		<h2 align="center">
			<b>${projeto.nome}</b>
		</h2>
		<h4>${projeto.descricao}</h4>
		<br>
		<div>
		<h5>Aluna: Bruna Araújo Almeida<br>
		Disciplina: Java Web e Injeção de Dependência[22E3_3]<br>
		Professor: Elberth Moraes</h5>
		</div>
		<br>
		<c:forEach var="c" items="${projeto.classes}">
			<h3>Classe: ${c.nome}</h3>
			<table class="table table-striped table-dark">
				<thead class="thead-dark">
					<tr class="table-secondary">
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${c.atributos}">
						<tr class="table-dark">
							<td>${a.nome}</td>
							<td>${a.tipo}</td>
							<td>${a.descricao}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
	</div>
</body>

</html>