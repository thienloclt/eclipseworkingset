<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
		<c:choose>
			<c:when test="${login.id > 0}">
				<div class="card-header">Edition de l'user "${login.login }" (${login.id})</div>			
			</c:when>
			<c:otherwise>
				<div class="card-header">Ajout d'un utilisateur</div>			
			</c:otherwise>
		</c:choose>
		<c:if test="${error != null}">
			<div class="alert alert-danger" role="alert">
				${error}	
			</div>
		</c:if>
			<div class="card-body">
				<form action="" method="post">
					<c:if test="${login.id > 0}">
						<div class="form-group">
							<label for="id">Id:</label> 
							<input type="text" value="${login.id}" id="id" name="id" disabled/>
						</div>
					</c:if>
					<div class="form-group">
						<label for="login">login:</label> <input type="text"
							class="form-control" value="${login.login}" name="login" id="login">
					</div>
					<div class="form-group">
						<label for="password">password:</label> <input type="text"
							class="form-control" value="${login.motDePasse}" name="password" id="password">
					</div>
					<div class="form-group">
						<label for="role">Role</label> 
						<select	class="form-control" id="role" name="role" value="${login.role}">
							<c:forEach items="${roles}" var="role">
							<c:choose>
								<c:when test="${role == login.role}">
									<option value="${role}" selected>${role}</option>			
								</c:when>
								<c:otherwise>								
									<option value="${role}">${role}</option>			
								</c:otherwise>
							</c:choose>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
			</div>
		</div>
		</div>
<jsp:include  page="../include/footer.jsp"/>
