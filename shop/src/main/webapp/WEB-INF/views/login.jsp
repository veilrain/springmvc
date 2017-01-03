<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Sign in to VE Store</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
      body {
        font-family: Myriad, sans-serif;
        background-color: #333333;
        color: #808080;
      }

      .container {
        margin-top: 50px;
        width: 400px;
        margin-left: auto; 
        margin-right: auto; 
      }

      h4 {
        font-weight: 100;
      }

      .form-control {
        margin-top: 15px;
        border-radius: 4px;
        background-color: #333333;
        color: white;
      }

      #submitBtn {
        background-image: none;
        background-color: #333333;
        border-color: #808080;
        border-radius: 4px;
      }


      /* Sticky footer styles
      -------------------------------------------------- */
      html {
        position: relative;
        min-height: 100%;
      }
      body {
        /* Margin bottom by footer height */
        margin-bottom: 80px;
      }

      .footer {
        position: absolute;
        bottom: 0;
        width: 100%;
        /* Set the fixed height of the footer here */
        height: 80px;
        background-color: #262626;
      }

      #footerText {
        margin: 30px;
      }
    </style>
  </head>

  <body>

    <div class="container">

<!--       <form class="form-signin">
        <h4>Please sign in:</h4>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        <p class="pull-right"><a href="#">Forget your password?</a></p>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitBtn">Sign in</button>
        <p class="checkbox">New customer?  <a href="#">create a new VelecTi account</a>.</p>
      </form> -->


	<form action="<c:url value="/j_spring_security_check"/>" method="post">
		<c:if test="${not empty error}">
			<div style="color: red">${error}</div>
		</c:if>

		<label for="user"></label><input id="user" type="text" /> <label
			for="password"></label><input id="password" type="password" /> <input
			type="submit" value="login" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
    </div> <!-- /container -->


    <!-- ============= Page Footer Start ============= -->
    <footer class="footer">
      <div id="footerText">
        <p>&copy; 2017 VelecTi &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </div>
    </footer>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- ============= Page Footer End ============= -->
  </body>
</html>

