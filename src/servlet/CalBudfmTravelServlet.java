package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalBudfmTravelServlet
 */
@WebServlet("/CalBudfmTravelServlet")
public class CalBudfmTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalBudfmTravelServlet() {
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
		
		String [] SugHotelNames;
		String [] SugRestNames;
	String[] SugHotelsSplit;
	String[] SugRestsSplit;
	
		if(request.getParameter("SugHotels") != null){ 
		SugHotelNames = new String [SugHotels.length];
		
		}
		else{
			SugHotelNames  =new String[0];	
		}
		
		if(request.getParameter("SugRests") != null){ 
		SugRestNames = new String [SugRests.length];
		}
		else{
		SugRestNames  =new String[0];	
		}
		
		for(int i= 0; i<SugHotelNames.length;i++){
			SugHotelsSplit = SugHotels[i].split("_");
			SugHotelNames[i] = SugHotelsSplit[0] ;
		}
		
		for(int i= 0; i<SugRestNames.length;i++){
			SugRestsSplit = SugRests[i].split("_");
			SugRestNames[i] = SugRestsSplit[0] ;
		}
		//System.out.println(SugHotelNames[0]);
		
	}

}
