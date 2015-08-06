package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.CostBudget;
import lk.travelguide.models.CostData;

/**
 * Servlet implementation class CostBudgetServlet
 */
@WebServlet("/CostBudgetServlet")
public class CostBudgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostBudgetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CostData cstdt; 
		String costtype = request.getParameter("costtype");
		System.out.println(costtype);
		CostBudget cstbgt =new CostBudget();
		cstdt = cstbgt.costtypeBudget(costtype);
		
		String type =""; 
		if(costtype.equals("petrol")){
			type = Double.toString(cstdt.getPetrol());
		}
		if(costtype.equals("diesel")){
			type = Double.toString(cstdt.getDiesel());
		}
		
		response.getWriter().write(type);
	}

}
