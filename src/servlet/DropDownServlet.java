package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AutoComPlace;

/**
 * Servlet implementation class DropDownServlet
 */
@WebServlet("/DropDownServlet")
public class DropDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i;
		String placetype =request.getParameter("placetype");
		//String placename =request.getParameter("placename");
		AutoComPlace pl = new AutoComPlace();
		String placename = "";
		String places[] = pl.autocompleteplace("dropdown",placetype, placename);
		System.out.println(places[1]);
		for(i=0;i<places.length;i++){
	 response.getWriter().write("<option value= '" +places[i]+"'>"+places[i]+"</option>"); 
		}
	}

}
