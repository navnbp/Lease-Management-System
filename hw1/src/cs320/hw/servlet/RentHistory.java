package cs320.hw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.RentDetails;

@WebServlet("/hw/RentHistory")
public class RentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RentHistory() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		List<RentDetails> rentDetails= new ArrayList<RentDetails>();
		try
		{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.stmt=DatabaseConnection.conn.createStatement();
			DatabaseConnection.stmt.executeQuery("select * from rent_paid_details order by apartment_id");
			DatabaseConnection.rs=DatabaseConnection.stmt.getResultSet();
			while (DatabaseConnection.rs.next()) 
			{
				RentDetails rd= new RentDetails();
				rd.setRentId(DatabaseConnection.rs.getInt("rent_ID"));
				rd.setAppointmentId(DatabaseConnection.rs.getInt("appointment_Id"));
				rd.setAptId(DatabaseConnection.rs.getString("apartment_Id"));
				rd.setUserName(DatabaseConnection.rs.getString("user_name"));
				rd.setRent(DatabaseConnection.rs.getBigDecimal("rent"));
				rd.setRentPaid(DatabaseConnection.rs.getBigDecimal("rent_paid"));
				rd.setMonth(DatabaseConnection.rs.getString("month"));
				rd.setYear(DatabaseConnection.rs.getInt("year"));
				
				rentDetails.add(rd);
				
				
					
				
			}
			request.getSession().setAttribute("errorRentHistory", "");
		}catch(Exception e)
		{
			System.out.println(" Rent History : "+e.getMessage());
			request.getSession().setAttribute("errorRentHistory", "Some thing went Wrong...!! Try again.. ");	
		}finally
		{
			DatabaseConnection.closeConnection();
		}
		
		
		request.setAttribute("rentDetails",rentDetails);
		request.getRequestDispatcher("/WEB-INF/hw/RentHistory.jsp" ).forward(request, response );

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
