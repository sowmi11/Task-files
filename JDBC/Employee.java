package dbtask;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private long mobile;
	private String email;
	private int employeeId;
	private String department;
	private List<Dependent> dependents;

	public Employee() {
		dependents = new ArrayList<>();
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void addDependent(Dependent dependent) {
		dependents.add(dependent);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
