<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire d'identification</title>
</head>
<body>
<div style="color:red"><c:if test="${requestScope.error != null }"> ${requestScope.error}</c:if></div>
<h1>Formulaire de connection:</h1>
<form action="" method="post">
	<label for="login">Login</label>
	<input type="text" name="login" id="login" />
	<label for="passw">Mot de passe</label>
	<input type="text" name="password" id="passw" />
	<button type="submit">Ok</button>
</form>
</body>
</html>