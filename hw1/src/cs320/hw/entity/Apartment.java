package cs320.hw.entity;

import java.math.BigDecimal;


public class Apartment {

public static int apartmentSize=1;	
	private  int id;
	private  String apartmentId;
	private	ApartmentType apartmentType;
	private	String facility;
	private	int maximumPeople;
	private	BigDecimal rent;
	private	BigDecimal deposit;
	private Boolean vacant;
	private Boolean isRentedOut;
	
	
	
	public Apartment()
	{
		apartmentSize++;
	}	

	public Apartment(String apartmentId, String aptType,
			String facility, int maximumPeople, BigDecimal rent, BigDecimal deposit,
			Boolean vacant) {
		apartmentSize++;
		this.apartmentId = apartmentId;
		if(aptType.equals(ApartmentType.OneBHK.toString()))
				this.apartmentType = ApartmentType.OneBHK;
		else if(aptType.equals(ApartmentType.TwoBHKOneBath.toString()))
			this.apartmentType = ApartmentType.TwoBHKOneBath;
		else 
			this.apartmentType = ApartmentType.TwoBHKTwoBath;
		
		this.facility = facility;
		this.maximumPeople = maximumPeople;
		this.rent = rent;
		this.deposit = deposit;
		this.vacant = vacant;
		isRentedOut=Boolean.FALSE;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getApartmentId() {
		return this.apartmentId;
	}
	public void setApartmentId(String apartmentId) {
		this.apartmentId = apartmentId;
	}
	

	
	public ApartmentType getApartmentType() {
		return this.apartmentType;
	}
	public void setApartmentType(ApartmentType apartmentType) {
		this.apartmentType = apartmentType;
	}
	public String getFacility() {
		return this.facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public int getMaximumPeople() {
		return this.maximumPeople;
	}
	public void setMaximumPeople(int maximumPeople) {
		this.maximumPeople = maximumPeople;
	}
	public BigDecimal getRent() {
		return this.rent;
	}
	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}
	public BigDecimal getDeposit() {
		return this.deposit;
	}
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	
	public Boolean getVacant() {
		return this.vacant;
	}

	public void setVacant(Boolean vacant) {
		this.vacant = vacant;
	}

	public Boolean getIsRentedOut() {
		return isRentedOut;
	}

	public void setIsRentedOut(Boolean isRentedOut) {
		this.isRentedOut = isRentedOut;
	}
	
}

