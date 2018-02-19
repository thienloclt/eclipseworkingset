<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
			<div class="card-header">Liste de produits</div>
			<div class="card-body">
				<table class="table table-hover table-bordered">
					<tr>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>Catégorie</th>
					<c:if test="${sessionScope.login != null && sessionScope.login.role == 'ADMIN' }">	
						<th>Action</th>
					</c:if>
					</tr>
					<c:forEach items="${produits}" var="produit">
						<tr>
							<th><a href="produit?action=detail&id=${produit.id}">${produit.id}</a></th>
							<td>${produit.nom}</td>
							<td>${produit.prix}</td>
							<td>${produit.categorie.nom}</td>
							<c:if test="${sessionScope.login != null && sessionScope.login.role == 'ADMIN' }">	
							<td>		
								<a href="produit?action=edit&id=${produit.id}" class="btn btn-warning btn-lg" >
									<span class="far fa-edit"></span>
								</a>
								<a href="produit?action=delete&id=${produit.id}" class="btn btn-danger btn-lg" >
									<span class="far fa-trash-alt"></span>
								</a>
							</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${sessionScope.login != null && sessionScope.login.role == 'ADMIN' }">	
					<a href="produit?action=add" class="btn btn-success btn-lg">
						<span class="far fa-plus-square""></span>
					</a>
				</c:if>
			</div>
		</div>
		</div>
<jsp:include  page="../include/footer.jsp"/>
