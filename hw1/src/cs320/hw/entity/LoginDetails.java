package cs320.hw.entity;

public class LoginDetails {

	private int id;
	private String name;
	private String emailId;
	private String password;
	private Boolean isAdmin;
	
	public LoginDetails() {}
	
	public LoginDetails(String name,String emailId, String password, Boolean isAdmin) {
		this.name=name;
		this.emailId = emailId;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public LoginDetails(int id,String name,String emailId, String password, Boolean isAdmin) {
		this.id=id;
		this.name=name;
		this.emailId = emailId;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
	this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


}
