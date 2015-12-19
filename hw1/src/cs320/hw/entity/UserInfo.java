package cs320.hw.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UserInfo {

	private int userId;
	private String username;
	private String emailId;
	private String mobile;
	private int people;
	private Occupation occupation;
	private ApartmentType aptType; 
	private String preference;
	private Date needFrom;
	

	public UserInfo() {}

	public UserInfo(String username, String emailId, String mobile, int people,
			Occupation occupation,ApartmentType aptType, String preference, Date needFrom) {
		
		this.username = username;
		this.emailId = emailId;
		this.mobile = mobile;
		this.people = people;
		this.occupation = occupation;
		this.aptType=aptType;
		this.preference = preference;
		this.needFrom = needFrom;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

		public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public ApartmentType getAptType() {
		return this.aptType;
	}

	public void setAptType(String aptType) {
		
		
		this.aptType = aptType.equals(ApartmentType.OneBHK.toString())?ApartmentType.OneBHK:aptType.equals(ApartmentType.TwoBHKOneBath)?ApartmentType.TwoBHKOneBath:ApartmentType.TwoBHKTwoBath;
	}
	
	public String getPreference() {
		return this.preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}


	public void setAptType(ApartmentType aptType) {
		this.aptType = aptType;
	}

	public Date getNeedFrom() {
		return needFrom;
	}

	public void setNeedFrom(Date needFrom) {
		this.needFrom = needFrom;
	}
	
	public void setNeedFrom(String needFrom) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		try {
			this.needFrom = sdf.parse(needFrom);
		} catch (ParseException e) {}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	
	
}
