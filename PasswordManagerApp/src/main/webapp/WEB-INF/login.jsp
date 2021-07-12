<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">

<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Passtillery</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@forevolve/bootstrap-dark@1.1.0/dist/css/bootstrap-dark.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>

<body class="text-center">


	<div style="width: 300px; margin: 0 auto;">
		<form class="form-signin" action="index.do">
			<br> <br>
			<h1 class="h3 mb-3 font-weight-normal">Passtillery</h1>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-secondary btn-block" type="submit">Sign
				in</button>
			<br>
			<div class="container">
				<a href="https://github.com/ryspc/JPACRUDProject">Follow the
					development on Github &nbsp;<i class="fa fa-github"
					aria-hidden="true"></i>
				</a>
			</div>
		</form>
	</div>
</body>
</html>