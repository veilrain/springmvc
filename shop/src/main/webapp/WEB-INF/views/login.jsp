<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Header -->
<jsp:include page="components/page-header.jsp">
  <jsp:param name="pageTitle" value="VE Store - Login"/>
  <jsp:param name="pageStyleFile" value="styles-login"/>
</jsp:include>

<div class="container">
  <form class="form-signin" action="<c:url value="/j_spring_security_check"/>" method="post">
    <h4>
    	Please sign in:<span class="errorarea">
    		<c:if test="${not empty error}">
				(${error})
			</c:if>
			<c:if test="${not empty msg}">
				(${msg})
			</c:if>
			</span>
    </h4>
    <label for="username" class="sr-only">Email address</label>
    <input id="username" name="username" type="text" class="form-control" placeholder="user name" required autofocus>
    <label for="password" class="sr-only">Password</label>
    <input id="password" name="password" type="password" class="form-control" placeholder="password" required>
    <div class="checkbox">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
      <p class="pull-right"><a href="#">Forget your password?</a></p>
    </div>
    
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn" value="login">Sign in</button>
    
    <p class="checkbox">New customer?  <a href="#">create a new VelecTi account</a>.</p>
    	
			
    
  </form>
</div> <!-- /container -->

<jsp:include page="components/page-footer.jsp">
  <jsp:param name="longPage" value="false"/>
</jsp:include>