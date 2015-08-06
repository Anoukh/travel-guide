package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.travelguide.controllers.ViewUsers;
import lk.travelguide.models.User;

/**
 * Servlet implementation class ViewUsersServlet
 */
@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in"); 
		String searchname = request.getParameter("Searchname");
		String table = request.getParameter("table");
		System.out.println(searchname);
		
		User user;
		ViewUsers viewus =new ViewUsers();
		if(searchname.equals("noname")){
		user = viewus.viewusernoname();
		System.out.println("done");
		String [][] userdetails = user.getUsernamelevel();
		
		String change ="change";
		String remove = "remove";
		for(int i=0;i<userdetails[0].length;i++){
			 response.getWriter().write("<tr><td>"+userdetails[0][i]+"</td><td>"+userdetails[1][i]+"</td><td><a  href='ChangeRemoveUserServlet?username="+userdetails[0][i]+"&type="+change+"'>Assign</a></td><td><a  href='ChangeRemoveUserServlet?username="+userdetails[0][i]+"&type="+remove+"' >Remove</a></td></tr>"); 
				}
		
		}
		
		else if(table.equals("no")){
			user = viewus.viewuserforname(searchname);	
			String [] userdetails = user.getUsernames();
			System.out.println("suggested"); 
			for(int i=0;i<userdetails.length;i++){
				 response.getWriter().write("<option value= '" +userdetails[i]+"'>"); 
					}	
			
		}
		
		else{
			user = viewus.viewuserfornamelist(searchname);
		//	System.out.println("done");
			String [][] userdetails = user.getUsernamelevel();
			
			String change ="change";
			String remove = "remove";
			for(int i=0;i<userdetails[0].length;i++){
				 response.getWriter().write("<tr><td>"+userdetails[0][i]+"</td><td>"+userdetails[1][i]+"</td><td><a  href='ChangeRemoveUserServlet?username="+userdetails[0][i]+"&type="+change+"'>Assign</a></td><td><a  href='ChangeRemoveUserServlet?username="+userdetails[0][i]+"&type="+remove+"' >Remove</a></td></tr>"); 
					}
			
		}
		
	}

}
