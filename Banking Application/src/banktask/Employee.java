package banktask;

public class Employee extends User{
private int branchId;


public Employee(long userId, String name, String password, String dateOfBirth, long mobileNumber, String emailId,
		String status, String role, int branchId) {
	super(userId, name, password, dateOfBirth, mobileNumber, emailId);
	this.branchId = branchId;
}
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}

	
	

}
