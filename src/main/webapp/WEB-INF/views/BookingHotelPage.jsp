<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Hotels</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<link
	href='http://fonts.googleapis.com/css?family=Lobster&subset=cyrillic,latin'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Pacifico'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Dancing+Script:700'
	rel='stylesheet' type='text/css'>
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
		<a href="HomePage.html" target="_blank">HMS</a>
	</div>


	<div class="ny6">
		<div class="container">
			<div class="header">
				<div class="container">
					<h2>Book Hotel</h2>
					<p>Welcome username ${user.username}</p>


					<form method="POST" action="TransactionBookingPage">
						<table>
							<tr>
								<td>
									<div class="form-group">
										<label for="usr">First Name:</label> </div></td><td><div class="form-group"><input type="text"
											class="form-control" id="usr1" name="firstName">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="form-group">
										<label for="usr">Last Name:</label> </td><td><input type="text"
											class="form-control" id="usr2" name="lastName">
									</div>
								</td>
							</tr>
							<tr>
								<td>

									<div class="form-group">
										<label for="usr">Telephone</label></td><td> <input type="text"
											class="form-control" id="usr3" name="telephone">
									</div>
								</td>
							</tr>
							<tr>
								<td>

									<div class="form-group">
										<label for="usr">Arrival Date</label></td><td> <input type="text"
											class="form-control" id="usr4" name="arrivalDate">
									</div>
								</td>
							</tr>
							<tr>
								<td>

									<div class="form-group">
										<label for="usr">Departure Date</label></td><td> <input type="text"
											class="form-control" id="usr5" name="departureDate">
									</div>
								</td>
							</tr>
							<tr>
								<td>

									<div class="form-group">
										<label class="col-lg-2 control-label">Purpose</label></td><td>
										<div class="col-lg-10">
											<div class="radio">
												<label> <input type="radio" name="optionsRadios"
													id="optionsRadios1" value="Leisure" checked="">
													Leisure
												</label>
											</div>
											
											<div class="radio">
												<label> <input type="radio" name="optionsRadios"
													id="optionsRadios2" value="Business"> Business
												</label>
											</div></td>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>

									<div class="form-group">
										<label for="usr">Where should we send your email
											confirmation?</label></td><td> <input type="text" class="form-control"
											id="usr6" name="emailConfirmation">
									</div>
								</td>
							</tr>

							<!-- 		

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
		
 -->
							<tr><td></td>
								<td>

									<div class="form-group">
										<button type="submit" class="btn btn-default">Complete
											Payment ></button>
									</div>
								</td>
							</tr>

						</table>

					</form>
				</div>

			</div>
		</div>

	</div>
</body>
</html>