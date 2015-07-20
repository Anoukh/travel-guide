package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import lk.travelguide.controllers.AddPlace;
import lk.travelguide.models.PlaceData;

/**
 * Servlet implementation class AddPlaceServlet
 */
@WebServlet("/AddPlaceServlet")
public class AddPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 public final String UPLOAD_DIRECTORY = "E:/TravelGuideImages";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String placeimg =null;
		//String rating =null;
		
		System.out.println("print1");
		
		 String placetype = (request.getParameter("placetype"));
	     String placename = (request.getParameter("placename"));
	     String placecity = (request.getParameter("placecity"));
	     String placedes = (request.getParameter("placedes"));
	     
	     PlaceData pldata =new PlaceData();
	     
	     String placeimg = (pldata.getImagepath());
	     String lt = (request.getParameter("lat"));
	   //  System.out.println(request.getParameter("lat"));
	    float  lat= Float.parseFloat(lt);
	     String lg = (request.getParameter("lng"));
	     float  lng= Float.parseFloat(lg);
	    String rating = (request.getParameter("rating"));
	     String placecharge = (request.getParameter("placecharge"));
	   
	     AddPlace adpl =new AddPlace();
	     System.out.println("print2");
	     //String adplresult =
		adpl.addplaces(placetype, placename, placecity, placedes, placeimg, lat, lng, rating, placecharge);
		
	}

}
