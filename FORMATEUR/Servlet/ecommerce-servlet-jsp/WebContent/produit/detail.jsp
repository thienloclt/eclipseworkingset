<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
			<div class="card-header">Affichage du produit: "${produit.nom }" (${produit.id})</div>
			<div class="card-body">
				<ul>
					<li><strong>prix: </strong>${produit.prix}</li>
					<li><strong>description: </strong>${produit.description}</li>
					<li><strong>stock: </strong>${produit.stock}</li>
					<li><strong>catégorie: </strong>${produit.categorie.nom}</li>
				</ul>
			</div>
			<div class="card-footer">
			<c:if test="${sessionScope.login != null && sessionScope.login.role == 'ADMIN' }">
				<div class="btn-group">
				
					<a href="produit?action=edit&id=${produit.id}" class="btn btn-warning btn-lg" >
						<span class="far fa-edit"></span>
					</a>
					<a href="produit?action=delete&id=${produit.id}" class="btn btn-danger btn-lg" >
						<span class="far fa-trash-alt"></span>
					</a>
				</div>
			</c:if>
			</div>
		</div>
		</div>
<jsp:include  page="../include/footer.jsp"/>
