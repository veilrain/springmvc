<!--
  Add Product Page
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Page Header -->
<jsp:include page="components/page-header.jsp">
  <jsp:param name="pageTitle" value="Add New Product"/>
  <jsp:param name="pageStyleFile" value="styles-login"/>
</jsp:include>

<div class="container"> 
    <h4>Add new product:</h4>

    <form>
        <input type="text" class="form-control" id="name" name="name" placeholder="Product Name" required>

        <input type="text" class="form-control" id="price" name="price" placeholder="Product Price" required>

        <input type="text" class="form-control" id="type" name="type" placeholder="Product Category" required>

        <textarea class="form-control" type="textarea" id="descript" placeholder="Product Description" maxlength="256" rows="7"></textarea>               
		
        <div class="checkbox">
          <label>
            <input type="checkbox" value="do-nothing"> Nothing
          </label>
        </div>

        <!-- Submit button -->
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn">Submit New Product</button>
    </form>
</div>

<jsp:include page="components/page-footer.jsp">
  <jsp:param name="longPage" value="false"/>
</jsp:include>
