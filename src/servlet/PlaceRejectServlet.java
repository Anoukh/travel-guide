package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AcceptPlace;
import lk.travelguide.controllers.RejectPlace;

/**
 * Servlet implementation class PlaceRejectServlet
 */
@WebServlet("/PlaceRejectServlet")
public class PlaceRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceRejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String placename = request.getParameter("placename");
		String placetype = request.getParameter("placetype");
		System.out.println(placename +"name");
		System.out.println(placetype+ "type");
		RejectPlace rpobj = new RejectPlace();
		rpobj.rejectplace(placename, placetype);
		//response.sendRedirect("http://localhost:8080/ViewPlaceServlet"); 
		
		System.out.println("place rejected");
	}

}
