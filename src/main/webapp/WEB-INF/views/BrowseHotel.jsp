<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<p>Welcome username ${user.username}</p>
	<div class="container">
		<h2>Enter Destination</h2>
		<form method="POST" action="ViewHotel.htm">
			<div class="form-group">
				<label class="control-label" for="inputDefault">Destination</label>
				<input type="text" class="form-control" id="destination" name="destination">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>



</body>
</html>