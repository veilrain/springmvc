<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="Add New Product"/>
  <jsp:param name="pageStyleFile" value="styles-console"/>
</jsp:include>

<div class="container container-exlg">
	<table class="table">
		<thead>
      <tr>
        <th>PID</th>
        <th>Product Name</th>
        <th>Date Added</th>
        <th>Last Update</th>
        <th></th>
        <th></th>
      </tr>
    </thead>

		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td><a href="">${product.name}</a></td>
					<td>${product.dateAdded}</td>
					<td>${product.lastTimeModified}</td>
					<td><a href="<c:url value="/console/submit-product?id=${product.id}" />">edit</a></td>
					<td><a href="<c:url value="/console/delete?id=${product.id}" />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
</div>


<jsp:include page="../components/page-footer-console.jsp" />