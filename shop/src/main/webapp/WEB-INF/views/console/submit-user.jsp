<!--
  Add Product Page
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="Submit Product"/>
  <jsp:param name="pageStyleFile" value="styles-console"/>
</jsp:include>

<div class="container"> 
  <h4>Submit a user:</h4>

  <form:form 
    action="${pageContext.request.contextPath}/console/submit-user"
    method="POST"
    modelAttribute="newUser"
  >
    <form:input path="username" id="username" class="form-control" placeholder="User Name" value="${newUser.username}"/>
    <form:input path="password" id="password" class="form-control" placeholder="Password" value="${newUser.password}"/>

    <!-- inherited properties -->
    <form:input path="userId" value="${newUser.userId}" type="hidden"/>

    <!-- Submit button -->
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn">Submit Product</button>
  </form:form>
</div>

<jsp:include page="../components/page-footer-console.jsp" />
