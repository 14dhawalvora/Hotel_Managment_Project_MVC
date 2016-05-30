<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Section</title>

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

	<c:forEach items="${reviewList}" var="review">
		<p>${review.title}</p>
	</c:forEach>

	<form role="form" method="GET" action="HotelInfo">
		<div class="form-group">
			<label for="usr">Title</label> 
			<input type="text" class="form-control" id="usr1" name="title">
		</div>

		<div class="form-group">
			<label for="usr">Review</label> 
			<input type="text" class="form-control" id="usr2" name="review">
		</div>

		<input type="hidden" name="fromPage" value="fromReviewPage"></input> 
		<input type="hidden" name="hotelId" value="${hotelId}"></input>

		<div class="form-group">
			<button type="submit" class="btn btn-default">Submit review</button>
		</div>
	</form>
	

</body>
</html>