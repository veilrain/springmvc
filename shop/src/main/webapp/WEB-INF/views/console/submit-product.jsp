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
  <h4>Submit a product:</h4>

  <form:form 
    action="${pageContext.request.contextPath}/console/submit-product"
    method="POST"
    modelAttribute="newProduct" enctype="multipart/form-data"
  >
    <form:input path="name" id="name" class="form-control" placeholder="Product Name" value="${newProduct.name}"/>
    <form:input path="price" id="price" class="form-control" placeholder="Product Price" value="${newProduct.price}"/>
    <form:input path="category" id="category" class="form-control" placeholder="Product Category" value="${newProduct.category}"/>

	<form:input path="productImg" id="productImg" type="file" placeholder="Product image" class="form:input-large" />

		<!-- inherited properties -->
    <form:input path="dateAdded" value="${newProduct.dateAdded}" type="hidden"/>
    <form:input path="id" value="${newProduct.id}" type="hidden"/>
    
    <form:textarea 
      path="description" 
      id="description" class="form-control" 
      placeholder="Product Description" 
      maxlength="256" rows="7"
      value="${newProduct.description}"
    />

    <!-- Submit button -->
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn">Submit Product</button>
  </form:form>
</div>

<jsp:include page="../components/page-footer-console.jsp" />
