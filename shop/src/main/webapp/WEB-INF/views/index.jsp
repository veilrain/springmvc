<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Header -->
<jsp:include page="components/page-header.jsp">
  <jsp:param name="pageTitle" value="Login to Console"/>
  <jsp:param name="pageStyleFile" value="styles-console"/>
</jsp:include>

<!-- Page Header -->

<h1> VE Store Home Page</h1>
<div class="container container-large">
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="${pageContext.request.contextPath}/console">Console</a>
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="${pageContext.request.contextPath}/login">User Login</a>
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="${pageContext.request.contextPath}/all-products">Test Add Cart</a>
  <a class="btn btn-lg btn-primary btn-block manageBtn" href="${pageContext.request.contextPath}/new">What's New</a>
</div> <!-- /container -->

<jsp:include page="components/page-footer-console.jsp">
  <jsp:param name="noback" value="true"/>
</jsp:include>