package servlet;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.models.PlaceData;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;





/**
 * Servlet implementation class AddPlaceImageServlet
 */
@WebServlet("/AddPlaceImageServlet")
public class AddPlaceImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public final String UPLOAD_DIRECTORY = "D:/TravelGuideImages/";     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlaceImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name;
		System.out.println("hi0");
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
        	System.out.println("hi");
            try {
            	
            	//delete file
            	//File file = new File("E:/Imgup/16488_10152772184627115_714214330910849049_n.jpg");
            	//file.delete();
            	
            	System.out.println("hi2");
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	System.out.println("hi3");
                         name = new File(item.getName()).getName();
                        String imgpath = UPLOAD_DIRECTORY +name;
                        //name = "Hi.jpg";
                         PlaceData pldata =new  PlaceData();
                         pldata.setImagepath(imgpath);
                       
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        System.out.println(name);
                        request.getRequestDispatcher("/addplace.jsp").forward(request, response);
                    }
                }
             
               //File uploaded successfully
              // request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               //request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }	
		
	}

}
