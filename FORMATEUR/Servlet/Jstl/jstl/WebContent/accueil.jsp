<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon super site</title>
</head>
<body>
<h1>Welcome! ${sessionScope.login}</h1>
<!-- Si un message et passé en attribut dans request: -->
<div style="color:green">
	<c:if test="${message != null}">
		${message}
	</c:if>
</div>
Bienvenue sur le site de la vie.<br>
<!-- Si on est enregistré dans la session: -->
	<c:if test="${sessionScope.login != null}">
		Vous êtes connecté en tant que <strong>${sessionScope.login}</strong> <a href="login?action=logout">cliquez ici</a> pour vous deconnecter
	</c:if>
	<c:if test="${sessionScope.login == null}">
		Veuillez <a href="login?action=login">vous connecter</a>
	</c:if>
</body>
</html>