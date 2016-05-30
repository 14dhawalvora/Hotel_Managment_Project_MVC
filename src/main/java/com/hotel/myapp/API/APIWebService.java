package com.hotel.myapp.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;






import org.json.simple.JSONArray;
//import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hotel.myapp.model.HotelInfo;

public class APIWebService {

	@SuppressWarnings("unchecked")
	public List<HotelInfo> hotellist(String destination, String arrivalDate, String departureDate){

		String urlstr = "https://api.eancdn.com/ean-services/rs/hotel/v3/list?"
				+ "_type=json&cid=55505"
				+ "&minorRev=30"
				+ "&apiKey=3w6yv6js2x5xz59ttbqeatrg"
				+ "&locale=en_US&currencyCode=USD"
				+ "&destinationString="+destination;
				//+ "&arrivalDate="+"04/25/2016"
				//+ "&departureDate="+"04/28/2016";
		System.out.println("1 "+urlstr);

		try{
			URL url = new URL(urlstr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;

			String json="";

			while((line = buffer.readLine()) != null){
				json += line;
			}

			JSONParser parser=new JSONParser();
			
			try {
				JSONObject root = (JSONObject) parser.parse(json);
				System.out.println(root.toJSONString());
				JSONObject data = (JSONObject) root.get("HotelListResponse");
				System.out.println("Data: "+data.toJSONString());
				JSONObject HotelList = (JSONObject) data.get("HotelList");
				System.out.println(HotelList.toString());
				//System.out.println(HotelList.isEmpty());
				JSONArray HotelSummary  = (JSONArray) HotelList.get("HotelSummary");


				List<HotelInfo> hotels = new ArrayList<HotelInfo>();

				for(int i=0;i<((List<HotelInfo>) HotelSummary).size();i++)
				{
					JSONObject hotelSummary = (JSONObject) HotelSummary.get(i);

					HotelInfo hotel = new HotelInfo();

					hotel.setHotelID(String.valueOf(hotelSummary.get("hotelId")));
					hotel.setCity((String) hotelSummary.get("city"));
					hotel.setAddress((String) hotelSummary.get("address1"));
					hotel.setCurrency((String) hotelSummary.get("rateCurrencyCode"));
					hotel.setHighrate(String.valueOf(hotelSummary.get("highRate")));
					hotel.setLowRate(String.valueOf(hotelSummary.get("lowRate")));
					hotel.setName((String) hotelSummary.get("name"));
					hotel.setShortDesc(String.valueOf(hotelSummary.get("shortDescription")).replace("&lt;p&gt;&lt;b&gt;Property Location&lt;/b&gt; &lt;br /&gt;", ""));
				//	System.out.println(hotel.getShortDesc());
					hotel.setThumbnailURL((String) hotelSummary.get("thumbNailUrl"));
					hotel.setHotelRating(String.valueOf(hotelSummary.get("hotelRating")));
					hotel.setArrivalDate(arrivalDate);
					hotel.setDepartureDate(departureDate);
					hotels.add(hotel);
				}
				System.out.println(hotels.size());
				return hotels;

			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	
	public static void main(String[] args) {
		APIWebService client = new APIWebService();
		client.hotellist("boston","04/25/2015","04/28/2015");
	}

}
