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
import cs320.hw.entity.Apartment;
import cs320.hw.entity.Appointment;

@WebServlet("/hw/ViewAppointment")
public class ViewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aptId=Integer.parseInt(request.getParameter("aptid"));
		
		
		List<Apartment> apartmentLst= new ArrayList<Apartment>();
		List<Appointment> appointmentLst= new ArrayList<Appointment>();
		try {
			try{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_apartment_details()}");
			DatabaseConnection.cstmt.execute();
			DatabaseConnection.rs=DatabaseConnection.cstmt.getResultSet();
			while (DatabaseConnection.rs.next()) {
				Apartment apt= new Apartment();
				apt.setId(DatabaseConnection.rs.getInt("id"));
				apt.setApartmentId(DatabaseConnection.rs.getString("apartment_id"));
				apt.setApartmentType(DatabaseConnection.getApartmentType(DatabaseConnection.rs.getInt("apartment_type_id")));
				apt.setFacility(DatabaseConnection.rs.getString("facility"));
				apt.setMaximumPeople(DatabaseConnection.rs.getInt("max_ppl"));
				apt.setRent(DatabaseConnection.rs.getBigDecimal("rent"));
				apt.setDeposit(DatabaseConnection.rs.getBigDecimal("deposit"));
				apt.setVacant(DatabaseConnection.rs.getBoolean("vacant"));
				apt.setIsRentedOut(DatabaseConnection.rs.getBoolean("is_rented_out"));
				apartmentLst.add(apt);
				
			}
			}
			catch(Exception e){}
			finally
			{
				DatabaseConnection.closeConnection();
			}
			
			try{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_appointment_details()}");
			DatabaseConnection.cstmt.execute();
			DatabaseConnection.rs=DatabaseConnection.cstmt.getResultSet();
			
			while(DatabaseConnection.rs.next())
			{
				Appointment app=new Appointment();
				app.setAppointmentId(DatabaseConnection.rs.getInt("appointment_id"));
				app.setAppointmentStatus(DatabaseConnection.getApartmentstatus(DatabaseConnection.rs.getInt("appointment_status")));
				app.setAppointmentDate(DatabaseConnection.rs.getString("appointment_date"));
				app.setRescheduledDate(DatabaseConnection.rs.getString("rescheduled_date"));
				app.setRuledOutDate(DatabaseConnection.rs.getString("ruled_out_dates"));
				app.setApartmentDetails(DatabaseConnection.getApartmentDetailsById(DatabaseConnection.rs.getInt("apartment_id")));
				app.setUserInfo(DatabaseConnection.getUserDetailsById(DatabaseConnection.rs.getInt("user_id")));
				appointmentLst.add(app);
				
			}
			}
			catch(Exception e){	System.out.println("View Appointment : "+e.getMessage());}
			finally
			{
				DatabaseConnection.closeConnection();
			}
			
		} catch (Exception e) 
		{
			System.out.println("View Appointment : "+e.getMessage());
		}
		finally
		{
			DatabaseConnection.closeConnection();
		}

		request.setAttribute("aptid", aptId);
		request.setAttribute("apartmentLst", apartmentLst);
		request.setAttribute("appointmentLst", appointmentLst);
		
		
		request.getRequestDispatcher("/WEB-INF/hw/ViewAppointment.jsp" ).forward(request, response );
//		response.sendRedirect("ViewAppointment.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
