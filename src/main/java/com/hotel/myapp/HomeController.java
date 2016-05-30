package com.hotel.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.myapp.API.APIWebService;
import com.hotel.myapp.Dao.BookingDao;
import com.hotel.myapp.Dao.HibernateUtil;
import com.hotel.myapp.Dao.HotelDao;
import com.hotel.myapp.Dao.RatingDao;
import com.hotel.myapp.Dao.ReviewDao;
import com.hotel.myapp.Dao.TransactionDao;
import com.hotel.myapp.Dao.UserDao;
import com.hotel.myapp.model.Booking;
import com.hotel.myapp.model.Hotel;
import com.hotel.myapp.model.HotelInfo;
import com.hotel.myapp.model.Rating;
import com.hotel.myapp.model.Review;
import com.hotel.myapp.model.Transaction;
import com.hotel.myapp.model.User;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/*
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	 */

	@Autowired
	private UserDao userDao;

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private RatingDao ratingDao;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private ReviewDao reviewDao;

	/*
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initUserLoginForm(Model model) {
		
		return "HomePage";
	}
	
	@RequestMapping(value = "/HomePage", method = RequestMethod.GET)
	public String submitToPostHomePage(Model model) {
		
		return "HomePage";
	}
	

	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String submitToLoginPage(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "Login";
	}

	@RequestMapping(value="/RegisterUserPage",method=RequestMethod.GET)
	public String submitRegisterUserPage(Model model,HttpServletRequest request){

		return "RegisterUserPage";

	}

	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public String submitAfterRegister(Model model,HttpServletRequest request){
		User userNew=new User();

		userNew.setFirstname(request.getParameter("Firstname"));
		userNew.setLastname(request.getParameter("Lastname"));
		userNew.setDob(request.getParameter("dob"));
		userNew.setUsername(request.getParameter("Username"));
		userNew.setPassword(request.getParameter("Password"));
		userNew.setEmail(request.getParameter("Email"));

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(userNew);

		session.getTransaction().commit();

		session.close();

		User user=new User();
		model.addAttribute("user", user);
		return "Login";
	}

	@RequestMapping(value="/BrowseHotelSearch" ,method=RequestMethod.POST)
	public String submitForm(Model model, @Validated User user, BindingResult result, HttpServletRequest request){
		model.addAttribute("user",user);
		String returnVal = "BrowseHotelSearch";
		if (result.hasErrors()){
			return "Login";
		}else{
			try {
				User u = userDao.queryByUsernameAndPassword(user.getUsername(), user.getPassword());
				if (u != null){

					HttpSession session=request.getSession();
					session.setAttribute("user", u);
					model.addAttribute("user", session.getAttribute("user"));
					return returnVal;		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		return "Login";		
	}
	
	@RequestMapping(value = "/ProfilePage", method = RequestMethod.GET)
	public String submitToProfilePage(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		User user=(User) session.getAttribute("user");
		
		ArrayList<Booking> myBooking=bookingDao.queryBookingByUserId(user.getUserId());
		
		model.addAttribute("myBooking",myBooking);
		
		return "ProfilePage";
	}
	
	@RequestMapping(value="/BrowseHotelSearch", method=RequestMethod.GET)
	public String submitToGetAPISamePage(Model model, HttpServletRequest request){
		String returnVal = "BrowseHotelSearch";
		String destination=request.getParameter("destination");

		HttpSession session = request.getSession();

		try{
			APIWebService aws=new APIWebService();

			ArrayList<HotelInfo> hotelList=(ArrayList<HotelInfo>) aws.hotellist("boston", "", "");

			int size=(hotelList.size())-1;
			model.addAttribute("hotelList", hotelList);
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("size",size);
			return returnVal;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error on page BrowseHotel");
		}
		return returnVal;
	}
	
	

	@RequestMapping(value="/ViewHotel", method=RequestMethod.POST)
	public String submitToGetAPI(Model model, HttpServletRequest request){
		String returnVal = "ViewHotel";
		String destination=request.getParameter("destination");

		HttpSession session = request.getSession();

		try{
			APIWebService aws=new APIWebService();

			ArrayList<HotelInfo> hotelList=(ArrayList<HotelInfo>) aws.hotellist(destination, "","");

			int size=(hotelList.size())-1;
			model.addAttribute("hotelList", hotelList);
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("size",size);
			return returnVal;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error on page BrowseHotel");
		}
		return returnVal;
	}

	@RequestMapping(value="/HotelInfoPage", method=RequestMethod.GET)
	public String submitToGetHotelInfo(Model model, HttpServletRequest request) throws Exception{

		if(request.getParameter("fromPage").equals("fromHotelInfoPage")){

			HttpSession session = request.getSession();
			
			User user=(User) session.getAttribute("user");

			String returnVal="HotelInfoPage";
			//String iterator=request.getParameter("iterator");
			//System.out.println("iterator value is "+iterator);
			String hotelID=request.getParameter("hotelID");
			String hotelName=request.getParameter("hotelName");
			String hoteladdress=request.getParameter("hoteladdress");
			String hotelcity=request.getParameter("hotelcity");
			String hotelstateProvinceCode=request.getParameter("hotelstateProvinceCode");
			String hotelpostalCode=request.getParameter("hotelpostalCode");
			String hotelcountryCode=request.getParameter("hotelcountryCode");
			String hotelhotelRating=request.getParameter("hotelhotelRating");
			String hotelshortDesc=request.getParameter("hotelshortDesc");
			String hotelhighrate=request.getParameter("hotelhighrate");
			String hotellowRate=request.getParameter("hotellowRate");
			String hotelcurrency=request.getParameter("hotelcurrency");
			String hotelthumbnailURL=request.getParameter("hotelthumbnailURL");
			String hotelarrivalDate=request.getParameter("hotelarrivalDate");
			String hoteldepartureDate=request.getParameter("hoteldepartureDate");
			String hotelcheckinTime=request.getParameter("hotelcheckinTime");
			String hotelcheckoutTime=request.getParameter("hotelcheckoutTime");
			String hotelroomDetailDesc=request.getParameter("hotelroomDetailDesc");
			String hotelpropertyDesc=request.getParameter("hotelpropertyDesc");

			try{

				Session sessionSaveHotel = HibernateUtil.getSessionFactory().openSession();

				sessionSaveHotel.beginTransaction();

				Hotel hotelSelected=new Hotel();

				hotelSelected.setHotelId(Integer.parseInt(hotelID));
				hotelSelected.setHotelName(hotelName);
				hotelSelected.setAddress(hoteladdress);
				hotelSelected.setCity(hotelcity);
				hotelSelected.setStateProvinceCode(hotelstateProvinceCode);
				hotelSelected.setPostalCode(hotelpostalCode);
				hotelSelected.setCountryCode(hotelcountryCode);
				hotelSelected.setHotelRating(hotelhotelRating);
				hotelSelected.setShortDesc(hotelshortDesc);
				hotelSelected.setHighrate(hotelhighrate);
				hotelSelected.setLowRate(hotellowRate);
				hotelSelected.setCurrency(hotelcurrency);
				hotelSelected.setThumbnailURL(hotelthumbnailURL);
				hotelSelected.setArrivalDate(hotelarrivalDate);
				hotelSelected.setDepartureDate(hoteldepartureDate);
				hotelSelected.setCheckinTime(hotelcheckinTime);
				hotelSelected.setCheckoutTime(hotelcheckoutTime);
				hotelSelected.setRoomDetailDesc(hotelroomDetailDesc);
				hotelSelected.setPropertyDesc(hotelpropertyDesc);
				

				Review review=new Review();

				review.setUser(user);
				review.setHotel(hotelSelected);
				review.setUsername(user.getUsername());
				review.setTitle(request.getParameter("title"));
				review.setReview(request.getParameter("review"));
				review.setReviewDate(new Date());

				sessionSaveHotel.save(review);
				
				hotelSelected.getReviewList().add(review);
				user.getReviewList().add(review);
				
				sessionSaveHotel.saveOrUpdate(hotelSelected);


				model.addAttribute("user", session.getAttribute("user"));
				model.addAttribute("hotelSelected", hotelSelected);
				model.addAttribute("reviewList", hotelSelected.getReviewList());
				model.addAttribute("reviewLastUsername", user.getUsername());
				model.addAttribute("reviewLasttitle", request.getParameter("title"));


				

				sessionSaveHotel.getTransaction().commit();

				sessionSaveHotel.close();

				session.setAttribute("hotelSelected", hotelSelected);

				return returnVal;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error on page HotelInfo");
			}

			return returnVal;
		}
		else if(request.getParameter("fromPage").equals("fromReviewPage")){
			HttpSession session = request.getSession();

			User user=(User) session.getAttribute("user");

			String hotelId=request.getParameter("hotelId");

			System.out.println("string id is "+request.getParameter("hotelId"));
			System.out.println("int id is "+Integer.parseInt(hotelId));

			Hotel hotel=hotelDao.getHotelList(Integer.parseInt(hotelId));

			System.out.println(hotel.getHotelName());

			Review review=new Review();

			review.setUser(user);
			review.setHotel(hotel);
			review.setUsername(user.getUsername());
			review.setTitle(request.getParameter("title"));
			review.setReview(request.getParameter("review"));
			review.setReviewDate(new Date());

			Session sessionSaveReview = HibernateUtil.getSessionFactory().openSession();

			sessionSaveReview.beginTransaction();

			sessionSaveReview.save(review);

			sessionSaveReview.getTransaction().commit();

			sessionSaveReview.close();


			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("hotelSelected", hotel);
			model.addAttribute("reviewList", hotel.getReviewList());
			model.addAttribute("reviewLastUsername", user.getUsername());
			model.addAttribute("reviewLasttitle", request.getParameter("title"));


			return "HotelInfoPage";
		}
		return null;
	}

	@RequestMapping(value = "/rateit.html", method = RequestMethod.POST)
	public @ResponseBody String rateit(@ModelAttribute(value="Rating") Rating Rating, HttpSession session, HttpServletRequest request) {
		//UserDetails userDetails=(UserDetails)session.getAttribute("userDetails");
		//Hotel newhotel=new Hotel();
		//System.out.println(AjaxRatingData.getRating());
		//HotelInfo hotel=webService.getHotelInfomation(hotelID);	

		Session sessionRating = HibernateUtil.getSessionFactory().openSession();
		sessionRating.beginTransaction();

		System.out.println("rateit ONE");
		
		Rating r=new Rating();
		r.setHotelIDajax(Rating.getHotelIDajax());
		r.setUsername(Rating.getUsername());
		r.setRating(Rating.getRating());
		
		System.out.println("rateit TWO");

		User u=(User) session.getAttribute("user");
		
		System.out.println("rateit THREE");

		//u.getRatingList().add(r);

		sessionRating.saveOrUpdate(r);
		
		System.out.println("rateit FOUR");

		Rating rlast=ratingDao.lastRating();
		
		System.out.println("rateit SIX");

		u.getRatingList().add(rlast);
		
		System.out.println("rateit SEVEN");

		sessionRating.getTransaction().commit();

		sessionRating.close();

		//System.out.println("Rating size - "+u.getRatingList().size());

		return "Your response has been recorded with a rating of "+Rating.getRating();
	}


	@RequestMapping(value="/AddComment", method=RequestMethod.GET)
	public String submitToReviewPage(Model model,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();

		String hotelId=request.getParameter("hotelId");

		Hotel hotel=hotelDao.getHotelList(Integer.parseInt(hotelId));

		System.out.println(hotel.getHotelName());

		model.addAttribute("reviewList", hotel.getReviewList());
		model.addAttribute("hotelId",hotelId);
		model.addAttribute("user", session.getAttribute("user"));

		return "AddComment";
	}


	@RequestMapping(value="/BookingHotelPage", method=RequestMethod.POST)
	public String submitToBookingContinue(Model model,HttpServletRequest request){

		HttpSession session = request.getSession();
		
		String returnVal="BookingHotelPage";
		/*

		String hotelID=request.getParameter("hotelID");
		String hotelName=request.getParameter("hotelName");
		String hoteladdress=request.getParameter("hoteladdress");
		String hotelcity=request.getParameter("hotelcity");
		String hotelstateProvinceCode=request.getParameter("hotelstateProvinceCode");
		String hotelpostalCode=request.getParameter("hotelpostalCode");
		String hotelcountryCode=request.getParameter("hotelcountryCode");
		String hotelhotelRating=request.getParameter("hotelhotelRating");
		String hotelshortDesc=request.getParameter("hotelshortDesc");
		String hotelhighrate=request.getParameter("hotelhighrate");
		String hotellowRate=request.getParameter("hotellowRate");
		String hotelcurrency=request.getParameter("hotelcurrency");
		String hotelthumbnailURL=request.getParameter("hotelthumbnailURL");
		String hotelarrivalDate=request.getParameter("hotelarrivalDate");
		String hoteldepartureDate=request.getParameter("hoteldepartureDate");
		String hotelcheckinTime=request.getParameter("hotelcheckinTime");
		String hotelcheckoutTime=request.getParameter("hotelcheckoutTime");
		String hotelroomDetailDesc=request.getParameter("hotelroomDetailDesc");
		String hotelpropertyDesc=request.getParameter("hotelpropertyDesc");

*/
		try{
			
/*
			hotelSelected.setHotelId(Integer.parseInt(hotelID));
			hotelSelected.setHotelName(hotelName);
			hotelSelected.setAddress(hoteladdress);
			hotelSelected.setCity(hotelcity);
			hotelSelected.setStateProvinceCode(hotelstateProvinceCode);
			hotelSelected.setPostalCode(hotelpostalCode);
			hotelSelected.setCountryCode(hotelcountryCode);
			hotelSelected.setHotelRating(hotelhotelRating);
			hotelSelected.setShortDesc(hotelshortDesc);
			hotelSelected.setHighrate(hotelhighrate);
			hotelSelected.setLowRate(hotellowRate);
			hotelSelected.setCurrency(hotelcurrency);
			hotelSelected.setThumbnailURL(hotelthumbnailURL);
			hotelSelected.setArrivalDate(hotelarrivalDate);
			hotelSelected.setDepartureDate(hoteldepartureDate);
			hotelSelected.setCheckinTime(hotelcheckinTime);
			hotelSelected.setCheckoutTime(hotelcheckoutTime);
			hotelSelected.setRoomDetailDesc(hotelroomDetailDesc);
			hotelSelected.setPropertyDesc(hotelpropertyDesc);

*/
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("hotelSelected", session.getAttribute("hotelSelected"));

			return returnVal;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error on page Booking Page");
		}

		return null;
	}

	@RequestMapping(value="/TransactionBookingPage",method=RequestMethod.POST)
	public String submitToTransactionPage(Model model,HttpServletRequest request){

		String returnVal="TransactionBookingPage";
		System.out.println("TEST Hotel id "+request.getParameter("hotelID"));
		String hotelID=request.getParameter("hotelID");

		HttpSession sessionNew = request.getSession();

		String bookingFirstName=request.getParameter("firstName");
		String bookingLastName=request.getParameter("lastName");
		String bookingtelephone=request.getParameter("telephone");
		String bookingArrivalDate=request.getParameter("arrivalDate");
		String bookingDepartureDate=request.getParameter("departureDate");
		String bookingOptionsRadios=request.getParameter("optionsRadios");
		String bookingEmailConfirmation=request.getParameter("emailConfirmation");


		try{
			Hotel hotelSelected=(Hotel) sessionNew.getAttribute("hotelSelected");
			Booking booking=new Booking();
			
			booking.setUser((User) sessionNew.getAttribute("user"));


			booking.setFirstname(bookingFirstName);
			booking.setLastname(bookingLastName);
			booking.setTelephone(Integer.parseInt(bookingtelephone));
			booking.setArrivalDate(bookingArrivalDate);
			booking.setDepartureDate(bookingDepartureDate);
			booking.setPurpose(bookingOptionsRadios);
			booking.setEmailConf(bookingEmailConfirmation);

			booking.setHotel(hotelSelected);

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			model.addAttribute("user", sessionNew.getAttribute("user"));
			session.saveOrUpdate(hotelSelected);
			model.addAttribute("hotelSelected", hotelSelected);
			session.saveOrUpdate(booking);
			model.addAttribute("booking", booking);		

			session.getTransaction().commit();

			session.close();
			
			sessionNew.setAttribute("booking", booking);

			return returnVal;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error on page Transaction Page");
		}

		return null;
	}

	@RequestMapping(value="/TransactionComplete",method=RequestMethod.POST)
	public String submitToTransactionComplete(Model model,HttpServletRequest request) throws Exception{
		String returnVal="TransactionComplete";

		HttpSession sessionNew = request.getSession();

		String transactioncardNumber=request.getParameter("cardNumber");
		String transactionexpMonth=request.getParameter("expMonth");
		String transactionexpYear=request.getParameter("expYear");
		String transactionsecurityCode=request.getParameter("securityCode");
		String transactioncardHolderName=request.getParameter("cardHolderName");
		String transactionzipCode=request.getParameter("zipCode");

		Transaction transaction=new Transaction();		

		transaction.setCardNumber(Integer.parseInt(transactioncardNumber));
		transaction.setExpMonth(transactionexpMonth);
		transaction.setExpYear(Integer.parseInt(transactionexpYear));
		transaction.setSecCode(Integer.parseInt(transactionsecurityCode));
		transaction.setCardHolderName(transactioncardHolderName);
		transaction.setZipCode(Integer.parseInt(transactionzipCode));
		
		System.out.println("Transaction - "+transactioncardNumber+" "+transactionexpMonth+" "+transactionexpYear+" "+transactionexpYear+" "+transactionsecurityCode+" "+transactioncardHolderName+" "+transactionzipCode);
		
		//System.out.println("Transaction ID - "+transaction.getTransactionID());
		
		Booking booking=(Booking) sessionNew.getAttribute("booking");
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		session.saveOrUpdate(transaction);
		
		Transaction transactionLast=transactionDao.lastTransaction();
		
		System.out.println("Transaction ID LAST- "+transactionLast.getTransactionID());
		
		System.out.println("Booking ID LAST- "+booking.getBookingID());
		
		booking.setTransaction(transactionLast);
		
		transactionLast.setBooking((Booking) sessionNew.getAttribute("booking"));

		Hotel hotelSelected=(Hotel) sessionNew.getAttribute("hotelSelected");

		//System.out.println(request.getParameter("bookingID"));
		String bookingID=request.getParameter("bookingID");
		//int transactionID=transaction.getTransactionID();

		//Hotel hotel=hotelDao.getHotelList(Integer.parseInt(hotelID));
		//Booking bookingNew=bookingDao.getBookings(Integer.parseInt(bookingID));

		//System.out.println("check booking object in transaction complete "+booking.toString());
		//Transaction transac=transactionDao.getTransaction(transactionID);
		
		hotelSelected.getBookingList().add(booking);
		
		booking.setHotel(hotelSelected);

		model.addAttribute("user", sessionNew.getAttribute("user"));

		

		//session.save(hotel);

		session.saveOrUpdate(booking);
		
		session.saveOrUpdate(hotelSelected);

		session.getTransaction().commit();

		session.close();

		return returnVal;
	}
}
