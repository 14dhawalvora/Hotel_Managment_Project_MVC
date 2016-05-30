<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>

<head>

<meta charset="UTF-8">

<title>Login Page</title>

<link rel="stylesheet" href="resources/CSS/log-in.css">

<meta charset="utf-8">

<title>Login</title>

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">


</head>

<body>

	<div class="banner">
		<a href="homePage.html" target="_blank">HOME</a>
	</div>


	<div class="container">

		<div id="login">

			<form role="form" method="POST" action="Login">

				<fieldset class="clearfix">

					<p>
						<span class="fontawesome-user"></span> 
						<input type="text" value="Firstname" name="Firstname" />
					<p>
						<span class="fontawesome-user"></span> 
						<input type="text" value="Lastname" name="Lastname" />
					<p>
						<span class="fontawesome-user"></span> 
						<input type="text" value="Date of birth" name="dob" />
					<p>
						<span class="fontawesome-user"></span> 
						<input type="text" value="Username" name="Username" />
					<p>
						<span class="fontawesome-user"></span>
						<input type="password" value="Password" name="Password" />
						
						<p><span class="fontawesome-user"></span>
            <input type="text" value="Email" name="Email"/>

            <p><input type="submit" value="Register"></p>

          
				</fieldset>

			</form>

		

		</div>
		<!-- end login -->

	</div>

</body>
</html>
