package cs320.hw.dal;

import java.sql.*;

import cs320.hw.entity.Apartment;
import cs320.hw.entity.ApartmentType;
import cs320.hw.entity.AppointmentStatus;
import cs320.hw.entity.Occupation;
import cs320.hw.entity.UserInfo;

public class DatabaseConnection {

	public static Connection conn=null;
	public static Statement statement=null;
	public static ResultSet rs=null;
	public static Statement stmt=null;
	public static PreparedStatement pstmt=null;
	public static CallableStatement cstmt = null;
	
	
	 
	
	
	 static {
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	    		
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	
	 
	 public static Connection getConnection() 
	    {
	       
	        try {
	        	String url="jdbc:mysql://localhost/cs320stu102";
	    		String username="cs320stu102";
	    		String password="n2rCjhPk";
	    		
	    		conn=DriverManager.getConnection(url, username, password);
	        }
	        catch (Exception e) {
	           System.out.println("get Connection : "+e.getMessage());
	        }
	        return conn;
	    }
	 
	 public static void closeConnection() {
		try
		{
			if(statement!=null)
			statement.close();
			if(stmt!=null)
			stmt.close();
			if(cstmt!=null)
			cstmt.close();
			if(conn!=null)
			conn.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Close Connection "+e.getMessage());
		}
	}
	
	 public static int getApartmentTypeId(String type)
	 {
//		 get_apartment_id
		 int id=0;
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_apartment_type_id(?)}");
				callstmt.setString(1,type);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					id=res.getInt("apartment_id");
				}
				
			} catch (Exception e) {
				System.out.println("DatabaseConnection getApartmentTypeId : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
		 return id;
		 
	 }
	 
	 public static ApartmentType getApartmentType(int id)
	 {
		 String name="";
		 Connection c=null;
		 CallableStatement callstmt=null;
		try {
//			 c=DatabaseConnection.getConnection();	
			 callstmt=DatabaseConnection.conn.prepareCall("{call get_apartment_type(?)}");
				callstmt.setInt(1,id);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					name=res.getString("apartment_type");
				}
			}
			catch (Exception e) 
			{
				System.out.println("Database Connection getApartmentType : "+e.getMessage());		
				
			}finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 

		return (name.equals(ApartmentType.OneBHK.toString())?ApartmentType.OneBHK:name.equals(ApartmentType.TwoBHKOneBath.toString())?ApartmentType.TwoBHKOneBath:ApartmentType.TwoBHKTwoBath);

			
			
	
	 }
	 
	 public static Occupation getOccupation(int id)
	 {
		 String name="";
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_occupation(?)}");
				callstmt.setInt(1,id);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					name=res.getString("occupation_name");
				}
			} catch (Exception e) {
				System.out.println("Database Connection getOccupation : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
			return (name.equals(Occupation.Businees.toString())?Occupation.Businees:name.equals(Occupation.Family.toString())?Occupation.Family:Occupation.Student);
			
			
	 }
	 
	 public static int getOccupationId(String type)
	 {
//		 get_occupation_id
		 int id=0;
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_occupation_id(?)}");
				callstmt.setString(1,type);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					id=res.getInt("occupation_id");
				}
				
				
			} catch (Exception e) {
				System.out.println("Database Connection getOccupationId : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
		 return id;
	
	 }
	
//	------------------
	 
	 public static int getApartmentStatusId(String type)
	 {
//		 get_appointment_status_id
		 int id=0;
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_appointment_status_id(?)}");
				callstmt.setString(1,type);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					id=res.getInt("id");
				}
				
				
			} catch (Exception e) {
				System.out.println("Database Connection getApartmentStatusId : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
		 return id;
		 
	 }
	 
	 public static AppointmentStatus getApartmentstatus(int id)
	 {
		 String name="";
		 AppointmentStatus status=null;
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_appointment_status(?)}");
				callstmt.setInt(1,id);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					name=res.getString("status");
				}
			} catch (Exception e) {
				System.out.println("DatabaseConnection getApartmentstatus : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 	
			if(name.equals(AppointmentStatus.Accepted.toString()))
				status=AppointmentStatus.Accepted;
			else if(name.equals(AppointmentStatus.Denied.toString()))
				status=AppointmentStatus.Denied;
			else if(name.equals(AppointmentStatus.RentedOut.toString()))
					status=AppointmentStatus.RentedOut;
			else if(name.equals(AppointmentStatus.Requested.toString()))
						status=AppointmentStatus.Requested;
			else if(name.equals(AppointmentStatus.Rescheduled.toString()))
					status=AppointmentStatus.Rescheduled;
			else if(name.equals(AppointmentStatus.RescheduledRequested.toString()))
					status=AppointmentStatus.RescheduledRequested;
			else if(name.equals(AppointmentStatus.Scheduled.toString()))
					status=AppointmentStatus.Scheduled;
				
			return	status;
	 }

	 public static AppointmentStatus getApartmentstatusByAppointmentID(int id)
	 {
		 String name="";
		 AppointmentStatus status=null;
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_apartment_status_by_appointment_id(?)}");
				callstmt.setInt(1,id);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					name=res.getString("status");
				
				}
			} catch (Exception e) {
				System.out.println("DatabaseConnection getApartmentstatusByAppointmentID : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 	
			if(name.equals(AppointmentStatus.Accepted.toString()))
				status=AppointmentStatus.Accepted;
			else if(name.equals(AppointmentStatus.Denied.toString()))
				status=AppointmentStatus.Denied;
			else if(name.equals(AppointmentStatus.RentedOut.toString()))
					status=AppointmentStatus.RentedOut;
			else if(name.equals(AppointmentStatus.Requested.toString()))
						status=AppointmentStatus.Requested;
			else if(name.equals(AppointmentStatus.Rescheduled.toString()))
					status=AppointmentStatus.Rescheduled;
			else if(name.equals(AppointmentStatus.RescheduledRequested.toString()))
					status=AppointmentStatus.RescheduledRequested;
			else if(name.equals(AppointmentStatus.Scheduled.toString()))
					status=AppointmentStatus.Scheduled;
				
			return	status;
	 }

	 
	 public static Apartment getApartmentDetailsById(int  id)
	 {
		Apartment apt=new Apartment();
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_apartment_details_by_id(?)}");
				callstmt.setInt(1,id);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					apt.setId(res.getInt("id"));
					apt.setApartmentId(res.getString("apartment_id"));
					apt.setApartmentType(DatabaseConnection.getApartmentType(res.getInt("apartment_type_id")));
					apt.setFacility(res.getString("facility"));
					apt.setMaximumPeople(res.getInt("max_ppl"));
					apt.setRent(res.getBigDecimal("rent"));
					apt.setDeposit(res.getBigDecimal("deposit"));
					apt.setVacant(res.getBoolean("vacant"));
					apt.setIsRentedOut(res.getBoolean("is_rented_out"));
					
				}
				
				
			} catch (Exception e) {
				System.out.println("DatabaseConnection getApartmentDetailsById : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
		 return apt;
		 
	 }
	 
	 
	 public static int getUserInformationId(String emailId)
	 {
		 int id=0;
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
//				 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_userinformation_id(?)}");
				callstmt.setString(1,emailId);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					id=res.getInt("user_id");
				}
				
				
			} catch (Exception e) {
				System.out.println("Database Connection getUserInformationId : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
		 return id;
		 
	 }

	 public static UserInfo getUserDetailsById(int id)
	 {
		UserInfo user= new UserInfo();
		 Connection c=null;
		 CallableStatement callstmt=null;
			try {
			//	 c=DatabaseConnection.getConnection();
				 callstmt=DatabaseConnection.conn.prepareCall("{call get_user_details_by_id(?)}");
				callstmt.setInt(1,id);
				ResultSet res=callstmt.executeQuery();
				if(res.next())
				{
					user.setUserId(res.getInt("user_id"));
					user.setUsername(res.getString("username"));
					user.setEmailId(res.getString("email_id"));
					user.setMobile(res.getString("mobile"));
					user.setPeople(res.getInt("people"));
					user.setOccupation(DatabaseConnection.getOccupation(res.getInt("occupation")));
					user.setAptType(DatabaseConnection.getApartmentType(res.getInt("apartment_type")));
					user.setPreference(res.getString("preference"));
					user.setNeedFrom(res.getString("needFrom"));
					
					
				}
				
				
			} catch (Exception e) {
				System.out.println("Database Connection getUserDetailsById : "+e.getMessage());
				
			}
			finally
			{
				try {
					if(callstmt!=null)
						callstmt.close();
					
					if(c!=null)
						c.close();
					}
				catch (SQLException e) {}
			}
		 
		 return user;
		 
	 }

}
