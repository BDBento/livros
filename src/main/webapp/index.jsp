<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>

 
 
 <div class="container">

       
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/LivroControle?acao=novo">Cadastrar</a>
        
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/LivroControle?acao=listar">Listar</a>

     
 </div>


	
	
	

</body>
</html>