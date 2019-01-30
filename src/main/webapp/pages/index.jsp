<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <title>Customer viewer</title>

</head>

<body class="container">

	<div class="text-center">
	
	<div class="flex-shrink-0">
  			<div class="container">
    			<h1 class="mt-5">Customer viewer</h1>
  			</div>
		</div>
	
	<sec:authorize access="!isAuthenticated()">
  		<p class="lead">For use customers list please sign in</p>
    	<a class="btn btn-secondary btn-success" href="<c:url value="/login" />" role="button">Sign in</a>
     
  	</sec:authorize>
  	<sec:authorize access="isAuthenticated()">        
 		<a class="btn btn-danger" href="<c:url value="/logout" />" role="button">Sign out</a>
    	<a class="btn btn-success" href="<c:url value="/clients" />" role="button">Show clients</a>
  	</sec:authorize>
	
	</div>

<footer class="footer mt-auto py-3 text-center">
  <div class="container">
    <span class="text-muted">  &copy; Customer viewer, 2019</span>
  </div>
</footer>

</body>
</html>
