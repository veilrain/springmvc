<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="Add New Product"/>
  <jsp:param name="pageStyleFile" value="styles-all"/>
</jsp:include>

<!-- Nav Bar -->
<jsp:include page="../components/nav-bar.jsp" />

<div class="container container-exlg">
	<table class="table">
<!-- 		<thead>
      <tr>
        <th>PID</th>
        <th>Product Name</th>
        <th>Date Added</th>
        <th>Last Update</th>
        <th></th>
      </tr>
    </thead> -->

		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>
						<img
							src= "/pic/${product.id}-2.png" 
							style="width: 80px; height: 80px;"
						/>
					</td>
					<td><a href="">${product.name}</a></td>
				<%-- 	<td>${product.dateAdded}</td>
					<td>${product.lastTimeModified}</td> --%>
					<td>
					<a href="<c:url value="/user/add-to-cart?id=${product.id}" />" class="">add to cart</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
</div>


<jsp:include page="../components/page-footer-console.jsp" />