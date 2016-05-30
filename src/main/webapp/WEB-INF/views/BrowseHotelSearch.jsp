<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Browse Hotels</title>

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
</head>
<body>

	<div id="banner">
		<a href="HomePage">HMS
		</a>
		<a href="ProfilePage?user=${user}"> Profile Page</a>
	</div>


	<div class="ny6">
		<div class="container">
			<div class="header">
				<div>
					<form method="GET" action="BrowseHotelSearch.htm">
					
						<div class="c2">
							Choose a location:<input type="text" id="destination"
								name="destination">
								</div>
								<div>
							<button type="submit" class="myButton">go..</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	

	<div class="container">
		<form method="POST" action="HotelInfoPage">
			<table class="table table-striped table-hover ">
				
				<tbody>					
						<c:forEach var="i" begin="0" end="${size}" step="1">

							<tr>							
								<td>
								<div class="hotelData">
									<p>${hotelList[i].name}</p>
									<p>${hotelList[i].shortDesc}</p>
									<p>${hotelList[i].city}</p>
									<p>${hotelList[i].highrate} and ${hotelList[i].lowRate}</p>
									<p>${hotelList[i].hotelRating}</p>
									<p>${hotelList[i].hotelID}</p>
									<p>${i}</p> <a
									href="HotelInfoPage?fromPage=fromHotelInfoPage&hotelID=${hotelList[i].hotelID}&hotelName=${hotelList[i].name}&hoteladdress=${hotelList[i].address}&hotelcity=${hotelList[i].city}&hotelstateProvinceCode=${hotelList[i].stateProvinceCode}&hotelcountryCode=${hotelList[i].countryCode}&hotelhotelRating=${hotelList[i].hotelRating}&hotelshortDesc=${hotelList[i].shortDesc}&hotelhighrate=${hotelList[i].highrate}&hotellowRate=${hotelList[i].lowRate}&hotelcurrency=${hotelList[i].currency}&hotelthumbnailURL=${hotelList[i].thumbnailURL}&hotelarrivalDate=${hotelList[i].arrivalDate}&hoteldepartureDate=${hotelList[i].departureDate}&hotelcheckinTime=${hotelList[i].checkinTime}&hotelcheckoutTime=${hotelList[i].checkoutTime}&hotelroomDetailDesc=${hotelList[i].roomDetailDesc}&hotelpropertyDesc=${hotelList[i].propertyDesc}">Show
										Details</a>
										</div>
								</td>
								
							</tr>

						</c:forEach>
				</tbody>
			</table>
		</form>

	</div>
</div>
</body>
</html>