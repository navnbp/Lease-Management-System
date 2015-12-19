package cs320.hw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.*;


@WebServlet("/hw/RequestMapping")
public class RequestMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestMapping() {
        super();
       
    }

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getSession().setAttribute("errorLookApartment", "");
	int aptid=Integer.parseInt(request.getParameter("aptid"));
	String aptno=request.getParameter("aptno");
	LoginDetails loggedInUserInfo= (LoginDetails)request.getSession().getAttribute("LoggedInUserInfo");
	
	
	if(loggedInUserInfo==null && request.getSession().getAttribute("role").toString()!=Role.user.toString()) //Checking whether the user is admin or not 
	{
		request.getSession().invalidate();
		response.sendRedirect("Invalid");
		return;
	}
	
	
	
	
	//LoginDetails LoggedInUserInfo= new LoginDetails();
	
//	----------------------------------------
	
	try {
		DatabaseConnection.conn=DatabaseConnection.getConnection();
		DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call insert_appointment_details(?,?,?)}");
		
		DatabaseConnection.cstmt.setInt(1,DatabaseConnection.getApartmentStatusId(AppointmentStatus.Requested.toString()));
		DatabaseConnection.cstmt.setInt(2, aptid);
		DatabaseConnection.cstmt.setInt(3,DatabaseConnection.getUserInformationId( loggedInUserInfo.getEmailId()));
		
		DatabaseConnection.cstmt.executeUpdate();

		
	} catch (Exception e) {
		System.out.println("Request Mapping : "+e.getMessage());
		request.getSession().setAttribute("errorLookApartment", "Something went wrong.. Try again..!!");
	
	}finally
	{
		DatabaseConnection.closeConnection();
	}

	response.sendRedirect("LookUpApartment");
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
