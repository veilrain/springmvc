<!--
  What's New Page
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Page Header -->
<jsp:include page="components/page-header.jsp">
  <jsp:param name="pageTitle" value="VE Store - What's New"/>
  <jsp:param name="pageStyleFile" value="styles-new"/>
</jsp:include>

<!-- Nav Bar -->
<jsp:include page="components/nav-bar.jsp" />

<!-- === What's new slide shows ==== -->
<div id="slideShows">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="https://files.yande.re/jpeg/5e5b9483132a07b3f0738293d6958803/yande.re%20370697%20animal_ears%20breast_hold%20bunny_ears%20cream%20ke-ta%20nipples%20ringo_%28touhou%29%20tail%20topless%20touhou.jpg" 
        alt="p0" height="345px">
      </div>

      <div class="item">
        <img src="https://files.yande.re/jpeg/1f993022ee7965e57af7ee9cd09f849f/yande.re%20370696%20junko%20ke-ta%20nipples%20topless%20touhou.jpg"
        alt="p1" height="345px">
      </div>

      <div class="item active">
        <img src="https://files.yande.re/image/125e210ae0f9915f5519279e1ef12b16/yande.re%20354889%20bloomers%20dress%20ke-ta%20star_sapphire%20touhou.jpg" 
        alt="p0" height="345px">
      </div>

      <div class="item">
        <img src="https://files.yande.re/image/11dd3ffcfa5e48788d443bc8c793d47a/yande.re%20355285%20ke-ta%20kochiya_sanae%20touhou.jpg"
        alt="p1" height="345px">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


<div class="container" id="fourThumbs">

  <!-- Three columns of text below the carousel -->
  <div class="row">
    <div class="colLom col-lg-3 col-sm-3 col-xs-6">
      <a href="#" class="thumbnail" style="background-image: url(https://assets.yande.re/data/preview/96/f2/96f271c924dc0dea6a3d9b96aaedd674.jpg)">
        <div class="thumbPlaceHolder"> </div>
        <p>Description</p>
      </a>
    </div><!-- /.col-lg-4 -->
    <div class="colLom col-lg-3 col-sm-3 col-xs-6">
      <a href="#" class="thumbnail" style="background-image: url(https://assets.yande.re/data/preview/6f/63/6f6387323771495172d985308f95d502.jpg)">
        <div class="thumbPlaceHolder"> </div>
        <p>Description</p>
      </a>
    </div><!-- /.col-lg-4 -->
    <div class="colLom col-lg-3 col-sm-3 col-xs-6">
      <a href="#" class="thumbnail" style="background-image: url(https://assets.yande.re/data/preview/95/09/950949119d848bda0625e7095d54b5da.jpg)">
        <div class="thumbPlaceHolder"> </div>
        <p>Description</p>
      </a>
    </div><!-- /.col-lg-4 -->
    <div class="colLom col-lg-3 col-sm-3 col-xs-6">
      <a href="#" class="thumbnail" style="background-image: url(https://assets.yande.re/data/preview/6f/96/6f9622c7c42b6eb12f281dc9c1b5b107.jpg)">
        <div class="thumbPlaceHolder"> </div>
        <p>Description</p>
      </a>
    </div><!-- /.col-lg-4 -->
  </div><!-- /.row -->
</div><!-- /.container -->

<jsp:include page="components/page-footer.jsp">
  <jsp:param name="longPage" value="true"/>
</jsp:include>
