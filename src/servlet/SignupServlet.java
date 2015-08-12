
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lk.travelguide.controllers.Login;
import lk.travelguide.controllers.Signup;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		try
		{	    

		     
		     String username = (request.getParameter("SignupUserName"));
		     String password = (request.getParameter("SignupPassword"));
		     String confpassword = (request.getParameter("SignupConfPassword"));
		     String email	 = (request.getParameter("SignupEmail"));
		     String userlevel	 = "User";
		     
		     System.out.println("hello");
		     
		     Signup obj = new Signup();
		     String signupmsg = obj.signup(username,password,email);
		     
		     System.out.println(signupmsg);
		     String message = null;
		     if(signupmsg=="exists")
		     {
		    	 			     
		    	 message = username+" already exists";
		     }
		     else if(signupmsg=="dberror"){
		    	
			     message = "Error occured while connecting to the database";
			     
			     request.setAttribute("signuperrormessage", message);
			     request.getRequestDispatcher("/login.jsp").forward(request, response);
		     }
		     else {
		    	 //message = signupmsg;
		    	 
		     HttpSession levelsession = request.getSession();
		     levelsession.setAttribute("sessionuserlevel",userlevel);
		     System.out.println(levelsession.getAttribute("sessionuserlevel") +"    level");
	    	 response.sendRedirect("home.jsp");
		     }		 
		     
		     
		   
		     System.out.println("world");
		     
		     //HttpSession session = request.getSession(true);	    
		    // session.setAttribute("currentSessionUser",user); 
		     //response.sendRedirect("index.jsp"); //logged-in page      		
		     
				
				
		}catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

}
