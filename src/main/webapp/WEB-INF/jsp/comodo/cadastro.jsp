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
	<c:set var="ativarBotao" value="" />

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastro de cômodo</h2>

		<form action="/comodo/incluir" method="post">
			<div class="mb-3 mt-3">
				<label>Tipo</label> <input type="text" class="form-control"
					name="tipo">
			</div>
			<div class="mb-3 mt-3">
				<label>Nome</label> <input type="text" class="form-control"
					name="nome">
			</div>
			<div class="mb-3 mt-3">
				<c:if test="${not empty aparelhos}">
					<label>Aparelhos</label>
					<c:forEach var="a" items="${aparelhos}">
						<div>
							<label><input type="checkbox" value="${a.id}"
								name="listaAparelhos"> ${a.nome}</label><br>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<div>
				<c:if test="${empty aparelhos}">
					<label>Não há aparelhos cadastrados!</label>
					<c:set var="ativarBotao" value="disabled" />
				</c:if>
			</div>
			<div class="mb-3 mt-3">
				<c:if test="${not empty responsaveis}">
					<label>Responsável</label>
					<select name="responsavel">
						<c:forEach var="r" items="${responsaveis}">
							<option value="${r.id}">${r.login}</option>
						</c:forEach>
					</select>
				</c:if>
				<div>
					<c:if test="${empty responsaveis}">
						<label>Não há responsáveis cadastrados!</label>
						<c:set var="ativarBotao" value="disabled" />
					</c:if>
				</div>
			</div>
			<br>
			<button ${ativarBotao} type="submit" class="btn btn-dark">Cadastrar</button>
		</form>
	</div>
</body>

</html>