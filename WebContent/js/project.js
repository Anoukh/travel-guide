package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AutoComPlace;
import lk.travelguide.models.ViewPlaceData;

/**
 * Servlet implementation class ViewDetailsServlet
 */
@WebServlet("/ViewDetailsServlet")
public class ViewDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ViewPlaceData obj = new ViewPlaceData();
		//String placename[]=obj.getPlacename();
		AutoComPlace plc = new AutoComPlace();
		String placetype =request.getParameter("placetype");
		String placename = "";
		String places[] = plc.autocompleteplace("dropdown",placetype, placename);
		for(int i=0;i<places.length;i++){
		
			response.getWriter().write("<tr><td>Hotel</td><td>"+ places[i] + "</td><td>"+"<a href="+"\"viewplace.jsp\">"+"view</a></td></tr>");
		}
	}

}



