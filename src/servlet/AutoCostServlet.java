package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import lk.travelguide.controllers.CostValues;
import lk.travelguide.controllers.CostValuesData;
import lk.travelguide.models.CostData;

/**
 * Servlet implementation class AutoCostServlet
 */
@WebServlet("/AutoCostServlet")
public class AutoCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCostServlet() {
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
		
		JSONObject obj=new JSONObject();
		PrintWriter out = response.getWriter();

		CostData cst;
		CostValuesData csv = new CostValuesData();
		cst = csv.costvaluesdata();
		
		double [] ArrCost=new double [2];
		
		ArrCost[0]=cst.getPetrol();
		ArrCost[1]=cst.getDiesel();
		
		obj.put("pet",ArrCost[0]);
		obj.put("die",ArrCost[1]);
	    out.print(obj);
	    out.flush();
		
		//response.getWriter().write(ArrCost);
		
		
	}

}
