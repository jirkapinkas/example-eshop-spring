<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Jiri Pinkas">

    <title>${param.title}</title>

	<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCssUrl" />
    <link href="${bootstrapCssUrl}" rel="stylesheet">

	<c:url value="/resources/js/jquery-2.0.3.min.js" var="jqueryUrl" />
    <script src="${jqueryUrl}"></script>

	<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJsUrl" />
    <script src="${bootstrapJsUrl}"></script>
  </head>

  <body>

    <!-- Static navbar -->
    <div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <c:url value="/" var="homeUrl" />
          <a class="navbar-brand" href="${homeUrl}">EShop</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="${param.page eq 'items' ? 'active' : ''}"><a href="${homeUrl}">Items</a></li>
            <c:url var="basketUrl" value="/basket.html" />
            <li class="${param.page eq 'basket' ? 'active' : ''}"><a href="${basketUrl}">Basket</a></li>
            <c:url var="orderUrl" value="/order.html" />
            <li class="${param.page eq 'order' ? 'active' : ''}"><a href="${orderUrl}">Order items!</a></li>
            <c:url var="userOrdersUrl" value="/user-orders.html" />
            <li class="${param.page eq 'user_orders' ? 'active' : ''}"><a href="${userOrdersUrl}">User orders</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
