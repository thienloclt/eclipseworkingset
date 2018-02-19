<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
		<c:choose>
			<c:when test="${produit.id > 0}">
				<div class="card-header">Edition du produit "${produit.nom }" (${produit.id})</div>			
			</c:when>
			<c:otherwise>
				<div class="card-header">Ajout d'un produit</div>			
			</c:otherwise>
		</c:choose>
		<c:if test="${error != null}">
			<div class="alert alert-danger" role="alert">
				${error}	
			</div>
		</c:if>
			<div class="card-body">
				<form action="" method="post">
					<c:if test="${produit.id > 0}">
						<div class="form-group">
							<label for="idProd">Id:</label> 
							<input type="text" value="${produit.id}" id="idProd" name="idProd" disabled/>
						</div>
					</c:if>
					<div class="form-group">
						<label for="nom">nom:</label> <input type="text"
							class="form-control" value="${produit.nom}" name="nom" id="nom">
					</div>
					<div class="form-group">
						<label for="prix">Prix:</label> <input type="number"
							class="form-control" value="${produit.prix}" name="prix" id="prix">
					</div>
					<div class="form-group">
						<label for="stock">Stock:</label> <input type="number"
							class="form-control" value="${produit.stock}" name="stock" id="stock">
					</div>
					<div class="form-group">
						<label for="description">Description:</label> 
   						<textarea class="form-control" value="${produit.description}" id="description" name="description" rows="3"></textarea>

					</div>
					<div class="form-group">
						<label for="categorie">Catégorie</label> 
						<select	class="form-control" id="situationFamiliale" name="categorie" value="${produit.categorie.id}">
							<c:forEach items="${categories}" var="cat">
								<option value="${cat.id}">${cat.nom}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
			</div>
		</div>
		</div>
<jsp:include page="../include/footer.jsp"/>
