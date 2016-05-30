<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Complete Transaction</title>
</head>
<body>

<div class="container">
		<h2>Complete Transaction</h2>
		<p>Welcome username ${user.username}</p>
		
		<form role="form" method="POST" action="TransactionComplete">
		
			<div class="form-group">
				<label for="usr">Debit / Credit card number</label> <input type="text" class="form-control" id="usr1" name="cardNumber"/>
			</div>

			<div class="form-group">
				<label for="usr">Expiration Month</label> <input type="text" class="form-control" id="usr2" name="expMonth">
			</div>
			<div class="form-group">
				<label for="usr">Expiration Year</label> <input type="text" class="form-control" id="usr3" name="expYear"/>
			</div>

			<div class="form-group">
				<label for="usr">Security code</label> <input type="text" class="form-control" id="usr4" name="securityCode">
			</div>

			<div class="form-group">
				<label for="usr">Cardholder Name</label> <input type="text"	class="form-control" id="usr5" name="cardHolderName">
			</div>

			<div class="form-group">
				<label for="usr">Zip code</label> <input type="text" class="form-control" id="usr6"	name="zipCode">
			</div>


            <input type="hidden" name="bookingID" value="${booking.bookingID}"></input>
            
            <p>Booking id is ${booking.bookingID}</p>
            <input type="hidden" name="hotelId" value="${hotelSelected.hotelId}"></input>			
		

		<div class="form-group">
			<button type="submit" class="btn btn-default">Submit ></button>
		</div>
		</form>
	</div>

</body>
</html>