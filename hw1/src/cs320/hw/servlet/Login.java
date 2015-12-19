package cs320.hw.servlet;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.*;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns="/hw/Login",loadOnStartup=1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       public String error="";
    public Login() {
        super();
    
    }

	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("errorReg", "");
		 request.getRequestDispatcher( "/WEB-INF/hw/Login.jsp" ).forward(request, response );
//		response.sendRedirect("Login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean flag=Boolean.FALSE;	
		request.getSession().setAttribute("errorLogin", "");
		request.getSession().setAttribute("errorReg", "");
		String page="LookUpApartment";
		
		try {
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_Login_Details(?,?)}");
			DatabaseConnection.cstmt.setString(1, request.getParameter("emailid").toString());
			DatabaseConnection.cstmt.setString(2, request.getParameter("password").toString());
			DatabaseConnection.rs=DatabaseConnection.cstmt.executeQuery();
			if(DatabaseConnection.rs.next())
			{
				
				if(request.getParameter("emailid").equals(DatabaseConnection.rs.getString("email_id")) &&
						request.getParameter("password").equals(DatabaseConnection.rs.getString("password")))
				{
					flag=Boolean.TRUE;
					request.getSession().setAttribute("username", DatabaseConnection.rs.getString("name"));
					request.getSession().setAttribute("LoggedInUserInfo",new LoginDetails(DatabaseConnection.rs.getInt("login_id"),DatabaseConnection.rs.getString("name"), DatabaseConnection.rs.getString("email_id"), "", DatabaseConnection.rs.getBoolean("is_admin")));
					if(DatabaseConnection.rs.getBoolean("is_admin"))
					{
						request.getSession().setAttribute("role",Role.admin.toString());
						page="ManagerHome";
					}
					else
						request.getSession().setAttribute("role",Role.user.toString());
					
					
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Login : "+e.getMessage());
			request.getSession().setAttribute("errorLogin","Something went wrong..!! Try again..");
			page="Login";
			System.out.println("Login page : "+e.getMessage());
		}finally
		{
			DatabaseConnection.closeConnection();
		}
		
		if(!flag)
		{
			
			request.getSession().setAttribute("errorLogin","Enter correct email id and password");
		page="Login";

		}
		
		response.sendRedirect(page);
		
	
	}

}
