
<div class="container">
		<div class="row">
			<div class="col">
				<h2>Cadastro livro</h2>		
				
				
				<c:if test="${mensagem != null}">
				 	<div class="alert alert-success alert-dismissible fade show">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<span><c:out value="${mensagem}" /></span>
					
				</div>
				</c:if>	
				
					
				
				<form
					action="${pageContext.request.contextPath}/LivroControle?acao=inserir"
					
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Nome</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="nome">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">autor</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="autor">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">categoria</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="categoria">
						</div>
					</div>
					<jsp:include page="/publica/botao-gravar.jsp" />
				</form>
				        
			</div>
		</div>
	</div>
