package banktask;

public class Branch {
private int branchId;
private String branchName;
private String branchLocation;
public Branch( String branchName, String branchLocation) {
	super();
	this.branchName = branchName;
	this.branchLocation = branchLocation;
}
public int getBranchId() {
	return branchId;
}
public String getBranchName() {
	return branchName;
}
public String getBranchLocation() {
	return branchLocation;
}


}
