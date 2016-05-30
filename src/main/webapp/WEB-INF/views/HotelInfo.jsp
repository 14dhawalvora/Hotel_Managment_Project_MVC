<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Hotel Info</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
.body, html {
	height: 100%;
	background-color: transparent;
	background-image: url(resources/images/img7.jpg);
	background-size: cover;
	background-attachment: fixed;
	font-family: 'FontAwesome', sans-serif;
}
</style>
<script>
	function myaddfunciton() {

		var x = document.getElementById("mydiv");
		var y = document.createElement("p");

		var newTitle = $("#newTitle").val();
		var newReview = $("#newReview").val();

		y.innerHTML = newTitle;
		x.appendChild(y);

	}
	
	$( document ).ready(function() {
		alert("Hi");
		
			$( "select" ).change(function () {
				var rating = $('#ratingvalue').val();
				var hotelIDajax =$('#hotelIDajax').val();
			   var username = $('#username').val();
				alert(rating);				
				$.ajax({
					 
			       url: "rateit.html",
			       type: "POST",
			       data : {
			       	rating : rating,
			           username : username,
			           hotelIDajax : hotelIDajax
			           
			       },
			       success : function(response){
			       	alert(response);
			       	 $("#rating").html(response);				                         
			       }
			   });
				
			});
	});

</script>
</head>
<body>

	<div class="container">
		<h2>Book Hotel</h2>
		<p>Welcome Username ${user.username}</p>

		<form role="form" method="POST" action="BookingPage">
			
				<h1>Hotel Info</h1>

				<p>${hotelSelected.hotelName}</p>

				<p>${hotelSelected.address}</p>

				<p>${hotelSelected.city}${hotelSelected.stateProvinceCode} ${hotelSelected.postalCode} ${hotelSelected.countryCode}</p>

				<p>${hotelSelected.shortDesc}</p>

				<p>${hotelSelected.roomDetailDesc}</p>

				<p>${hotelSelected.propertyDesc}</p>

				<input type="hidden" name="hotelID" value="${hotelSelected.hotelId}"></input>

				<input type="hidden" name="hotelName" value="${hotelSelected.hotelName}"></input> 
				<input type="hidden" name="hoteladdress" value="${hotelSelected.address}"></input> 
				<input type="hidden" name="hotelcity" value="${hotelSelected.city}"></input>
				<input type="hidden" name="hotelstateProvinceCode" value="${hotelSelected.stateProvinceCode}"></input> 
				<input type="hidden" name="hotelpostalCode" value="${hotelSelected.postalCode}"></input> 
				<input type="hidden" name="hotelcountryCode" value="${hotelSelected.countryCode}"></input>
				<input type="hidden" name="hotelhotelRating" value="${hotelSelected.hotelRating}"></input> 
				<input type="hidden" name="hotelshortDesc" value="${hotelSelected.shortDesc}"></input> 
				<input type="hidden" name="hotelhighrate" value="${hotelSelected.highrate}"></input> 
				<input type="hidden" name="hotellowRate" value="${hotelSelected.lowRate}"></input> 
				<input type="hidden" name="hotelcurrency" value="${hotelSelected.currency}"></input> 
				<input type="hidden" name="hotelthumbnailURL" value="${hotelSelected.thumbnailURL}"></input>
				<input type="hidden" name="hotelarrivalDate" value="${hotelSelected.arrivalDate}"></input> 
				<input type="hidden" name="hoteldepartureDate" value="${hotelSelected.departureDate}"></input>
				<input type="hidden" name="hotelcheckinTime" value="${hotelSelected.checkinTime}"></input> 
				<input type="hidden" name="hotelcheckoutTime" value="${hotelSelected.checkoutTime}"></input>
				<input type="hidden" name="hotelroomDetailDesc" value="${hotelSelected.roomDetailDesc}"></input> 
				<input type="hidden" name="hotelpropertyDesc" value="${hotelSelected.propertyDesc}"></input>
          


			<input name="hotelIDajax" id="hotelIDajax" value="${hotelSelected.hotelId}" type="hidden" /> 
			<input name="username" id="username" value="${user.username}" type="hidden" />


				<c:forEach items="${reviewList}" var="review">
					<p>${review.username}</p>
					<p>${review.title}</p>
				</c:forEach>

				
				<p>${reviewLasttitle} by ${reviewLastUsername}</p>			

			
				<h2>Your Feedback Please</h2>		
				<div id="rating" class="span4"></div>

			<a href="AddComment?hotelId=${hotelSelected.hotelId}" class="btn btn-info" role="button">Add a comment</a> 
			<select	id="ratingvalue" name="rating">

				<option selected value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>

			<div class="form-group">
				<button type="submit" class="btn btn-default">Complete Booking ></button>
			</div>
		</form>

		
		<c:forEach items="${reviewList}" var="review">
			<p>${review.title}</p>
			<p>${review.username}</p>
		</c:forEach>

		<div id="mydiv"></div>

		<div class="form-group">
			<label for="usr">Title</label> 
			<input type="text" id="newTitle" class="form-control" id="usr1" name="title">
		</div>

		<div class="form-group">
			<label for="usr">Review</label> 
			<input type="text" id="newReview" class="form-control" id="usr2" name="review">
		</div>

		<input type="hidden" name="fromPage" value="fromReviewPage"></input> 
		<input type="hidden" name="hotelId" value="${hotelSelected.hotelId}"></input>

		<div class="form-group">
			<button type="submit" class="btn btn-default" id="buttonadd" name="createabutton" value="create" onclick="myaddfunciton()">Submit review</button>
		</div>
	</div>

</body>
</html>