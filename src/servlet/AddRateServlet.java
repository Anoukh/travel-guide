package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AddRate;

/**
 * Servlet implementation class AddRateServlet
 */
@WebServlet("/AddRateServlet")
public class AddRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("rate servlet");
		String rate = request.getParameter("rate");
		String placename = request.getParameter("placename");
		String placetype = request.getParameter("placetype");
		
		AddRate arobj = new AddRate();
		arobj.addrate(placename, placetype, rate);
		System.out.println("rate updated"); 
	}

}
