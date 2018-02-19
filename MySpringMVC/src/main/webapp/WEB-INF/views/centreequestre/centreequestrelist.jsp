<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>

<!-- form:select item itemlabel -->
				<div class="card">
					<div class="card-header">Liste des Centre Equestres&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/centreequestre/add"><button class="btn btn-success">Ajouter</button></a>
					</div>
					<div class="card-body">
						<table id="tblEleves" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Nom</th>
									<th scope="col">Adresse</th>
									<th scope="col">Code Postal</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${centreEquestres}" var="centreEquestre">
									<tr>
										<td><a href="detail/${centreEquestre.id}">${centreEquestre.id}</a></td>
										<td>${centreEquestre.nom}</td>
										<td>${centreEquestre.adresse}</td>
										<td>${centreEquestre.codepostal}</td>
										<td>
											<a href="${pageContext.request.contextPath}/centreequestre/edit/${centreEquestre.id}"><button class="btn btn-info">Modifier</button></a>
											<a href="${pageContext.request.contextPath}/centreequestre/del/${centreEquestre.id}"><button class="btn btn-danger">Supprimer</button></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
<jsp:include page="../include/footer.jsp"/>