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

	<div class="container">
	<div class="">
		<jsp:include page="/publica/publica-nav.jsp" />
	</div>
		<div class="row">
			<div class="col">
				<h2>Editar Livro</h2>
				<form action="${pageContext.request.contextPath}/LivroControle?acao=edicao" method="post">
					<input type="hidden" name="id" value="${livro.id}"/> 
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Nome</label>
						<div class="col-sm-5">
							<input class="form-control" type="text"  name="nome" value="${livro.nome}" /> 
						</div>
					</div>		
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">autor</label>
						<div class="col-sm-5">
							<input class="form-control" type="text"  name="autor" value="${livro.autor}"/> 
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">categoria</label>
						<div class="col-sm-5">
							<input class="form-control" type="text"  name="categoria" value="${livro.categoria}"/> 
						</div>
					</div>
					<%@ include file="/publica/botao-gravar.jsp" %>					
				</form>
			</div>
		</div>
	</div>

</body>
</html>