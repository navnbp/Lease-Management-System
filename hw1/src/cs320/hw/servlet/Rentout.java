package cs320.hw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.*;

@WebServlet("/hw/Rentout")
public class Rentout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Rentout() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			try{
			
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call update_appointment_status_by_id(?,?)}");
			DatabaseConnection.cstmt.setInt(1,Integer.parseInt(request.getParameter("appointmentid")));
			DatabaseConnection.cstmt.setInt(2, DatabaseConnection.getApartmentStatusId(AppointmentStatus.RentedOut.toString()));
			DatabaseConnection.cstmt.executeUpdate();
			}
			catch(Exception e){}
			finally
			{
				DatabaseConnection.closeConnection();
			}
			
			try{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call delete_appointments(?,?)}");
			DatabaseConnection.cstmt.setInt(1,Integer.parseInt(request.getParameter("appointmentid")));
			DatabaseConnection.cstmt.setInt(2, Integer.parseInt(request.getParameter("aptId")));
			DatabaseConnection.cstmt.executeUpdate();
			}
			catch(Exception e){}
			finally
			{
				DatabaseConnection.closeConnection();
			}
//			set_rentout

			try{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call set_rentout(?)}");
			DatabaseConnection.cstmt.setInt(1,Integer.parseInt(request.getParameter("aptId")));
			DatabaseConnection.cstmt.executeUpdate();
			}
			catch(Exception e){}
			finally
			{
				DatabaseConnection.closeConnection();
			}
			
		} catch (Exception e) {
			System.out.println("Rent out :"+e.getMessage());
			

		}finally
		{
			DatabaseConnection.closeConnection();
		}
		

		request.getSession().setAttribute("appointmentid",Integer.parseInt(request.getParameter("appointmentid")) );
		request.getSession().setAttribute("aptId",Integer.parseInt(request.getParameter("aptId")) );
		
		
	
		response.sendRedirect("Feedback");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
