<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="thanks" name="title" />
	<jsp:param value="order" name="page" />
</jsp:include>

<div class="alert alert-success">
	Thank you very much, your order has been saved!
</div>

<jsp:include page="layout/footer.jsp" />