package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import lk.travelguide.controllers.SuggestRelatedPlaces;
import lk.travelguide.models.TravelSuggestPlacesData;

/**
 * Servlet implementation class SuggestRelatedPlacesServlet
 */
@WebServlet("/SuggestRelatedPlacesServlet")
public class SuggestRelatedPlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuggestRelatedPlacesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123");
		String placename = request.getParameter("placename");
		TravelSuggestPlacesData sugrelplaces;
		SuggestRelatedPlaces sgrelpl = new SuggestRelatedPlaces();
		sugrelplaces = sgrelpl.sugrelplaces(placename);

		String[] hotelsArray = sugrelplaces.getSuggestHotels();
		//String[] ArrangedHotel = new String[sugrelplaces.getSuggestHotels().length];
		String ArrangedHotel ="";
		for (int i = 0; i < hotelsArray.length; i++) {
			ArrangedHotel +="<input type='checkbox' name='SugHotels' value='"
				+ hotelsArray[i] + "'>" + hotelsArray[i] + "<br>";
		}

		
		//String total2 = String.valueOf(total);
		double[] hotelsArrayLngLat = sugrelplaces.getSugHotelsLonLat();
		//double[] ArrangedHotelLngLat = new double[sugrelplaces.getSugHotelsLonLat().length];
		String ArrangedHotelLngLat="";
		for (int i = 0; i < hotelsArrayLngLat.length; i++) {
			ArrangedHotelLngLat += "_"+String.valueOf(hotelsArrayLngLat[i]);
		}

		// System.out.println(ArrangedHotel[0]);

		String[] restsArray = sugrelplaces.getSuggestRests();
		//String[] ArrangedRest = new String[sugrelplaces.getSuggestRests().length];
		String ArrangedRest="";
		for (int i = 0; i < restsArray.length; i++) {
			ArrangedRest += "<input type='checkbox' name='SugRests' value='"
					+ restsArray[i] + "'>" + restsArray[i] + "<br>";
		}

		double[] restsArrayLngLat = sugrelplaces.getSugRestsLonLat();
		//double[] ArrangedRestLngLat = new double[sugrelplaces.getSugRestsLonLat().length];
		String ArrangedRestLngLat ="";
		for (int i = 0; i < restsArrayLngLat.length; i++) {
			ArrangedRestLngLat += "_"+String.valueOf(restsArrayLngLat[i]);
		}

		String[] leisureArray = sugrelplaces.getSuggestLeisure();
		//String[] ArrangedLeisure = new String[sugrelplaces.getSuggestLeisure().length];
		String ArrangedLeisure="";
		for (int i = 0; i < leisureArray.length; i++) {
			ArrangedLeisure += "<input type='checkbox' name='SugLeisure' value='"
					+ leisureArray[i] + "'>" + leisureArray[i] + "<br>";
		}

		double[] leisureArrayLngLat = sugrelplaces.getSugLeisureLonLat();
		//double[] ArrangedLeisureLngLat = new double[sugrelplaces.getSugLeisureLonLat().length];
		String ArrangedLeisureLngLat ="";
		for (int i = 0; i < leisureArrayLngLat.length; i++) {
			ArrangedLeisureLngLat += "_"+String.valueOf(leisureArrayLngLat[i]);
		}
/*
		String[] religiousArray = sugrelplaces.getSuggestReligious();
		//String[] ArrangedReligious = new String[sugrelplaces.getSuggestReligious().length];
		String ArrangedReligious="";
		for (int i = 0; i < religiousArray.length; i++) {
			ArrangedReligious += "<input type='checkbox' name='SugReligious' value='"
					+ religiousArray[i] + "'>" + religiousArray[i] + "<br>";
		}

		double[] religiousArrayLngLat = sugrelplaces.getSugReligiousLonLat();
		double[] ArrangedReligiousLngLat = new double[sugrelplaces
				.getSugReligiousLonLat().length];
		for (int i = 0; i < religiousArrayLngLat.length; i++) {
			ArrangedReligiousLngLat[i] = religiousArrayLngLat[i];
		}
*/
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		obj.put("HotelList", ArrangedHotel);
		//obj.put("HotelList", "hi");
		obj.put("RestList", ArrangedRest);
		obj.put("LeisureList", ArrangedLeisure);
		//obj.put("ReligiousList", ArrangedReligious);
		obj.put("HotelLLList", ArrangedHotelLngLat);
		obj.put("RestLLList", ArrangedRestLngLat);
		obj.put("LeisureLLList", ArrangedLeisureLngLat);
		//obj.put("ReligiousLLList", ArrangedReligiousLngLat);
		out.print(obj);
		out.flush();

	}

}
