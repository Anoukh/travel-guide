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
		String placeimg =null;
		//String rating =null;
		if(ServletFileUpload.isMultipartContent(request)){
            try {
            	
            	//delete file
            	//File file = new File("E:/Imgup/16488_10152772184627115_714214330910849049_n.jpg");
            	//file.delete();
            	
            	
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                	System.out.println("1");
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        
                        name = "Hi.jpg";
                        
                        
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        System.out.println(name);
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }
		
		else{
			
			System.out.println("fail");
		}
		
		System.out.println("print1");
		
		 String placetype = (request.getParameter("placetype"));
	     String placename = (request.getParameter("placename"));
	     String placecity = (request.getParameter("placecity"));
	     String placedes = (request.getParameter("placedes"));
	     //String placeimg = (request.getParameter("placeimg"));
	    // String lt = (request.getParameter("lat"));
	   //  System.out.println(request.getParameter("lat"));
	    // float  lat= Float.parseFloat(lt);
	   //  String lg = (request.getParameter("lng"));
	   //  float  lng= Float.parseFloat(lg);
	    String rating = (request.getParameter("rating"));
	     String placecharge = (request.getParameter("placecharge"));
	   
	     AddPlace adpl =new AddPlace();
	     System.out.println("print2");
	     //String adplresult =
		//adpl.addplaces(placetype, placename, placecity, placedes, placeimg, lat, lng, rating, placecharge);
		
	}

}
