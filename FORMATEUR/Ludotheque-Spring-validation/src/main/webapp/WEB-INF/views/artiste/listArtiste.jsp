<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="../include/header.jsp" />
	<h3>Gestion des artistes <small> > Liste </small></h3>

<table class="table table-hover">
	<thead class="thead-inverse">
		<tr>
			<th>#</th>
			<th>prenom</th>
			<th>nom</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
	</thead>
	<tbody class="table-hover">
		<c:forEach items="${listeArtistes}" var="a">
		<tr>
			<th scope="row"><a href="<c:url value="/artiste/${a.id}" />">ID: ${a.id}</a></th>
			<td>${a.prenom }</td>
			<td>${a.nom }</td>
			<td><a href="<c:url value="/artiste/edit/${a.id}" />">Edit</a></td>
			<td><a href=" <c:url value="/artiste/delete/${a.id}"/>" >Supprimer</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="<c:url value='/artiste/add' />" class="btn btn-success btn-lg" role="button" aria-disabled="true">Ajouter un artiste</a>
<c:import url="../include/footer.jsp" />