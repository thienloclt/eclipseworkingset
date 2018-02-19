<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon super site</title>
</head>
<body>
<h1>Welcome!</h1>
<!-- Si un message et passé en attribut dans request: -->
<div style="green"><% if(request.getParameter("message") != null) out.print(request.getAttribute("message")); %></div>
Bienvenue sur le site de la vie.<br>
<!-- Si on est enregistré dans la session: -->
<% if(request.getSession().getAttribute("login") != null){ %>
	Vous êtes connecté en tant que <strong><% out.println(request.getSession().getAttribute("login")); %></strong> <a href="login?action=logout">cliquez ici</a> pour vous deconnecter
<% }else{%>
	Veuillez <a href="login?action=login">vous connecter</a>
<% }%>
</body>
</html>