<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<div>
		<form method="POST" action="HotelInfo">
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>Name</th>
						<th>City</th>
						<th>High Rate</th>
						<th>Low Rate</th>
						<th>Short Description</th>
						<th>Hotel Rating</th>
						<th>test</th>
						<th>View Info</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="0" end="${size}" step="1">
						<tr>
							<td>${hotelList[i].name}</td>
							<td>${hotelList[i].city}</td>
							<td>${hotelList[i].highrate}</td>
							<td>${hotelList[i].lowRate}</td>
							<td>${hotelList[i].shortDesc}</td>
							<td>${hotelList[i].hotelRating}</td>
							<td>${hotelList[i].hotelID}</td>
							<td>${i}</td>

							<td><a
								href="HotelInfo?fromPage=fromHotelInfoPage&hotelID=${hotelList[i].hotelID}&hotelName=${hotelList[i].name}&hoteladdress=${hotelList[i].address}&hotelcity=${hotelList[i].city}&hotelstateProvinceCode=${hotelList[i].stateProvinceCode}&hotelcountryCode=${hotelList[i].countryCode}&hotelhotelRating=${hotelList[i].hotelRating}&hotelshortDesc=${hotelList[i].shortDesc}&hotelhighrate=${hotelList[i].highrate}&hotellowRate=${hotelList[i].lowRate}&hotelcurrency=${hotelList[i].currency}&hotelthumbnailURL=${hotelList[i].thumbnailURL}&hotelarrivalDate=${hotelList[i].arrivalDate}&hoteldepartureDate=${hotelList[i].departureDate}&hotelcheckinTime=${hotelList[i].checkinTime}&hotelcheckoutTime=${hotelList[i].checkoutTime}&hotelroomDetailDesc=${hotelList[i].roomDetailDesc}&hotelpropertyDesc=${hotelList[i].propertyDesc}">Show
									Details</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>

	</div>

</body>
</html>