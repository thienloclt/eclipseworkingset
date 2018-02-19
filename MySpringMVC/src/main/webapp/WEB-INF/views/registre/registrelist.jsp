<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
				<div class="card">
					<div class="card-header">Liste des registres&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/registre/add"><button class="btn btn-success">Ajouter</button></a>
					</div>
					<div class="card-body">
						<table id="tblEleves" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Numero</th>
									<th scope="col">Date delivrance</th>
									<th scope="col">Cheval</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${registres}" var="registre">
									<tr>
										<td><a href="detail/${registre.id}">${registre.id}</a></td>
										<td>${registre.numero}</td>
										<td>${registre.dateDelivrance}</td>
										<td>${registre.cheval.nom}</td>
										<td>
											<a href="${pageContext.request.contextPath}/registre/edit/${registre.id}"><button class="btn btn-info">Modifier</button></a>
											<a href="${pageContext.request.contextPath}/registre/del/${registre.id}"><button class="btn btn-danger">Supprimer</button></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
<jsp:include page="../include/footer.jsp"/>