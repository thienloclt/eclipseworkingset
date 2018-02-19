<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- Begin Dành cho menu ngang 				
			<nav class="navbar navbar-expand-md bg-secondary navbar-light sticky-top">
				<!-- Brand --> <a class="navbar-brand" href="#">Menu</a> <!-- Toggler/collapsibe Button -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"	data-target="#collapsibleNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- Navbar links -->
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/cheval/list">Cheval</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/centreequestre/list">Centre Equestre</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/registre/list">Registre</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/voiture/list">Voiture</a></li>
						<%
							if (request.getSession().getAttribute("role") == "ADMIN") {
						%>
						<li class="nav-item"><a class="nav-link" href="Login">ListeLogin</a></li>
						<%
							}
						%>
					</ul>
				</div>
			</nav>
	End Dành cho menu ngang
--%>
			<!-- Begin Dành cho menu dọc -->
			<div class="row">
				<div class="col-3" style="padding-right: 0px;">
					<div class="card rounded-0">
						<div class="card-header">Menu</div>
						<div class="card-body">
						<ul class="list-group">
							<c:choose>
								<c:when test="${sessionScope.login != null}">
									<li class="list-group-item"><a href="${pageContext.request.contextPath}/cheval/list">Cheval</a></li>
									<li class="list-group-item"><a href="${pageContext.request.contextPath}/centreequestre/list">Centre Equestre</a></li>
									<li class="list-group-item"><a href="${pageContext.request.contextPath}/registre/list">Registre</a></li>
									<li class="list-group-item"><a href="${pageContext.request.contextPath}/voiture/list">Voiture</a></li>
									<c:if test="${sessionScope.login.role == 'ADMIN'}">
										<li class="list-group-item"><a href="login?action=list">Utilisateurs</a></li>
									</c:if>
									<li class="list-group-item">Logged as: ${login.login}<br><a href="${pageContext.request.contextPath}/auth/logout">Se déconnecter</a></li>
								</c:when>
								<c:otherwise>
									<li class="list-group-item"><a href="${pageContext.request.contextPath}/auth/login">S'enregistrer</a></li>
								</c:otherwise>
							</c:choose>			
						</ul>
						</div>
					</div>
				</div>
				<div class="col" style="padding-left: 10px;">
			<!-- End Dành cho menu dọc -->