<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="footer">
  <div id="footerText">
    <c:if test="${param.longPage}">
      <p class="pull-right"><a href="#">Back to top</a></p>
    </c:if>

    <p>&copy; 2017 VelecTi &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>