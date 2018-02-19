<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<c:import url="../include/header.jsp" />
<h3>Gestion des artistes <small> > détail de l'artiste "${artisteFromDb.prenom} ${artisteFromDb.nom}" </small></h3>
<ul>
	<li>Id: ${artisteFromDb.id}</li>
	<li>Prenom: ${artisteFromDb.prenom}</li>
	<li>Nom: ${artisteFromDb.nom}</li> 
</ul>
	
	<h4>Liste des CDs</h4>
	<ul>
	<c:forEach items="${artisteFromDb.CDs}" var="cd">
		<li><a href="<c:url value="/cd/${cd.id}" />">${cd.nom}( ${cd.anneeProduction}, ${cd.nombrePistes} pistes )</a></li>		
	</c:forEach>
	</ul>
<c:import url="../include/footer.jsp" />