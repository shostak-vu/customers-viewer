<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        
	<title>Black List</title>	
</head>
<body >
  <sec:authorize access="!isAuthenticated()">
	  <c:redirect url="/login"/>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
	
	  
	  <ul  class="nav navbar-dark bg-primary justify-content-center">
  		<li class="nav-item">
     	  <a class="btn btn-success" href="<c:url value="/clients" />" >To clients</a>
  		</li>
  		<li class="nav-item">
    	  <a class="btn btn-danger" href="<c:url value="/logout" />" >Sign out</a>
  		</li>
	  </ul>	
	<div class = "container">
	<table class="table table-striped">
		<tr>
			<th>Id</th><th>Name</th><th>Phone</th><th>e-mail</th><th>The reason for adding</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th>			
		</tr>	
		<c:forEach var="blacklist" items="${blacklistAtribute}">
			<tr>							
				<td>${blacklist.getClient().getId()}</td>
				<td>${blacklist.getClient().getFirstName()}, ${blacklist.getClient().getLastName()}</td>
				<td>${blacklist.getClient().getPhoneNumber()}</td>				
				<td>${blacklist.getClient().getEmail()}</td>
				<td>${blacklist.getDescription()}</td>
				<td><a class="link" href="change?id=${blacklist.getClient().getId()}">Edit client</a></td>
				<td><a class="link" href="changeblocked?id=${blacklist.getId()}">Edit cause</a></td>
				<td><a class="link" href="deleteblocked?id=${blacklist.getId()}">Delete</a></td>			
			</tr>
		</c:forEach>
	</table>
	</div>
</sec:authorize>	
</body>
</html>