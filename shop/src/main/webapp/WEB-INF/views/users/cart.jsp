<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="Cart"/>
  <jsp:param name="pageStyleFile" value="styles-console"/>
</jsp:include>

<div class="container container-exlg">
	<h1>Testing Shopping Cart</h1>
	<table class="table">
		<thead>
      <tr>
        <th>PID</th>
        <th>Product Name</th>
        <th>Count</th>
        <th></th>
      </tr>
    </thead>

		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.product.id}</td>
					<td><a href="">${product.product.name}</a></td>
					<td>${product.count}</td>
					<td><a href="<c:url value="/delete-from-cart?id=${product.entryId}" />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 


	<a href="${pageContext.request.contextPath}/all-products">Back To All Products</a>
</div>


<jsp:include page="../components/page-footer-console.jsp" />