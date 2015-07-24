package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import lk.travelguide.controllers.AddPlace;
import lk.travelguide.models.PlaceData;

/**
 * Servlet implementation class AddPlaceServlet
 */
@WebServlet("/AddPlaceServlet")
@MultipartConfig(maxFileSize = 16177215, location = "D:\\TravelGuideImages\\")
public class AddPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	 public final String UPLOAD_DIRECTORY = "E:/TravelGuideImages";
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
		 String adplresult;
	
		//location = request.getParameter("placetype");
		System.out.println("print1");
		
		 String placetype = (request.getParameter("placetype"));
	     String placename = (request.getParameter("placename"));
	     String placecity = (request.getParameter("placecity"));
	     String placedes = (request.getParameter("placedes"));
	     
	     PlaceData pldata =new PlaceData();
	     
	     String placeimg = "D:/TravelGuideImages/"+placetype+"/"+placename+".jpg";
	     String lt = (request.getParameter("lat"));
	   //  System.out.println(request.getParameter("lat"));
	    float  lat= Float.parseFloat(lt);
	     String lg = (request.getParameter("lng"));
	     float  lng= Float.parseFloat(lg);
	    String rating = (request.getParameter("rating"));
	     String placecharge = (request.getParameter("placecharge"));
	   
	     AddPlace adpl =new AddPlace();
	     System.out.println("print2");
	      adplresult =
		adpl.addplaces(placetype, placename, placecity, placedes, placeimg, lat, lng, rating, placecharge);
		
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
		
		try{
			if (filePart != null) {
				// prints out some information for debugging
			//	System.out.println(name1);
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				// File outputFile = new File(, "firstFile.txt"); 
				filePart.write("photo");
				// obtains input stream of the upload file
				//inputStream = filePart.getInputStream();
				
				File oldfile =new File("D:\\TravelGuideImages\\photo");
				File newfile =new File("D:\\TravelGuideImages\\"+placetype+"\\"+placename+".jpg");
				oldfile.renameTo(newfile);
				
			}else{
				adplresult ="Photo Upload failed";
			}
	}catch(Exception e){
		System.out.println(e);
	}
		
		request.setAttribute("addplacemsg", adplresult);
	     request.getRequestDispatcher("/addplace.jsp").forward(request, response);	
	}

}
