<%@page import="cz.jiripinkas.example.eshop.entity.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp" %>
<jsp:include page="layout/header.jsp">
	<jsp:param value="${item.name}" name="title" />
	<jsp:param value="items" name="page" />
</jsp:include>

<h1>${item.name}</h1>

<p>${item.description}</p>

<p>
	<strong>price per unit: ${item.price}</strong>
</p>

<form action="basket/add.html" class="form-horizontal">
	<div class="form-group">
		<input type="hidden" name="id" value="${item.itemId}"> 
		<label class="control-label col-lg-1">quantity:</label>
		<div class="col-lg-1">
			<input type="text" class="form-control" id="quantity" name="quantity" value="1" />
		</div>
		<input type="submit" class="btn btn-md btn-primary" value="Order" />
	</div>
</form>


<jsp:include page="layout/footer.jsp" />
