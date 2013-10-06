<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp"%>
<jsp:include page="layout/header.jsp">
	<jsp:param value="items" name="title" />
	<jsp:param value="items" name="page" />
</jsp:include>

<h1>Just a simple EShop demo application.</h1>

<p>This project is to showcase Spring, Spring Web MVC, JSPs and
	JSTL. Based on Maven, Hibernate, HSQLDB and Twitter Bootstrap.</p>

<p>This project contains embedded HSQL database, which destroys all
	data at shutdown. If you want different database, add JDBC driver to
	pom.xml and change META-INF/persistence.xml. Demo database will be
	re-initialized each day.</p>

<br />

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>name</th>
			<th>price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td><a href="items.html?id=${item.itemId}">${item.name}</a></td>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/footer.jsp" />
