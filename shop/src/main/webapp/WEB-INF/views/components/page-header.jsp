<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

  <meta name="description" content="">
  <meta name="author" content="">

  <title><c:out value="${param.pageTitle}" /></title>

  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/bootstrap/3.3.7/css/bootstrap.min.css" />" />
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles-common.css" />" />
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/${param.pageStyleFile}.css" />" />
</head>

<body>