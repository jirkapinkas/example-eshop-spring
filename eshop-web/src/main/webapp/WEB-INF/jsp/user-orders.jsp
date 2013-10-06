<%@page import="cz.jiripinkas.example.eshop.entity.UserOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp" %>
<jsp:include page="layout/header.jsp">
	<jsp:param value="user orders" name="title" />
	<jsp:param value="user_orders" name="page" />
</jsp:include>

<h1>User orders:</h1>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>name</th>
			<th>order date</th>
			<th>ordered items</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userOrders}" var="uo">
			<tr>
				<td><c:out value="${uo.name}" /></td>
				<td>
					<fmt:formatDate value="${uo.orderDate}" pattern="dd.MM.yyyy hh:mm:ss"/>
				</td>
				<td>
				<c:forEach items="${uo.orderedItems}" var="oi">
					${oi.item.name}: ${oi.quantity}<br/>
				</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/footer.jsp" />
