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
        <th>UID</th>
        <th>User Name</th>
        <th>User password</th>
        <th></th>
        <th></th>
      </tr>
    </thead>

		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td><a href="<c:url value="/console/submit-user?id=${user.userId}" />">edit</a></td>
					<td><a href="<c:url value="/console/delete-user?id=${user.userId}" />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
</div>


<jsp:include page="../components/page-footer-console.jsp" />