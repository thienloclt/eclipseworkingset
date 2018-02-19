<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="../include/header.jsp" />
	<h3>Gestion des Cds <small> > ${action} </small></h3>

<table class="table table-hover">
	<thead class="thead-inverse">
		<tr>
			<th>#</th>
			<th>titre</th>
		</tr>
	</thead>
	<tbody class="table-hover">
		<c:forEach items="${listeCds}" var="a">
			<tr class="artisteRow">
				<th scope="row"><a href="<c:url value="/cd/${a.id}" />">${a.id}</a></th>
				<td>${a.nom}</td>
			</tr>
	</c:forEach>
	</tbody>
</table>
<a href="<c:url value='/cd/add' />" class="btn btn-success btn-lg" role="button" aria-disabled="true">Ajouter un cd</a>
<c:import url="../include/footer.jsp" />