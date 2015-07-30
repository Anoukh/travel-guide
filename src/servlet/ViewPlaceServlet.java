package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.ViewPlaceData;
import lk.travelguide.models.PlaceData;

/**
 * Servlet implementation class ViewPlaceServlet
 */
@WebServlet("/ViewPlaceServlet")
public class ViewPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String place = (String)request.getParameter("place");
		String placetype = (String)request.getParameter("type");
		System.out.println("*"+place+placetype);
		
		PlaceData pdobj;
		ViewPlaceData vpdobj = new ViewPlaceData();
		pdobj = vpdobj.retrivePlaceData(place);
		
		request.setAttribute("placename", pdobj.getPlacename());
		request.setAttribute("placetype", pdobj.getPlacetype());
		request.setAttribute("placecity", pdobj.getPlacecity());
		request.setAttribute("lat", pdobj.getLatitude());
		request.setAttribute("lng", pdobj.getLongitude());
		request.setAttribute("placedes", pdobj.getPlacedes());
		request.setAttribute("rating", pdobj.getRating());
		request.setAttribute("lastupdate", pdobj.getLastupdate());
		request.setAttribute("imagepath", pdobj.getImagepath());
		request.setAttribute("noofrates", pdobj.getNoofrates());
		request.getRequestDispatcher("/viewplace.jsp").forward(request, response);
	}

}
