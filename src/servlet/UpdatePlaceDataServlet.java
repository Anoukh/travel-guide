package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.UpdatePlaceData;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class UpdatePlaceDataServlet
 */
@WebServlet("/UpdatePlaceDataServlet")
public class UpdatePlaceDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlaceDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hi1");
		 JSONObject obj=new JSONObject();
		 PrintWriter out = response.getWriter();
		
		String placetype = request.getParameter("placetype");
		String placename = request.getParameter("placename");
		
		UpdatePlaceData updpldata =new UpdatePlaceData();
		String pldata[] = updpldata.updplaceretdata(placetype, placename);
		
		// response.getWriter(pldata); 
		 //PrintWriter out = response.getWriter().write();
		  //out.append(pldata);
		  //out.close();
		System.out.println(pldata[1]);
		obj.put("pldes",pldata[0]);
		obj.put("plcharge",pldata[1]);
	    out.print(obj);
	    out.flush();
		
	}

}
