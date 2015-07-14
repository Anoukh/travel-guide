package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.CostValues;

/**
 * Servlet implementation class CostValuesServlet
 */
@WebServlet("/CostValuesServlet")
public class CostValuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostValuesServlet() {
        super();  
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String pl = (request.getParameter("petrol"));
	     float  petrol= Float.parseFloat(pl);
	     String dl = (request.getParameter("diesel"));
	     float  diesel= Float.parseFloat(dl);
	     
	     CostValues cst =new CostValues();
	     cst.insertcostvalues(petrol, diesel);
	     
	}

}
