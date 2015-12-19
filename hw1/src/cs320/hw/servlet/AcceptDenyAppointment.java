package cs320.hw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.AppointmentStatus;

@WebServlet("/hw/AcceptDenyAppointment")
public class AcceptDenyAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AcceptDenyAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		int appointmentid=Integer.parseInt(request.getParameter("appointmentid"));
		AppointmentStatus status;
		if(request.getParameter("accept")!=null) 
			status=AppointmentStatus.Accepted;	
		else
			status=AppointmentStatus.Denied;
		
		String ruledOutDate=null,appointmentDate=null;
		
		try {
		
			if(status==AppointmentStatus.Accepted)
			{
//			accept_appointment
			
				try {
				DatabaseConnection.conn=DatabaseConnection.getConnection();
				DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call accept_appointment(?,?)}");
				DatabaseConnection.cstmt.setInt(1, DatabaseConnection.getApartmentStatusId(status.toString()));
				DatabaseConnection.cstmt.setInt(2, appointmentid);
				DatabaseConnection.cstmt.executeUpdate();
				}
				catch(Exception e){System.out.println("Accept/Deny Appointment "+e.getMessage());}
				finally
				{
					try{
						if(DatabaseConnection.cstmt!=null)
							DatabaseConnection.cstmt.close();
						if(DatabaseConnection.conn!=null)
							DatabaseConnection.conn.close();
						}catch(Exception e){}
				}
			}
			else
			{
				try{
				DatabaseConnection.conn=DatabaseConnection.getConnection();
				DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_ruled_out_date(?)}");
				DatabaseConnection.cstmt.setInt(1, appointmentid);
				DatabaseConnection.cstmt.execute();
				DatabaseConnection.rs=DatabaseConnection.cstmt.getResultSet();
				
				if(DatabaseConnection.rs.next())
				{
					ruledOutDate=DatabaseConnection.rs.getString("ruled_out_dates");
					appointmentDate=DatabaseConnection.rs.getString("appointment_date");	
				}
	
				if(ruledOutDate==null)
					ruledOutDate=appointmentDate;
				else
					ruledOutDate+=';'+appointmentDate;
				}catch(Exception e){System.out.println("Accept/Deny Appointment "+e.getMessage());}
				finally
				{
					try{
						if(DatabaseConnection.cstmt!=null)
							DatabaseConnection.cstmt.close();
						if(DatabaseConnection.conn!=null)
							DatabaseConnection.conn.close();
						}catch(Exception e){}
				}
//				System.out.println(ruledOutDate);
				try{
				DatabaseConnection.conn=DatabaseConnection.getConnection();
				DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call deny_appointment(?,?,?)}");
				DatabaseConnection.cstmt.setInt(1, DatabaseConnection.getApartmentStatusId(status.toString()));
				DatabaseConnection.cstmt.setInt(2, appointmentid);
				DatabaseConnection.cstmt.setString(3,ruledOutDate);
				DatabaseConnection.cstmt.executeUpdate();
				}catch(Exception e){System.out.println("Accept/Deny Appointment "+e.getMessage());}
				finally
				{
					try{
						if(DatabaseConnection.cstmt!=null)
							DatabaseConnection.cstmt.close();
						if(DatabaseConnection.conn!=null)
							DatabaseConnection.conn.close();
						}catch(Exception e){}
				}
				
			}
		
		
		
		} catch (Exception e) 
		{
			System.out.println("Accept/Deny Appointment "+e.getMessage());
		}
		finally
		{
			try{
				if(DatabaseConnection.cstmt!=null)
					DatabaseConnection.cstmt.close();
				if(DatabaseConnection.conn!=null)
					DatabaseConnection.conn.close();
				}catch(Exception e){}
		}
		response.sendRedirect("LookUpApartment");
	}
	

}
