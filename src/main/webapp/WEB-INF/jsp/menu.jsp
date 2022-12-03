<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-sm bg-secondary navbar-light">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link active" href="/">Home</a></li>
			<c:if test="${not empty user}">
				<li class="nav-item"><a class="nav-link" href="/morador/lista">Moradores</a></li>
				<li class="nav-item"><a class="nav-link" href="/comodo/lista">Comodo</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/responsavel/lista">Responsavel</a></li>
				<li class="nav-item"><a class="nav-link" href="/aparelho/lista">Aparelho</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/arcondicionado/lista">ArCondicionado</a></li>
				<li class="nav-item"><a class="nav-link" href="/luz/lista">Luz</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/fechadura/lista">Fechadura</a></li>
			</c:if>
		</ul>

		<ul class="navbar-nav">
			<c:if test="${empty user}">
				<li class="nav-item"><a class="nav-link" href="/morador"><span
						class="glyphicon glyphicon-user"></span>Signup</a></li>
				<li class="nav-item"><a class="nav-link" href="/login"><span
						class="glyphicon glyphicon-log-in"></span>Login</a></li>
			</c:if>
			<c:if test="${not empty user}">
				<li class="nav-item"><a class="nav-link" href="/logout"><span
						class="glyphicon glyphicon-log-out"></span>Logout, ${user}</a></li>
			</c:if>
		</ul>
	</div>
</nav>
