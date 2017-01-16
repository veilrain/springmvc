<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Page Header -->
<jsp:include page="../components/page-header.jsp">
  <jsp:param name="pageTitle" value="VE Store - What's New"/>
  <jsp:param name="pageStyleFile" value="styles-product"/>
</jsp:include>

<!-- Nav Bar -->
<jsp:include page="../components/nav-bar.jsp" />

<div class="jumbotron" id="productHeader" style="background-image: url(http://orig10.deviantart.net/e844/f/2014/347/f/f/fate_stay_night_unlimited_blade_works_hd_wallpaper_by_tammypain-d89one4.png)">
  <h1>CD Name here</h1>
  <p>This is a template showcasing the optional theme stylesheet 
    included in Bootstrap. Use it as a starting point to create something 
    more unique by building on or modifying it.
  </p>
</div>



<jsp:include page="../components/page-footer.jsp">
  <jsp:param name="longPage" value="true"/>
</jsp:include>