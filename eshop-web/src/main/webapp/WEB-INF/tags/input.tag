<%@tag description="Extended input tag to allow for sophisticated errors" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>

<%--inspired by: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/ --%>

<c:if test="${empty label}">
    <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<spring:bind path="${path}">
    <div class="form-group ${status.error ? 'has-error' : '' }">
        <label class="control-label col-lg-1" for="${path}">${label}<c:if test="${required}"><span class="required">*</span></c:if></label>
        <div class="col-lg-3">
            <c:if test="${status.error}">
            	<c:forEach items="${status.errorMessages}" var="error">
	                <div class="alert alert-danger">${error}</div>
            	</c:forEach>
            </c:if>
            <form:input path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}"/>
        </div>
    </div>
</spring:bind>