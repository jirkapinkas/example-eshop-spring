<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp" %>
<jsp:include page="layout/header.jsp">
	<jsp:param value="order" name="title" />
	<jsp:param value="order" name="page" />
</jsp:include>

<c:choose>
	<c:when test="${empty basket.items}">
			<div class="alert alert-info">
				select some items into basket! ;)
			</div>
		</c:when>
	<c:otherwise>
		<p>do you wish to order these items?</p>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>item name</th>
					<th>quantity</th>
					<th>unit price</th>
					<th>ordered price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${basket.items}" var="orderedItem">
					<tr>
						<td>${orderedItem.item.name}</td>
						<td>${orderedItem.quantity}</td>
						<td>${orderedItem.item.price}</td>
						<td>${orderedItem.quantity * orderedItem.item.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<p>fillout your contact information:</p>

		<%@ taglib uri="http://www.springframework.org/tags/form"
			prefix="form"%>
		<form:form commandName="userOrder" cssClass="form-horizontal">
			<myTags:input path="name" label="name:" required="true" />
			<myTags:input path="city" label="city:" required="true" />
			<myTags:input path="street" label="street:" required="true" />
			<myTags:input path="zip" label="zip:" required="true" />
			<div class="form-group">
				<div class="col-lg-2">
					<input type="submit" class="btn btn-lg btn-primary" />
				</div>
			</div>
		</form:form>



	</c:otherwise>
</c:choose>

<jsp:include page="layout/footer.jsp" />
