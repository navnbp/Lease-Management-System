package cs320.hw.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Appointment {


	public static int appointmentSize=1;
	private int appointmentId;
	private Date appointmentDate;
	private AppointmentStatus appointmentStatus;
	private Date rescheduledDate;
	private List<Date> ruledOutDate;
	private Apartment apartmentDetails;
	private UserInfo userInfo;
	
	public Appointment() {
		// TODO Auto-generated constructor stub
		appointmentSize++;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try{
		this.appointmentDate = sdf.parse("01/01/1900 10:00:00");
		this.rescheduledDate= sdf.parse("01/01/1900 10:00:00"); 
		this.ruledOutDate=  new ArrayList<Date>();  
		}catch(Exception e){}
	}

	
	public Appointment(int appointmentId, int aptID, AppointmentStatus appointmentStatus) {
		super();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try{
		this.appointmentId = appointmentSize++;
		this.appointmentDate = sdf.parse("01/01/1900 10:00:00");
		this.appointmentStatus = appointmentStatus;
		this.rescheduledDate=sdf.parse("01/01/1900 10:00:00");
		this.ruledOutDate= new ArrayList<Date>(); 
		}catch(Exception e){}
	}

	
	public Appointment(int appointmentId, int aptID, String emailId, Date appointmentDate,
			 AppointmentStatus appointmentStatus, Apartment apartmentDetails,
	 UserInfo userInfo) {
			super();
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			try{
			this.appointmentId = appointmentSize++;
//			this.aptID = aptID;
//			this.emailId = emailId;
			this.appointmentDate = appointmentDate;
			this.appointmentStatus = appointmentStatus;
			this.rescheduledDate=sdf.parse("01/01/1900 10:00:00");
			this.ruledOutDate= new ArrayList<Date>(); 
			this.apartmentDetails=apartmentDetails;
			this.userInfo=userInfo;
			}catch(Exception e ){}
		}
	
	
	public Appointment(int appointmentId, int aptID, String emailId, Date appointmentDate,
			 AppointmentStatus appointmentStatus) {
			super();
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			try{
			this.appointmentId = appointmentSize++;
//			this.aptID = aptID;
//			this.emailId = emailId;
			this.appointmentDate = appointmentDate;
			this.appointmentStatus = appointmentStatus;
			this.rescheduledDate=sdf.parse("01/01/1900 10:00:00");
			this.ruledOutDate= new ArrayList<Date>(); 
			}catch(Exception e ){}
		}
	
	
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/*public int getAptID() {
		return aptID;
	}

	public void setAptID(int aptID) {
		this.aptID = aptID;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
*/
	

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public void setAppointmentDate(String appointmentDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try{
			if(appointmentDate==null){
				
				this.appointmentDate= sdf.parse("01/01/1900 10:00:00");
				}
			else{
				this.appointmentDate= sdf.parse(appointmentDate);
				}
		}catch(Exception e){}
	
	}


	public Date getRescheduledDate() {
		return rescheduledDate;
	}


	public void setRescheduledDate(Date rescheduledDate) {
		this.rescheduledDate = rescheduledDate;
	}
	
	public void setRescheduledDate(String rescheduledDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try{
			if(rescheduledDate==null){
				this.rescheduledDate= sdf.parse("01/01/1900 10:00:00");
				}
			else
				this.rescheduledDate= sdf.parse(rescheduledDate);
		}catch(Exception e){}
	}


	public List<Date> getRuledOutDate() {
		return ruledOutDate;
	}


	public void setRuledOutDate(List<Date> ruledOutDate) {
		this.ruledOutDate = ruledOutDate;
	}

	public void setRuledOutDate(Date ruledOutDate) {
		this.ruledOutDate.add(ruledOutDate);
	}

	public void setRuledOutDate(String ruledOutDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String[] dates=null;
		if(ruledOutDate!=null){
		try {
			
				dates=ruledOutDate.split(";");
				for(String d: dates )
				{
		
					this.ruledOutDate.add(sdf.parse(d));
			
				}
			} catch (ParseException e) {}
		}
	}

	public Apartment getApartmentDetails() {
		return this.apartmentDetails;
	}


	public void setApartmentDetails(Apartment apartmentDetails) {
		this.apartmentDetails = apartmentDetails;
	}


	public UserInfo getUserInfo() {
		return this.userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}




}
