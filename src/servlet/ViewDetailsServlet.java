package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AutoComPlace;
import lk.travelguide.models.SuggestedData;

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
		//System.out.println("hi");
		String placetype =request.getParameter("placetype");
		//System.out.println(placetype);
		AutoComPlace pl = new AutoComPlace();
		String placename = "";
		String places[] = pl.autocompleteplace("dropdown",placetype, placename);
		//System.out.println(placetype+"**");
		
		SuggestedData obj = new SuggestedData();
		obj.setPlacename(places);
		for(int i=0;i<places.length;i++){
			//System.out.println(places[i]+"***");
			
			response.getWriter().write("<tr><td>"+placetype+"</td><td>"+places[i]+"</td><td><a href='ViewPlaceServlet?place="+places[i]+"&type="+placetype+"'>view</a></td></tr>"); 
		}
	}

}
