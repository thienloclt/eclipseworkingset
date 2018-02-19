<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
		<div class="card-header">Authentification</div>			

		<c:if test="${error != null}">
			<div class="alert alert-danger" role="alert">
				${error}	
			</div>
		</c:if>
			<div class="card-body">
				<form action="" method="post">
					<div class="form-group">
						<label for="login">login:</label> <input type="text"
							class="form-control" name="login" id="login">
					</div>
					<div class="form-group">
						<label for="password">password:</label> <input type="text"
							class="form-control" name="password" id="password">
					</div>
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
			</div>
		</div>
		</div>
<jsp:include  page="../include/footer.jsp"/>
