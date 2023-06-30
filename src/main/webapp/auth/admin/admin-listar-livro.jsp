<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="/publica/publica-nav.jsp" />

	<div class="container">
		<div class="row">
			
			<div class="col">
				<h2>
					livros
				</h2>
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

							</tr>
							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>