<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand">User Management Web App</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Users</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</header>
	
	<br>

	<c:if test="${user == null}">	
		<form action="insert" method="post">
	</c:if>
	
	<c:if test="${user != null}">	
		<form action="update" method="post">
	</c:if>
	
	<div class="container" style="width: 500px">
	
	<caption>
        <h2>
		<c:if test="${user != null}">
			Edit User
		</c:if>
		<c:if test="${user == null}">
			Add New User
		</c:if>
		</h2>
	</caption>
	
		<div class="input-group flex-nowrap" hidden>
		  <input type="number" value="<c:out value='${user.id}'/>" class="form-control" name="tbId" aria-label="id" aria-describedby="addon-wrapping">
		</div>
		<br>
	
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping1" style="width: 130px">Enter Name:</span>
		  <input type="text" value="<c:out value='${user.name}'/>" class="form-control" name="tbName" aria-label="name" aria-describedby="addon-wrapping">
		</div>
		<br>
		
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping2" style="width: 130px">Enter Email:</span>
		  <input type="email" value="<c:out value='${user.email}'/>" class="form-control" name="tbEmail" aria-label="email" aria-describedby="addon-wrapping">
		</div>	
		<br>
		
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping3" style="width: 130px">Enter Country:</span>
		  <input type="text" value="<c:out value='${user.country}'/>" class="form-control" name="tbCountry" aria-label="country" aria-describedby="addon-wrapping">
		</div>
		<br>
		
		<input type="submit" class="btn btn-secondary" value="Save" />
		
	</div>
</form>
</body>
</html>