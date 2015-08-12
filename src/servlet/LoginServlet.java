package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lk.travelguide.controllers.Login;
import lk.travelguide.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		try
		{	    

		     
		     String username = (request.getParameter("LoginUserName"));
		     String password = (request.getParameter("LoginPassword"));

		     User user ;
		     System.out.println(username);
		     System.out.println(password);
		     
		     Login login = new Login();
		     user =login.authentication(username,password);
		     System.out.println(user);
		     
		     
		     String userlevel = user.getUser_Level();
		     
		    
		     
		     if(user == null)
		     {
		    	 String message = null;
			     

			     
		          message = "You are not a valid user...";
		        
		     
		     
		     request.setAttribute("loginerrormessage", message);
		     request.getRequestDispatcher("/login.jsp").forward(request, response);
		     }
		     
		     else if(user != null){
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










