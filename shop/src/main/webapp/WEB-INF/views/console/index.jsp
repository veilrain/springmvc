<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="Login to Console"/>
  <jsp:param name="pageStyleFile" value="styles-console"/>
</jsp:include>

<!-- Page Header -->

<h1> Welcome to VE Store Console</h1>
<div class="container container-large">
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="<c:url value="/console/product-list" />">View Current Products</a>
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="<c:url value="/console/submit-product" />">Add New Product</a>
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="<c:url value="/console/user-list" />">View Current Users</a>
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="<c:url value="/console/submit-user" />">Add New User</a>
</div> <!-- /container -->

<jsp:include page="../components/page-footer-console.jsp">
  <jsp:param name="noback" value="false"/>
</jsp:include>