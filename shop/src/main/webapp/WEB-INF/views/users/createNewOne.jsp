<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="VE Store - Login"/>
  <jsp:param name="pageStyleFile" value="styles-login"/>
</jsp:include>

<div class="container">
  <form:form action="${pageContext.request.contextPath}/create" commandName ="user" method="POST">
    <label for="username" class="sr-only"></label>
    <form:input path="username" id="username" class="form-control" placeholder="user name"/>
    <label for="password" class="sr-only"></label>
    <form:input path="password" id="password" class="form-control" placeholder="password"/>
    <label for="emailAddress" class="sr-only"></label>
    <form:input path="emailAddress" id="emailAddress" class="form-control" placeholder="Email address"/>
    <br/>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn" value="Create">Create</button>
  </form:form>
</div> <!-- /container -->

<jsp:include page="../components/page-footer.jsp">
  <jsp:param name="longPage" value="false"/>
</jsp:include>