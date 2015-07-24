package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import lk.travelguide.controllers.UpdataPlace;

/**
 * Servlet implementation class UpdataPlaceServlet
 */
@WebServlet("/UpdataPlaceServlet")
@MultipartConfig(maxFileSize = 16177215, location = "D:\\TravelGuideImages\\")
public class UpdataPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String placetype = request.getParameter("placetype");
		String placename = request.getParameter("placename");
		String placedes = request.getParameter("placedes");
		String placecharge = request.getParameter("placecharge");
		
		UpdataPlace up =new UpdataPlace();
		up.updateplacedetails(placetype, placename, placedes, placecharge);
		
		InputStream inputStream = null;
		Part filePart = request.getPart("placeimg");
		
		try{
			if (filePart != null) {
				// prints out some information for debugging
			//	System.out.println(name1);
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				File file = new File("D:\\TravelGuideImages\\"+placetype+"\\"+placename+".jpg");
            	file.delete();
            	
				
				// File outputFile = new File(, "firstFile.txt"); 
				filePart.write("placeimg");
				// obtains input stream of the upload file
				//inputStream = filePart.getInputStream();
				
				File oldfile =new File("D:\\TravelGuideImages\\placeimg");
				File newfile =new File("D:\\TravelGuideImages\\"+placetype+"\\"+placename+".jpg");
				oldfile.renameTo(newfile);
				
			}else{
				//adplresult ="Photo Upload failed";
			}
	}catch(Exception e){
		System.out.println(e);
	}
		
	}

}
