package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AutoComPlace;

/**
 * Servlet implementation class AutoComPlaceServlet
 */
@WebServlet("/AutoComPlaceServlet")
public class AutoComPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoComPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i;
		String placetype =request.getParameter("placetype");
		String placename =request.getParameter("placename");
		AutoComPlace pl = new AutoComPlace();
		String places[] = pl.autocompleteplace(placetype, placename);
		System.out.println(placetype);
		for(i=0;i<places.length;i++){
	 response.getWriter().write("<option value= '" +places[i]+"'>"); 
		}
	}

}
