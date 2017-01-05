<!--
  Add Product Page
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Page Header -->
<jsp:include page="components/page-header.jsp">
  <jsp:param name="pageTitle" value="Add New Product"/>
  <jsp:param name="pageStyleFile" value="styles-login"/>
</jsp:include>

<div class="container"> 
    <h4>Add new product:</h4>

    <form:form action="${pageContext.request.contextPath}/admin/addProduct" method="post" commandName="product" >
<!--         <input type="text" class="form-control" id="name" name="name" placeholder="Product Name" required> -->
        <form:input path="productName" id="name" class="form-control" />
<!--         <input type="text" class="form-control" id="price" name="price" placeholder="Product Price" required> -->
        <form:input path="productPrice" id="price" class="form-control"  placeholder="Product Name"/>
        
<!--         <input type="text" class="form-control" id="type" name="type" placeholder="Product Category" required> -->
        <form:input path="productCategory" id="Category" class="form-control"  />

      <!--   <textarea class="form-control" type="textarea" id="descript" placeholder="Product Description" maxlength="256" rows="7"></textarea>                -->
		 <form:textarea path="productDescription" id="Description" class="form-control" />
		
        <div class="checkbox">
          <label>
            <input type="checkbox" value="do-nothing"> Nothing
          </label>
        </div>

        <!-- Submit button -->
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn">Submit New Product</button>
    </form:form>
</div>

<jsp:include page="components/page-footer.jsp">
  <jsp:param name="longPage" value="false"/>
</jsp:include>
