<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<title>livros</title>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<div class="">
		<jsp:include page="/publica/publica-nav.jsp" />
	</div>

	<div class="container">
		<div class="row">

			<div class="col">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Autor</th>
							<th>Categoria</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="ca" items="${listaLivros}">
							<tr>
								<td><c:out value="${ca.id}" /></td>
								<td><c:out value="${ca.nome}" /></td>
								<td><c:out value="${ca.autor}" /></td>
								<td><c:out value="${ca.categoria}" /></td>								
								<td><a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/LivroControle?acao=editar&id=<c:out value="${ca.id}" />">Editar</a></td>
								<td><a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/LivroControle?acao=apagar&id=<c:out value="${ca.id}" />">Apagar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>

</body>
</html>