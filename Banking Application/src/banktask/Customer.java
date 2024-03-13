package banktask;

public class Customer extends User {


	public Customer(long userId, String name, String password, String dateOfBirth, long mobileNumber, String emailId,
			String status, String role, String aadharNo, String panNo) {
		super(userId, name, password, dateOfBirth, mobileNumber, emailId);
		this.aadharNo = aadharNo;
		this.panNo = panNo;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	private String aadharNo;
	private String panNo;
	

}
