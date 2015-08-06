package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.AddComments;

/**
 * Servlet implementation class AddCommentsServlet
 */
@WebServlet("/AddCommentsServlet")
public class AddCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comment = request.getParameter("placeusercomment");
		String placename = request.getParameter("placename");
		String placetype = request.getParameter("placetype");
				
		AddComments acobj = new AddComments();
		acobj.addcoments(placename,placetype,comment);
		System.out.println("new comment added");
		response.getWriter().write("comment added");
	}

}
