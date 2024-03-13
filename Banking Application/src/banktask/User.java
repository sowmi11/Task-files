package banktask;


public class User {
	private long userId;
	private String name;
	private String password;
	private String dateOfBirth;
	private long mobileNumber;
	private String emailId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public User(long userId,  String password,String name, String dateOfBirth, long mobileNumber, String emailId) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;

	}
	
}
