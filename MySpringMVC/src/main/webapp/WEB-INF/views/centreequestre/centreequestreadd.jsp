<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
				<div class="card">
					<div class="card-header">Edition du Centre Equestre</div>
					<div class="card-body">
						<form:form method="POST" modelAttribute="centreEquestreObj" action="${pageContext.request.contextPath}/centreequestre/add">
							<div class="modal-body">
								<label>Nom *</label><br>
								<form:input path="nom" /><br>
								<label style="padding-top: 10px;">Adresse *</label><br>
								<form:input path="adresse" /><br>
								<label style="padding-top: 10px;">Code Postal *</label><br>
								<form:input path="codepostal" />
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
						</form:form>
					</div>
				</div>
<jsp:include page="../include/footer.jsp"/>