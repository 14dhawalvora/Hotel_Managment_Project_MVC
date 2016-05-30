<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hotel Info</title>
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


	<div class="container">
		<h2>Book Hotel</h2>
		<p>Welcome username ${user.username}</p>
		
		<form role="form" method="POST" action="TransactionPage">
			<div class="form-group">
				<label for="usr">First Name:</label> <input type="text"
					class="form-control" id="usr1" name="firstName">
			</div>

			<div class="form-group">
				<label for="usr">Last Name:</label> <input type="text"
					class="form-control" id="usr2" name="lastName">
			</div>
			<div class="form-group">
				<label for="usr">Telephone</label> <input type="text"
					class="form-control" id="usr3" name="telephone">
			</div>

			<div class="form-group">
				<label for="usr">Arrival Date</label> <input type="text"
					class="form-control" id="usr4" name="arrivalDate">
			</div>

			<div class="form-group">
				<label for="usr">Departure Date</label> <input type="text"
					class="form-control" id="usr5" name="departureDate">
			</div>

			<div class="form-group">
				<label class="col-lg-2 control-label">Purpose</label>
				<div class="col-lg-10">
					<div class="radio">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios1" value="Leisure" checked=""> Leisure
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios2" value="Business"> Business
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="usr">Where should we send your email
					confirmation?</label> <input type="text" class="form-control" id="usr6"
					name="emailConfirmation">
			</div>
			
			<p>${hotelSelected.hotelId}</p>


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
		

		<div class="form-group">
			<button type="submit" class="btn btn-default">Complete Payment ></button>
		</div>
		</form>
	</div>


</body>
</html>