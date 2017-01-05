<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table>
		<c:forEach items="${product}" var="product">
			<tr>
				<td>${product.productName}</td>
				<td>${product.productCategory}</td>
				<td>${product.productPrice}</td>
				<td>${product.productDescription}</td>
			</tr>
		</c:forEach>
	</table> 
	<a href="<c:url value="/admin/addProduct" />">add product </a>
</body>
</html>