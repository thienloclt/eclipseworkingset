<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
			<div class="card-header">Liste de logins</div>
			<div class="card-body">
				<table class="table table-hover table-bordered">
					<tr>
						<th>Identifiant</th>
						<th>Login</th>
						<th>Catégorie</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${logins}" var="login">
						<tr>
							<th><a href="login?action=detail&id=${login.id}">${login.id}</a></th>
							<td>${login.login}</td>
							<td>${login.role}</td>
							<td>		
								<a href="login?action=edit&id=${login.id}" class="btn btn-warning btn-lg" >
									<span class="far fa-edit"></span>
								</a>
								<a href="login?action=delete&id=${login.id}" class="btn btn-danger btn-lg" >
									<span class="far fa-trash-alt"></span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<a href="login?action=add" class="btn btn-success btn-lg">
					<span class="fas fa-user-plus"></span>
				</a>
			</div>
		</div>
		</div>
<jsp:include page="../include/footer.jsp"/>