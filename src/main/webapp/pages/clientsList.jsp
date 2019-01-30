<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

        
        <title>Clients list</title>
</head>

<body >
	<sec:authorize access="!isAuthenticated()">
	  <c:redirect url="/login"/>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">	
	  
	  <ul  class="nav navbar-dark bg-primary justify-content-center">  		
  		<li class="nav-item">
     	  <a class="btn  btn-success" href="<c:url value="add" />" >Add new client</a>
  		</li>
  		<li class="nav-item">
     	  <a class="btn btn-dark" href="<c:url value="/blacklist" />" >Black list</a>
  		</li>
  		<li class="nav-item">
    	  <a class="btn btn-danger" href="<c:url value="/logout" />" >Sign out</a>
  		</li>
	  </ul>	  
	  
	  <div class = "container">
			<table class="table table-striped">
				<tr>
					<th>Id</th><th>Name</th><th>Phone</th><th>e-mail</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th>				
				</tr>	
					<c:forEach var="client" items="${clientsList}">
						<tr>							
							<td>${client.getId()}</td>
							<td>${client.getFirstName()}, ${client.getLastName()}</td>
							<td>${client.getPhoneNumber()}</td>				
							<td>${client.getEmail()}</td>
							<td><a class="btn btn-link" href="change?id=${client.getId()}">Edit</a></td>
							<td><a class="btn btn-link" href="delete?id=${client.getId()}">Delete</a></td>
							<td><a class="btn btn-link" href="toblacklist?id=${client.getId()}">Block</a></td>				
						</tr>
					</c:forEach>
			</table>
		
	</div>
	</sec:authorize>
	</body>
</html>