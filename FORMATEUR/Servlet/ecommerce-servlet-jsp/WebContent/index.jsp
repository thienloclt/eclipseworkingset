<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include  page="include/header.jsp"/>
<jsp:include page="include/menu.jsp"/>
<div class="col">
	<div class="card">
		<div class="card-header">Bienvenue!</div>
		<div class="card-body">
			<c:choose>
				<c:when test="${sessionScope.login != null}">Vous êtes enregistré en tant que ${sessionScope.login.login} <a href="auth?action=logout">Se déconnecter</a></c:when>
				<c:otherwise>Vous devez <a href="auth?action=login">vous enregistrer</a> pour accéder à l'application</c:otherwise>
			</c:choose>
		</div>					
		</div>
	</div>					
<jsp:include page="include/footer.jsp"/>
