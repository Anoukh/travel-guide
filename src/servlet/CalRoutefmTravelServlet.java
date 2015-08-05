package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.models.TravelSuggestPlacesData;

/**
 * Servlet implementation class CalRoutefmTravelServlet
 */
@WebServlet("/CalRoutefmTravelServlet")
public class CalRoutefmTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalRoutefmTravelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String [] SugHotels = request.getParameterValues("SugHotels");
		String [] SugRests = request.getParameterValues("SugRests");
		String [] SugLeisure = request.getParameterValues("SugLeisure");
		String [] SugReligious = request.getParameterValues("SugReligious");
		
//		for (int m=0; m < SugLeisure.length;m++ ){
//			System.out.println(SugLeisure[m]);
//		}
		String [] SugHotelsSplit;
		String [] SugHotelsNames;
		double [] SugHotelsLatLng ;
		
		if(request.getParameter("SugHotels") != null){ 
			SugHotelsLatLng =new double [2*SugHotels.length];
			SugHotelsNames =new String [SugHotels.length];
		for(int i=0; i< SugHotels.length;i++){
			SugHotelsSplit =  SugHotels[i].split("_");
			SugHotelsNames[i] =  SugHotelsSplit[0];
			SugHotelsLatLng[2*i]=  Double.parseDouble(SugHotelsSplit[1]);
			SugHotelsLatLng[2*i+1]=  Double.parseDouble(SugHotelsSplit[2]);
			//System.out.println(SugHotelsNames[i]);   
		}
		
		
		}
		else{
			SugHotelsLatLng = new double[0];
			SugHotelsNames  = new String[0];
			SugHotels = new String[0]; 
		}
		
		String [] SugRestsSplit;
		String [] SugRestsNames;
		double [] SugRestsLatLng ;
		
		
		
		if(request.getParameter("SugRests") != null){ 
			
			for(int j=0 ;j<SugRests.length;j++){
				System.out.println(SugRests[j]);
			}
			
			SugRestsLatLng =new double [2*SugRests.length];
			SugRestsNames =new String [SugRests.length];
		for(int i=0; i< SugRests.length;i++){
			SugRestsSplit =  SugRests[i].split("_");
			SugRestsNames[i] =  SugRestsSplit[0];
			SugRestsLatLng[2*i]=  Double.parseDouble(SugRestsSplit[1]);
			SugRestsLatLng[2*i+1]=  Double.parseDouble(SugRestsSplit[2]);
			//System.out.println(SugHotelsNames[i]);   
		}
		
		
		}
		else{
			SugRestsLatLng = new double[0];
			SugRestsNames  = new String[0];
			SugRests = new String[0]; 
		}
		
		String [] SugLeisureSplit;
		String [] SugLeisureNames;
		double [] SugLeisureLatLng ;
		
		if(request.getParameter("SugLeisure") != null){ 
			//System.out.println("in");
			SugLeisureLatLng =new double [2*SugLeisure.length];
			SugLeisureNames =new String [SugLeisure.length];
		for(int i=0; i< SugLeisure.length;i++){
			//System.out.println();
			SugLeisureSplit =  SugLeisure[i].split("_");
			SugLeisureNames[i] =  SugLeisureSplit[0];
			SugLeisureLatLng[2*i]=  Double.parseDouble(SugLeisureSplit[1]);
			SugLeisureLatLng[2*i+1]=  Double.parseDouble(SugLeisureSplit[2]);
			//System.out.println(SugHotelsNames[i]);   
		}
		
		
		}
		else{
			SugLeisureLatLng = new double[0];
			SugLeisureNames  = new String[0];
			SugLeisure = new String[0]; 
		}
		
//		for (int m=0; m < SugLeisureNames.length;m++ ){
//		System.out.println(SugLeisureNames[m]);
//	}		
		
		
		String [] SugReligiousSplit;
		String [] SugReligiousNames;
		double [] SugReligiousLatLng ;
		
		if(request.getParameter("SugReligious") != null){ 
			SugReligiousLatLng =new double [2*SugReligious.length];
			SugReligiousNames =new String [SugReligious.length];
		for(int i=0; i< SugReligious.length;i++){
			SugReligiousSplit =  SugReligious[i].split("_");
			SugReligiousNames[i] =  SugReligiousSplit[0];
			SugReligiousLatLng[2*i]=  Double.parseDouble(SugReligiousSplit[1]);
			SugReligiousLatLng[2*i+1]=  Double.parseDouble(SugReligiousSplit[2]);
			//System.out.println(SugHotelsNames[i]);   
		}
		
		
		}
		else{
			SugReligiousLatLng = new double[0];
			SugReligiousNames  = new String[0];
			SugReligious = new String[0]; 
		}
		
		double [] LngLat =new double [2+ 2*SugHotels.length +  2*SugRests.length + 2*SugLeisure.length +  2*SugReligious.length ];
		
		LngLat[1] = Double.parseDouble(request.getParameter("startlon"));
		LngLat[0] = Double.parseDouble(request.getParameter("startlat"));
		
		int a,b,c,d;
		for (a=0;a<SugHotelsLatLng.length;a++){
			LngLat[a+2] =	SugHotelsLatLng[a];
		}
		for (b=0;b<SugRestsLatLng.length;b++){
			LngLat[b+a+2] =	SugRestsLatLng[b];
		}
		for (c=0;c<SugLeisureLatLng.length;c++){
			LngLat[c+b+a+2] =	SugLeisureLatLng[c];
		}
		for (d=0;d<SugReligiousLatLng.length;d++){
			LngLat[d+c+b+a+2] =	SugReligiousLatLng[d];
		}
		
//		for(int k=0;k<LngLat.length;k++){
//			System.out.println(LngLat[k]);
//		}
		
String [] LngLatNames =new String [1+ SugHotelsNames.length +  SugRestsNames.length + SugLeisureNames.length +  SugReligiousNames.length ];
		
LngLatNames[0] = request.getParameter("pac-input");
		//LngLat[0] = Double.parseDouble(request.getParameter("startlat"));
		
		int e,f,g,h;
		for (e=0;e<SugHotelsNames.length;e++){
			LngLatNames[e+1] =	SugHotelsNames[e];
		}
		for (f=0;f<SugRestsNames.length;f++){
			LngLatNames[f+e+1] =	SugRestsNames[f];
		}
		for (g=0;g<SugLeisureNames.length;g++){
			LngLatNames[g+f+e+1] =	SugLeisureNames[g];
		}
		for (h=0;h<SugReligiousNames.length;h++){
			LngLatNames[h+g+f+e+1] =	SugReligiousNames[h];
		}
		
		
		System.out.println("check 1");
//		for(int k=0;k<SugLeisureNames.length;k++){
//			System.out.println(SugLeisureNames[k]);
//		}
		
		TravelSuggestPlacesData trvselpls = new TravelSuggestPlacesData();
		trvselpls.setSelPlacesLonLat(LngLat);
		trvselpls.setSelectedPlaces(LngLatNames);
		trvselpls.setSuggestHotels(SugHotelsNames);
		trvselpls.setSuggestRests(SugRestsNames);
		trvselpls.setSuggestLeisure(SugLeisureNames);
		trvselpls.setSuggestReligious(SugReligiousNames);
		
		//System.out.println(LngLatNames.length);
		System.out.println("check 2");
		
		request.setAttribute("LngLatObject", trvselpls);
	     request.getRequestDispatcher("/route.jsp").forward(request, response);
		
	}

}
