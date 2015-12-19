package cs320.hw.servlet;


import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.*;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hw/AddApartment")
public class AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
      // String error="";
    public AddApartment() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.getRequestDispatcher( "/WEB-INF/hw/AddApartment.jsp" ).forward(request, response );
//		response.sendRedirect("AddApartment.jsp");
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if(request.getSession().getAttribute("role").toString()!=Role.admin.toString()) //Checking whether the user is admin or not 
		{
			request.getSession().invalidate();
			response.sendRedirect("Invalid");
			return;
		}
		

			if(request.getParameter("apartmentId")=="" || request.getParameter("apartmentId")==null )
			{
				request.getSession().setAttribute("errorAddApar", "Apartment ID Cant be empty");
				response.reset();
				doGet(request, response);
				return;
			}
			else
				request.getSession().setAttribute("errorAddApar", "");
					
		
//			insert_apartment_details
//			----------------------
//			int apartmentTypeId=
			
			try {
				DatabaseConnection.conn=DatabaseConnection.getConnection();
				DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call insert_apartment_details(?,?,?,?,?,?)}");
				DatabaseConnection.cstmt.setString(1,request.getParameter("apartmentId"));
				DatabaseConnection.cstmt.setInt(2, DatabaseConnection.getApartmentTypeId(request.getParameter("apartmentType").toString()));
				DatabaseConnection.cstmt.setString(3,request.getParameter("facility").toString());
				DatabaseConnection.cstmt.setInt(4, Integer.parseInt(request.getParameter("maximumPeople").toString()));
				DatabaseConnection.cstmt.setBigDecimal(5, new BigDecimal(request.getParameter("rent").toString()));
				DatabaseConnection.cstmt.setBigDecimal(6,  new BigDecimal(request.getParameter("deposit").toString()));
				DatabaseConnection.cstmt.executeUpdate();

				
			} catch (Exception e) {
				System.out.println("Add Apartment : "+e.getMessage());
				request.getSession().setAttribute("errorAddApar", "Something went wrong.. Try again..!!");
				response.reset();
				doGet(request, response);
				return;

			}finally
			{
				DatabaseConnection.closeConnection();
			}

			
			response.sendRedirect("ManagerHome");
//		}
		
		
	
	}

}
