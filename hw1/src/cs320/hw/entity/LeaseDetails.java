package cs320.hw.entity;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LeaseDetails {

	public static int leaseListSize=1;
	private int leaseId;
	private int applicationId;
	private String aptId;
	private String leaseHoldername;
	private Date leaseTerminationDate;
	private String docs;
	private	BigDecimal rent;
	private	BigDecimal deposit;
	private String comments;
	
	
	public LeaseDetails() {
		
		// TODO Auto-generated constructor stub
	}

	public LeaseDetails( int leaseId,int applicationId, String aptId,
			String leaseHoldername, Date leaseTerminationDate, String docs,
			BigDecimal rent, BigDecimal deposit,String comments) {
		super();
		this.leaseId=leaseListSize++;
		this.applicationId = applicationId;
		this.aptId = aptId;
		this.leaseHoldername = leaseHoldername;
		this.leaseTerminationDate = leaseTerminationDate;
		this.docs = docs;
		this.rent = rent;
		this.deposit = deposit;
		this.comments=comments;
	}
	
	public LeaseDetails( int applicationId, String aptId,
			String leaseHoldername, Date leaseTerminationDate, String docs,
			BigDecimal rent, BigDecimal deposit,String comments) {
		super();
		
		this.applicationId = applicationId;
		this.aptId = aptId;
		this.leaseHoldername = leaseHoldername;
		this.leaseTerminationDate = leaseTerminationDate;
		this.docs = docs;
		this.rent = rent;
		this.deposit = deposit;
		this.comments=comments;
	}

	public int getLeaseId() {
		return leaseId;
	}


	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}


	public int getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}


	public String getAptId() {
		return aptId;
	}


	public void setAptId(String aptId) {
		this.aptId = aptId;
	}


	public String getLeaseHoldername() {
		return leaseHoldername;
	}


	public void setLeaseHoldername(String leaseHoldername) {
		this.leaseHoldername = leaseHoldername;
	}



	public String getDocs() {
		return docs;
	}


	public void setDocs(String docs) {
		this.docs = docs;
	}


	public BigDecimal getRent() {
		return rent;
	}


	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}


	public BigDecimal getDeposit() {
		return deposit;
	}


	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getLeaseTerminationDate() {
		return leaseTerminationDate;
	}

	public void setLeaseTerminationDate(Date leaseTerminationDate) {
		this.leaseTerminationDate = leaseTerminationDate;
	}

	public void setLeaseTerminationDate(String leaseTerminationDate) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		this.leaseTerminationDate = sdf.parse(leaseTerminationDate);
		}
		catch(Exception e){}
	}
	

}
