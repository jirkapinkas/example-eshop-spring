<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp" %>
<jsp:include page="layout/header.jsp">
	<jsp:param value="basket" name="title" />
	<jsp:param value="basket" name="page" />
</jsp:include>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>remove</th>
			<th>item name</th>
			<th>quantity</th>
			<th>unit price</th>
			<th>ordered price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${basket.items}" var="orderedItem">
			<tr>
				<td>
					<form action="basket/remove.html">
						<input type="hidden" name="id" value="${orderedItem.item.itemId}" />
						 <input
							type="image" src="resources/icons/delete.png" title="remove" alt="remove" onclick="return confirm('Really remove from basket?');">
					</form>
				</td>
				<td>${orderedItem.item.name}</td>
				<td>${orderedItem.quantity}</td>
				<td>${orderedItem.item.price}</td>
				<td>${orderedItem.quantity * orderedItem.item.price}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/footer.jsp" />