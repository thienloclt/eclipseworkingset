<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="include/header.jsp" />
	
	<h1>WELCOME ON SPRING MVC!!!</h1>
	<h2>Passage de paramètres:</h2>
	<ul>
	<c:choose>
	  <c:when test="${method == null }">
	   <li> 	Aucun nom de méthode passé en paramètre</li>
	  </c:when>
	  <c:otherwise>
	    <li>Methode: ${method}</li>
  	 </c:otherwise>
	</c:choose>
	<br>
	<c:choose>
	  <c:when test="${value == null }">
	    	<li>Aucune Valeur passé en paramètre</li>
	  </c:when>
	  <c:otherwise>
	    <li>Value: ${value}</li>
  	 </c:otherwise>
	</c:choose>
	<br>
	<c:choose>
	  <c:when test="${cat == null }">
	   <li>aucune catégorie passé en paramètre</li>
	  </c:when>
	  <c:otherwise>
	    <li>Catégorie: ${cat}</li>
  	 </c:otherwise>
	</c:choose>
</ul>
<c:import url="include/footer.jsp" />
