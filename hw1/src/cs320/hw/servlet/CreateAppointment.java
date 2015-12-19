package cs320.hw.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.AppointmentStatus;


@WebServlet("/hw/createAppointment")
public class CreateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateAppointment() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("errorDate", "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.getSession().setAttribute("errorDate", " ");
//		ArrayList<Appointment> appointments=(ArrayList<Appointment>) request.getServletContext().getAttribute("appointments");
		int appointmentId= Integer.parseInt(request.getParameter("appointmentId").trim());
		int aptId=Integer.parseInt(request.getParameter("aptId").trim());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy HH:mm:ss"); 
		
		Boolean error=Boolean.FALSE;
		AppointmentStatus status=null;
		int statusId=0;
		try{
		 sdf.parse(request.getParameter("appointmentDate"));
		 request.getSession().setAttribute("errorDate", " ");
		 }
		 catch(Exception e)
		{
			 error=Boolean.TRUE;	 
			 request.getSession().setAttribute("errorDate", "Enter the date in mm:dd:yyyy hh:mm:ss format"); 
		}
	
		
		
		 if(request.getParameter("reappointmentSchedule")!=null && error!=Boolean.TRUE)
		{
			 try{
				 DatabaseConnection.conn=DatabaseConnection.getConnection();
			 status=DatabaseConnection.getApartmentstatusByAppointmentID(appointmentId);
		
			 if(status.equals(AppointmentStatus.Denied))
			 {
				 status=AppointmentStatus.RescheduledRequested;
				 statusId=DatabaseConnection.getApartmentStatusId(AppointmentStatus.RescheduledRequested.toString()); ;
			 }
				else if(status.equals(AppointmentStatus.Requested))
			{
					status=AppointmentStatus.Scheduled;
					 statusId=DatabaseConnection.getApartmentStatusId(AppointmentStatus.Scheduled.toString()); ;
			}
			else if(status.equals(AppointmentStatus.Rescheduled))
			{
					
					status=AppointmentStatus.RescheduledRequested;
					 statusId=DatabaseConnection.getApartmentStatusId(AppointmentStatus.RescheduledRequested.toString()); 
			}
			}catch(Exception e){}
			 finally
			 {
				 if( DatabaseConnection.conn!=null)
					try {
						DatabaseConnection.conn.close();
					} catch (SQLException e) {
						
					}
				 
			 }
			 
			 
//			 update_appointment_status
			 
			 if(!error){
			 
				try {
					DatabaseConnection.conn=DatabaseConnection.getConnection();
					DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call update_appointment_status(?,?,?)}");
					DatabaseConnection.cstmt.setString(1,request.getParameter("appointmentDate"));
					DatabaseConnection.cstmt.setInt(2, statusId);
					DatabaseConnection.cstmt.setInt(3,appointmentId);
					DatabaseConnection.cstmt.executeUpdate();

					
				} catch (Exception e) {
					System.out.println("Create Appointment : " +e.getMessage());
//					request.getSession().setAttribute("errorAddApar", "Something went wrong.. Try again..!!");
				}finally
				{
					DatabaseConnection.closeConnection();
				}

			 
			 }
			 
			 
			 
			 
		}
//		request.getServletContext().setAttribute("appointments", appointments);
		
//		 request.getRequestDispatcher( "/WEB-INF/hw/ViewAppointment?aptid="+aptId ).forward(request, response );
		response.sendRedirect("ViewAppointment?aptid="+aptId);
		
	}

}

