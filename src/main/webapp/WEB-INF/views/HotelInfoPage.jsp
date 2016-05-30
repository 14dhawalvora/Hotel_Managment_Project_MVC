<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Info Page</title>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Lobster&subset=cyrillic,latin' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Dancing+Script:700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/CSS/search.css" />
<style type="text/css">
.body, html {
	height: 100%;
	background-color: transparent;
	background-image: url(resources/images/img7.jpg);
	background-size: cover;
	background-attachment: fixed;
	font-family: 'FontAwesome', sans-serif;
}

.hotelData {
	
	/*margin-left: 6.5%;
	width: 65%;
	background: #7f7f7f;
	background:rgba(0,0,0,0.2);
	border-bottom-left-radius: 10px 10px;
	border-bottom-right-radius: 10px 10px;
	border-top-right-radius: 10px 10px;
	border-top-left-radius: 10px 10px;
	margin-top: 1%;
	padding: 2%;
	box-shadow: 5px 5px 5px;
	font-size: 20px*/
	
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	height: auto;
	width: 62%;
	background-color: #F7F7DF;
	background-image: url();
	opacity: 0.9;
	margin-top: 1%;
	padding: 1%;
	font-size: 20px;
	border-bottom-left-radius: 10px 10px;
	border-bottom-right-radius: 10px 10px;
	border-top-right-radius: 10px 10px;
	border-top-left-radius: 10px 10px;
	box-shadow: #ccc2a6 5px 5px 5px;
	
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
	
	$(document).ready(function() {
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

	<div id="banner">
		<a href="HomePage.html" target="_blank">HMS</a>
	</div>


	<div class="ny6">
		<div class="container">
			<div class="header">
				<div>
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


			</form>				
		</div>
	</div>
</div>
	

	<div class="container">
	<div class="hotelData">
	
	
				<c:forEach items="${reviewList}" var="review">
					<p>${review.username}</p>
					<p>${review.title}</p>
				</c:forEach>
</div>
	<div class="hotelData">
		
				
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
				
				<form role="form" method="POST" action="BookingHotelPage">

				<div class="form-group">
					<button type="submit" class="btn btn-default">Complete Booking ></button>
				</div>
				
				</form>
				
				<div class="hotelData">
		
		<div id="mydiv"></div>

		<div class="form-group">
			<label for="usr">Title</label> 
			<input type="text" id="newTitle" class="form-control" name="title">
		</div>

		<div class="form-group">
			<label for="usr">Review</label> 
			<input type="text" id="newReview" class="form-control" name="review">
		</div>

		<input type="hidden" name="fromPage" value="fromReviewPage"></input> 
		<input type="hidden" name="hotelId" value="${hotelSelected.hotelId}"></input>

		<div class="form-group">
			<button type="submit" class="btn btn-default" id="buttonadd" name="createabutton" value="create" onclick="myaddfunciton()">Submit review</button>
		</div>
		
		
		<c:forEach items="${reviewList}" var="review">
			<p>${review.title}</p>
			<p>${review.username}</p>
		</c:forEach>
		</div>
		
		</div>
		

	</div>
</div>
</body>
</html>