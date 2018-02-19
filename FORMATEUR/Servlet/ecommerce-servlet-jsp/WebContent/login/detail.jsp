<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
<div class="col">
		<div class="card">
			<div class="card-header">Affichage de l'utilisateur: "${login.login}" (${login.id})</div>
			<div class="card-body">
				<ul>
					<li><strong>role: </strong>${login.role}</li>
				</ul>
			</div>
			<div class="card-footer">
				<div class="btn-group">
					<a href="login?action=edit&id=${login.id}" class="btn btn-warning btn-lg" >
						<span class="far fa-edit"></span>
					</a>
					<a href="login?action=delete&id=${login.id}" class="btn btn-danger btn-lg" >
						<span class="far fa-trash-alt"></span>
					</a>
				</div>
			</div>
		</div>
		</div>
<jsp:include  page="../include/footer.jsp"/>
