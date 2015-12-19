package cs320.hw.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.RentDetails;

@WebServlet("/hw/PayRent")
public class PayRent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayRent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		List<RentDetails> rentDetails= new ArrayList<RentDetails>();
		try
		{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_lease_details()}");
			DatabaseConnection.cstmt.execute();
			DatabaseConnection.rs=DatabaseConnection.cstmt.getResultSet();
		
			while (DatabaseConnection.rs.next()) 
			{
		
				RentDetails rd= new RentDetails();
				rd.setAppointmentId(DatabaseConnection.rs.getInt("appointment_id"));
				rd.setAptId(DatabaseConnection.rs.getString("apartment_id"));
				rd.setUserName(DatabaseConnection.rs.getString("lease_holder_name"));
				rd.setRent(DatabaseConnection.rs.getBigDecimal("rent"));
				rentDetails.add(rd);
				
		
				
			}
		}catch(Exception e)
		{
			System.out.println("Pay Rent :"+e.getMessage());
			request.getSession().setAttribute("errorPayRent", "Some thing went Wrong...!! Try again.. ");	
		}finally
		{
			DatabaseConnection.closeConnection();
		}
		
		
		request.setAttribute("rentDetails",rentDetails);
		request.getRequestDispatcher("/WEB-INF/hw/RentDetails.jsp" ).forward(request, response );

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("errorPayRent", "");
		try {
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call insert_rent_paid_details(?,?,?,?,?,?,?)}");
			DatabaseConnection.cstmt.setInt(1, Integer.parseInt(request.getParameter("appointmentId")));
			DatabaseConnection.cstmt.setString(2, request.getParameter("aptId"));
			DatabaseConnection.cstmt.setString(3,request.getParameter("userName").toString());
			DatabaseConnection.cstmt.setBigDecimal(4, new BigDecimal(request.getParameter("rent").toString()));
			DatabaseConnection.cstmt.setBigDecimal(5,  new BigDecimal(request.getParameter("rentPaid").toString()));
			DatabaseConnection.cstmt.setString(6,request.getParameter("month").toString());
			DatabaseConnection.cstmt.setInt(7, Integer.parseInt(request.getParameter("year").toString()));
			DatabaseConnection.cstmt.executeUpdate();

			//request.getSession().setAttribute("errorPayRent", "Rent of Apartment "+request.getParameter("aptId")+" recieved for the month of "+request.getParameter("month")+".");
		} catch (Exception e) {
			System.out.println("Insert Rent Paid : "+e.getMessage());
			request.getSession().setAttribute("errorPayRent", "Something went wrong.. Try again..!!");
			response.reset();
			doGet(request, response);
			return;

		}finally
		{
			DatabaseConnection.closeConnection();
		}

		
		response.sendRedirect("RentHistory");

		
	}

}
