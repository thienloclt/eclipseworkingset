<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-3">
		<div class="card">
			<div class="card-header">Menu</div>
			<div class="card-body">
			<ul class="list-group">
				<c:choose>
					<c:when test="${sessionScope.login != null}">
							<li class="list-group-item"><a href="produit?action=list">Voir les produits</a></li>
						<c:if test="${sessionScope.login.role == 'ADMIN'}">
							<li class="list-group-item"><a href="produit?action=add">Ajout d'un produit</a></li>
						</c:if>
					
							<c:if test="${sessionScope.login.role == 'ADMIN'}">
					
								<li class="list-group-item"><a href="login?action=list">Voir des utilisateurs</a></li>
								<li class="list-group-item"><a href="login?action=add">Ajout d'un utilisateur</a></li>
							</c:if>
							<li class="list-group-item"><a href="auth?action=logout">Se déconnecter</a></li>
					</c:when>
					<c:otherwise>
						<li class="list-group-item"><a href="auth?action=login">S'enregistrer</a></li>
					</c:otherwise>
				</c:choose>			
			</ul>
			</div>
		</div>
		</div>