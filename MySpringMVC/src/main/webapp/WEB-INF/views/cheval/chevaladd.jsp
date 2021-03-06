<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>

<form:form method="POST" modelAttribute="chevalObj" action="${pageContext.request.contextPath}/cheval/add">
				<div class="card">
					<div class="card-header">Edition du cheval</div>
					<div class="card-body" style="padding-bottom: 0px;">
						<spring:hasBindErrors name="chevalObj">
						<div class="alert alert-danger">
							<form:errors path="nom"/><br>
							<form:errors path="remarque"/>
						</div>
						</spring:hasBindErrors>
						<div class="modal-body" style="padding-top: 0px;">
							<label>Nom *</label><br>
							<form:input path="nom"/>
							<br>
							
							<label style="padding-top: 10px;">Remarque *</label><br>
							<form:input path="remarque"/>
							<br>
<%-- 								<label style="padding-top: 10px;">Registre *</label><br>
								<form:select path="registre.id" items="${registres}" itemLabel="fullInfo" itemValue="id"/><br> --%>
							
							<label style="padding-top: 10px;">Centre Equestre *</label><br>
							<form:select path="centreEquestre.id" items="${centreEquestres}" itemLabel="nom" itemValue="id" />
							
							<form:input type="hidden" path="id" />
						</div>
						<div class="modal-footer">
							<form:button type="submit" class="btn btn-primary">
								<img src='<c:url value="/resources/images/submit.png" />' width="20px" height="20px">
							</form:button>
							<form:button type="reset" class="btn btn-warning">
								<img src='<c:url value="/resources/images/reset.png" />' width="20px" height="20px">
							</form:button>
						</div>
					</div>
				</div>
</form:form>
<jsp:include page="../include/footer.jsp"/>