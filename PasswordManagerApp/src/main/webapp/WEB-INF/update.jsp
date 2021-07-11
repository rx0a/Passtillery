<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Manager</title>
</head>
<body>


		<h1>My Accounts</h1>
		<h3>Search</h3>
	<form action="getAccount.do" method="POST">
		<input type="text" name="keyword"/> 
		<input type="submit" value="Search "/>
	</form>
	

	
		<h3>Create Account</h3>
	<form action="createAccount.do" method="POST" id="create">
		<b>Name</b> <br />
		<input type="text" name="name" /> <br />
		<b>Username</b> <br />
		<input type="text" name="username" /> <br />
		<b>Password</b> <br />
		<input type="text" name="password" /> <br />
		<b>URL</b><br> 
		<input type="text" name="url" /> <br />
		<b>Notes</b> <br />
		<input type="text" name="notes" /> <br />
	    <input type="submit" value="Submit" form="create" />
	</form>
	
	
	
		<h3>Accounts</h3>
	<c:choose>
	<c:when test="${! empty accounts}">
	<c:forEach var="account" items="${accounts}">
	<form action="showDetails.do" method="POST">
	<div>
		<input type="hidden"name="id" value="${account.id}"> 
		Favicon: <img src="https://www.google.com/s2/favicons?domain=${account.url}" alt="favicon">
		Name: ${account.name} <br>
		Username: ${account.username} <br>
		<input type="submit" value="details"/> 
	</div>
	</form>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<p>No accounts found</p>
	</c:otherwise>
	</c:choose>



		<h3>Account Info</h3>
	<c:choose>
	<c:when test="${! empty account}">
	<form action="editAccount.do" method="POST" id="update">
	<div>
		<b>Name</b> <br />
		<input type="text" name="name" value="${account.name}" > <br />
		<b>Username</b> <br />
		<input type="text" name="username" value="${account.username}" > <br />
		<b>Password</b> <br />
		<input type="text" name="password" value="${account.password}" > <br />
		<b>URL</b> <br />
		<input type="text" name="url" value="${account.url}" > <br />
		<b>Notes</b> <br />
		<input type="text" name="notes" value="${account.notes}" > <br />
		<input type="hidden"name="id" value="${account.id}"> 
		<input type="submit" name=action value="Update" form="update"/> 
		<input type="submit" name=action value="Delete" form="update"/>
	</div>
	</form>
	</c:when>
	<c:otherwise>
		<p>No account found</p>
	</c:otherwise>
	</c:choose>
	
	
	
</body>
</html>