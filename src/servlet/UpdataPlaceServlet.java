package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.UpdataPlace;

/**
 * Servlet implementation class UpdataPlaceServlet
 */
@WebServlet("/UpdataPlaceServlet")
public class UpdataPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String placetype = request.getParameter("placetype");
		String placename = request.getParameter("placename");
		String placedes = request.getParameter("placedes");
		String placecharge = request.getParameter("placecharge");
		
		UpdataPlace up =new UpdataPlace();
		up.updateplacedetails(placetype, placename, placedes, placecharge);
	}

}
