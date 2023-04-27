<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>User List Page</title>
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
	<div class="container">
		<h2>List of Users</h2>
		<hr>
		<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
		<br>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Country</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<!-- for(datatype variable : collection)  -->
		  	<!-- { -->					
		  		<c:forEach var="u" items="${listUser}">
				    <tr>
				    	<td>
				    		<c:out value="${u.id}"></c:out>
				    	</td>
				    	<td>
				    		<c:out value="${u.name}"></c:out>
				    	</td>
				    	<td>
				    		<c:out value="${u.email}"></c:out>
				    	</td>
				    	<td>
				    		<c:out value="${u.country}"></c:out>
				    	</td>
				    	<td>
				    		<a href="edit?id=<c:out value="${u.id}"></c:out>">Edit</a>
				    		&nbsp;&nbsp;&nbsp;&nbsp;
				    		                <!-- Query String -->
				    		<a href="delete?id=<c:out value="${u.id}"></c:out>">Delete</a>
				    	</td>
				    </tr>
				 </c:forEach>
			<!-- } -->
		    
		  </tbody>
		</table>
	</div>

</body>
</html>