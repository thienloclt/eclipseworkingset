<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<c:import url="../include/header.jsp" />
<spring:url value="/cd/add" var="cdAdd" />
<spring:url value="/cd/list" var="cdList" />
<section class="container">
	<h3>Gestion des CDs <small> > ${action} </small></h3>
	<p>
		<a href="${cdList}">Retour à la liste des cd</a>
	</p>
	<form:form method="POST" action="${cdAdd}" modelAttribute="cd">
		<div class="form-group">
				<form:hidden path="id" />
				 <div class="form-group">
					<label for=artiste>Artistes</label>
					<form:select path="artiste.id" items="${artistList}" itemLabel="fullName" itemValue="id" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="nom">Titre de l'album</label>
					<form:input path="nom" class="form-control" placeholder="Entrez le nom de l'album"/>
				</div>
				 <div class="form-group">
					<label for=anneeProduction>Année de production</label>
					<form:select path="anneeProduction"  class="form-control">
						<c:forEach begin="1900" step="1" end="2017" var="annee">
							<c:set var="decr" value="${1900+(2017 - annee)}"/>
							<option value="${decr}">${decr}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="nombrePistes">Nombre de pistes</label>
				    <form:input path="nombrePistes" class="form-control" placeholder="Entrez le nombre de piste"/>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form:form>
</section>
<c:import url="../include/footer.jsp" />