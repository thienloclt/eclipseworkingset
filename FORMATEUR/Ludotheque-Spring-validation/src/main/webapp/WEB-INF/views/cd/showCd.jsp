<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<c:import url="../include/header.jsp" />
<h3>Gestion des cd <small> > détail du cd "${cd.nom}" </small></h3>
	<ul>
		<li>Id: ${cd.id}</li>
		<li>Nom: ${cd.nom}</li>
		<li>AnnéeProduction: ${cd.anneeProduction}</li> 
		<li>Nombre de pistes: ${cd.nombrePistes}</li> 
	</ul>
	<h4>Artiste:</h4>
	<ul>
		<li><a href="<c:url value="/artiste/${cd.artiste.id}" />">${cd.artiste.prenom} ${cd.artiste.nom}</a></li>		
	</ul>
<c:import url="../include/footer.jsp" />