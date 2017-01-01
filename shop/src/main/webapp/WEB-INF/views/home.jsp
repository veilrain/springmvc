<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>VelecTi Store</title>
		<style>
			body {
				margin: 0px;
				padding: 0px;
				background-color: white;
				text-align: center;
				color: grey;
			}
			
			body, button, input, option, select {
				font-family: "Raleway", cursive;
				font-size: 14pt;
			}
			
			b, h1, h2 {
				font-weight: normal;
			}
			
			b {
				color: #dfb800;
			}
			
			h1 {
				background-color: #3a3a3a;
				line-height: 45px;
				color: white;
				margin: 0px;
				font-size: 20pt;
			}
			
			#tabsarea {
				background-color: #F8F8F8;
				margin: 0;
				border-bottom: 1px #616161 solid;
				overflow: hidden;
			}
			
			#tabs {
				overflow: hidden;
			  float: left;
			}
			
			#search {
			  float: right;
			}
			
			a {
			  text-decoration: none;
			}
			
			#tabs, #search {
			  padding: 10px;
			}
			
			button {
				background-color: transparent;
				border-radius: 5px;
				border: #616161 solid 1px;
				color: black;
				padding: 0px;
				margin: 0px;
				font-weight: normal;
			}
			
			input {
				padding: 0px;
				margin: 0px;
			}
			
			button:hover {
				background-color: #747474;
				color: white;
			}
			
			button:active {
				background-color: #515151;
				color: #a2a2a2;
			}
	</style>
		<link href="https://fonts.googleapis.com/css?family=Raleway:200" type="text/css" rel="stylesheet" />
	</head>

	<body>
      <h1>
    	<a href="https://yande.re/post/show/378392">
          <b>V</b>elecTi Store
    	</a>
      </h1>

    
		<div id="tabsarea">
      <div id="tabs">
        <a href="<c:url value="/viewProductList" />">
          Music Products
        </a>

        <a href="https://yande.re/post/show/378392">
          Other Products
        </a>

        <a href="https://yande.re/post/show/378392">
          Contact
        </a>
        
        <a href="<c:url value="/login"/>">
          Login
        </a>
      </div>

      <div id="search">
        <input id="searchinput">

				<button id="searchbutton"> Go! </button>
      </div>
		</div>
	</body>
</html>