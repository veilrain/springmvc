<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="footer">
  <div id="footerText">
  	<c:if test="${!param.noback}">
   	  <p class="pull-right"><a href="<c:url value="/"/>">Back to Main Page</a></p>
  	</c:if>
    <p>&copy; VE Store Management System (v0.0.1).</p>
  </div>
</footer>

<script src="<c:url value="/resources/js/jquery/3.1.1/jquery.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>


</body>
</html>