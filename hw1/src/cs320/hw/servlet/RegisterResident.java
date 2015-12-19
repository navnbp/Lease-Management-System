package cs320.hw.servlet;


import cs320.hw.dal.DatabaseConnection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;

@WebServlet("/hw/RegisterResident")
public class RegisterResident extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//public String error="";
    public RegisterResident() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("errorLogin", "");
		request.getRequestDispatcher( "/WEB-INF/hw/RegisterResident.jsp" ).forward(request, response );
//		response.sendRedirect("RegisterResident.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	request.getSession().setAttribute("errorLogin", "");
	request.getSession().setAttribute("errorReg", "");
	
	if(request.getParameter("password").toString().length()== 0 || request.getParameter("confirmPassword").toString().length()== 0)
	{
		request.getSession().setAttribute("errorReg", "Password Field can't be empty");
		
		response.reset();
		doGet(request, response);
		return;
	}
	else if(!request.getParameter("password").equals(request.getParameter("confirmPassword")))
	{
		request.getSession().setAttribute("errorReg", "Password  and Confirm Password doesnot match");
		response.reset();
		doGet(request, response);
		return;
	}
			
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
	
	
	try {
	 formatter.parse(request.getParameter("date").toString());
	} catch (Exception e) 
	{
		request.getSession().setAttribute("errorReg", "Enter the date in mm/dd/yyyy hh:mm:ss format");
		response.reset();
		doGet(request, response);
		return;
	}
	

	try {
		try{
		DatabaseConnection.conn=DatabaseConnection.getConnection();
		DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call insert_user_info(?,?,?,?,?,?,?,?)}");
		DatabaseConnection.cstmt.setString(1, request.getParameter("username"));
		DatabaseConnection.cstmt.setString(2, request.getParameter("emailid"));
		DatabaseConnection.cstmt.setString(3, request.getParameter("contact"));
		DatabaseConnection.cstmt.setInt(4, Integer.parseInt(request.getParameter("people")));
		DatabaseConnection.cstmt.setInt(5, DatabaseConnection.getOccupationId(request.getParameter("occupation")));
		DatabaseConnection.cstmt.setInt(6, DatabaseConnection.getApartmentTypeId(request.getParameter("apartmentType")));
		DatabaseConnection.cstmt.setString(7, request.getParameter("preference"));
		DatabaseConnection.cstmt.setString(8,request.getParameter("date"));
		DatabaseConnection.cstmt.executeUpdate();

		}
		catch(Exception e){
			System.out.println("Register Resident : "+e.getMessage());
			request.getSession().setAttribute("errorReg", "Something went wrong.. Try again..!!");
			response.reset();
			doGet(request, response);
			return;
		}
		finally
		{
			DatabaseConnection.closeConnection();
		}
		
		try{
		
		DatabaseConnection.conn=DatabaseConnection.getConnection();
		DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call insert_login_details(?,?,?)}");
		DatabaseConnection.cstmt.setString(1, request.getParameter("username"));
		DatabaseConnection.cstmt.setString(2, request.getParameter("emailid"));
		DatabaseConnection.cstmt.setString(3, request.getParameter("password"));
		DatabaseConnection.cstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Register Resident : "+e.getMessage());
			request.getSession().setAttribute("errorReg", "Something went wrong.. Try again..!!");
			response.reset();
			doGet(request, response);
			return;
		}
		finally
		{
			DatabaseConnection.closeConnection();
		}
		
	} catch (Exception e) {
		System.out.println("Register Resident : "+e.getMessage());
		request.getSession().setAttribute("errorReg", "Something went wrong.. Try again..!!");
		response.reset();
		doGet(request, response);
		return;

	}finally
	{
		try{
		if(DatabaseConnection.cstmt!=null)
			DatabaseConnection.cstmt.close();
		if(DatabaseConnection.conn!=null)
			DatabaseConnection.conn.close();
		}catch(Exception e){}
	}
	
	response.sendRedirect("Login");
	
	
		
		
	}

}
