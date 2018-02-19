<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>

<form:form method="POST" modelAttribute="authObj" action="${pageContext.request.contextPath}/auth/login">
				<div class="card">
					<div class="card-header">Authentification</div>
					<div class="card-body" style="padding-bottom: 0px;">
						<spring:hasBindErrors name="authObj">
						<div class="alert alert-danger">
							<form:errors path="login"/><br>
							<form:errors path="passwrd"/>
						</div>
						</spring:hasBindErrors>
						<div class="modal-body" style="padding-top: 0px;">
							<div class="form-group">
								<label>Login *</label><br>
								<form:input path="login" class="form-control"/>
							</div>
							<div class="form-group">
								<label>Password *</label>
								<form:input path="passwrd" class="form-control"/>
							</div>
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