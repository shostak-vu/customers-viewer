<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer viewer</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
    
</head>
  <body class="text-center">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form class="form-signin" action="${loginUrl}" method="post">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
        
      <input type="email" id="inputEmail" class="form-control" name="j_username" placeholder="Email address" required autofocus value="v.petrov@gmail.com">
        
      <input type="password" class="form-control" name="j_password" placeholder="Password" required value="admin">
        
      <div class="checkbox mb-3">      
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      
    </form>  
  </body>

</html>
