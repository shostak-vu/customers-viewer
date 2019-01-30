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
	<title>Edit client</title>
</head>

<body class="bg-light">
<sec:authorize access="!isAuthenticated()">
	  <c:redirect url="/login"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div class="container">
  <div class="form">
	<h1 class="h3 mb-3 font-weight-normal">
		Edit existing client
  </h1>
	<form:form method="POST" action="/cviewer/saveedit" modelAttribute="clientAttribute">
    	<table>                
                <tr>
                    <td></td>
                    <td><form:hidden path="id"/></td>
                </tr>
                <tr>
                    <td>First name:</td>
                    <td><form:input class="form-control"  path="firstName"/></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><form:input class="form-control"  path="lastName"/></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><form:input class="form-control"  path="phoneNumber"/></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><form:input class="form-control"  path="email"/></td>
                </tr>
                
                <tr>
                	<td></td>
                    <td><input class="btn btn-lg btn-primary btn-block" type="submit" value="Edit save"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a class="btn btn-lg btn-block btn-secondary" href="<c:url value="/clients" />" >Decline</a></td>
                </tr>
             </table>
        </form:form>
     </div> 
  </div>
</sec:authorize>
</body>
</html>