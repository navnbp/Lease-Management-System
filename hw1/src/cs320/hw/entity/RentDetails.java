package cs320.hw.entity;

import java.math.BigDecimal;

public class RentDetails {

	private int rentId;
	private int appointmentId;
	private String aptId;
	private String userName;
	private BigDecimal rent;
	private BigDecimal rentPaid;
	private String month;
	private int year;
	
	
	
	public RentDetails() {
		
	}


public RentDetails(int rentId, int appointmentId, String aptId,String userName, BigDecimal rent, BigDecimal rentPaid,String month, int year) {
		super();
		this.rentId = rentId;
		this.appointmentId = appointmentId;
		this.aptId = aptId;
		this.userName = userName;
		this.rent = rent;
		this.rentPaid = rentPaid;
		this.month = month;
		this.year = year;
	}

	public int getRentId() {
		return rentId;
	}



	public void setRentId(int rentId) {
		this.rentId = rentId;
	}



	public int getAppointmentId() {
		return appointmentId;
	}



	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}



	public String getAptId() {
		return aptId;
	}



	public void setAptId(String aptId) {
		this.aptId = aptId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public BigDecimal getRent() {
		return rent;
	}



	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}



	public BigDecimal getRentPaid() {
		return rentPaid;
	}



	public void setRentPaid(BigDecimal rentPaid) {
		this.rentPaid = rentPaid;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}

}
