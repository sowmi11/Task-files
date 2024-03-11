package dbtest;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import custom.CustomException;
import dbtask.DbTask;
import dbtask.Dependent;
import dbtask.Employee;

public class DbTest {
	public static void main(String... args) {
		DbTask task = new DbTask();
		Logger logger = Logger.getLogger(DbTest.class.getName());
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			logger.log(Level.INFO, "Enter problem number:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				try {
					task.createTable();
				} catch (CustomException e) {
					logger.log(Level.SEVERE, "An error occured", e);
				}
				break;
			case 2:
				try {
					Employee employee = new Employee();
					logger.log(Level.INFO, "Enter number of Employees to insert:");
					int num = sc.nextInt();
					sc.nextLine();
					for (int i = 1; i <= num; i++) {
						logger.log(Level.INFO, "Enter the name of Employee" + i + ":");
						String name = sc.nextLine();
						logger.log(Level.INFO, "Enter the mobile number of Employee:");
						long mobile = sc.nextLong();
						sc.nextLine();
						logger.log(Level.INFO, "Enter the email of Employee:");
						String email = sc.nextLine();
						logger.log(Level.INFO, "Enter the department of Employee:");
						String dept = sc.nextLine();
						employee.setName(name);
						employee.setMobile(mobile);
						employee.setEmail(email);
						employee.setDepartment(dept);
					}
					task.insertTable(employee);
				} catch (CustomException e) {
					logger.log(Level.SEVERE, "An error occured", e);
				}
				break;
			case 3:
				logger.log(Level.INFO, "Enter exit to finish..");
				String name;
				do {
					logger.log(Level.INFO, "Enter the name of Employee to retrieve:");
					name = sc.nextLine();
					try {
						List<Employee> result = task.retrieveTable(name);
						for (Employee employee : result) {
							logger.log(Level.INFO, "Employee ID: " + employee.getEmployeeId());
							logger.log(Level.INFO, "Mobile: " + employee.getMobile());
							logger.log(Level.INFO, "Email: " + employee.getEmail());
							logger.log(Level.INFO, "Department: " + employee.getDepartment());
						}

					} catch (CustomException e) {
						logger.log(Level.SEVERE, "An error occured", e);
					}

				} while (!name.equalsIgnoreCase("exit"));

				logger.log(Level.INFO, "Exiting the program...");
				break;
			case 4:
				logger.log(Level.INFO, "Enter exit to finish..");
				String id1;
				String dept = null;
				long mobile = 0;
				String email = null;
				while (true) {

					logger.log(Level.INFO, "Enter the  Employee id to update:");
					id1 = sc.nextLine();
					if (id1.equalsIgnoreCase("exit")) {
						break;
					}
					logger.log(Level.INFO, "Enter the detail you want to modify (department, mobile, or email):");
					String detailToModify = sc.nextLine();
					detailToModify = detailToModify.toLowerCase();
					switch (detailToModify) {
					case "department":
						logger.log(Level.INFO, "Enter the new department to modify:");
						dept = sc.nextLine();
						break;
					case "mobile":
						logger.log(Level.INFO, "Enter the new mobile to modify:");
						mobile = sc.nextLong();
						sc.nextLine();
						break;
					case "email":
						logger.log(Level.INFO, "Enter the new email to modify");
						email = sc.nextLine();
						break;
					}
					int employee_id = Integer.parseInt(id1);
					try {
						boolean result = task.updateTable(detailToModify, dept, mobile, email, employee_id);
						if (result) {
							logger.log(Level.INFO, "Updated Successfully");
						} else {
							logger.log(Level.INFO, "Try Again..");
						}
					} catch (CustomException e) {
						logger.log(Level.SEVERE, "An error occured", e);
					}
				}
				logger.log(Level.INFO, "Exiting the program...");
				break;
			case 5:
				logger.log(Level.INFO, "Enter the starting number to list:");
				int starting = sc.nextInt();
				logger.log(Level.INFO, "Enter the number of employees to retrieve:");
				int limit = sc.nextInt();
				try {
					List<Employee> list = task.listEmployees(limit, starting);
					for (Employee employee : list) {
						logger.log(Level.INFO, "Name: " + employee.getName());
						logger.log(Level.INFO, "Employee ID: " + employee.getEmployeeId());
						logger.log(Level.INFO, "Mobile: " + employee.getMobile());
						logger.log(Level.INFO, "Email: " + employee.getEmail());
						logger.log(Level.INFO, "Department: " + employee.getDepartment());
					}

				} catch (CustomException e) {
					logger.log(Level.SEVERE, "An error occured", e);
				}
				break;
			case 6:
				logger.log(Level.INFO, "Enter the column name for ordering");
				String colName = sc.nextLine();
				try {
					List<Employee> list = task.orderEmployee(colName);
					for (Employee employee : list) {
						logger.log(Level.INFO, "Name: " + employee.getName());
						logger.log(Level.INFO, "Employee ID: " + employee.getEmployeeId());
						logger.log(Level.INFO, "Mobile: " + employee.getMobile());
						logger.log(Level.INFO, "Email: " + employee.getEmail());
						logger.log(Level.INFO, "Department: " + employee.getDepartment());
					}

				} catch (CustomException e) {
					logger.log(Level.SEVERE, "An error occured", e);
				}
				break;
			case 7:
				logger.log(Level.INFO, "Enter the employee id to delete");
				int id = sc.nextInt();
				try {
					boolean result = task.deleteEmployee(id);
					if (result) {
						logger.log(Level.INFO, "Record is deleted succesfully..");
					}
					logger.log(Level.INFO, "Enter the starting number to list:");
					int startings = sc.nextInt();
					logger.log(Level.INFO, "Enter the number of employees to retrieve:");
					int limits = sc.nextInt();
					List<Employee> list = task.listEmployees(limits, startings);
					for (Employee employee : list) {
						logger.log(Level.INFO, "Name: " + employee.getName());
						logger.log(Level.INFO, "Employee ID: " + employee.getEmployeeId());
						logger.log(Level.INFO, "Mobile: " + employee.getMobile());
						logger.log(Level.INFO, "Email: " + employee.getEmail());
						logger.log(Level.INFO, "Department: " + employee.getDepartment());
					}

				}

				catch (CustomException e) {
					logger.log(Level.SEVERE, "An error occured", e);
				}
				break;
			case 8:
				try {
					task.createDependentTable();
				} catch (CustomException e) {
					logger.log(Level.SEVERE, "An error occured .Table already exists...", e);
				}
				break;
			case 9:
				// Employee details = new Employee();
				Dependent depend = new Dependent();
				while (true) {
					logger.log(Level.INFO, "Enter 'exit' to finish or Employee's Id:");
					String input = sc.nextLine();
					if (input.equalsIgnoreCase("exit")) {
						break;
					}
					int employeId = Integer.parseInt(input);
					logger.log(Level.INFO, "Enter dependent's name");
					String dependentName = sc.nextLine();
					logger.log(Level.INFO, "Enter dependent's age");
					int age = sc.nextInt();
					sc.nextLine();
					logger.log(Level.INFO, "Enter dependent's Relationship :");
					String relation = sc.nextLine();
					depend.setEmployeeId(employeId);
					depend.setDependentName(dependentName);
					depend.setAge(age);
					depend.setRelation(relation);
					try {
						task.insertDependentForEmployee(depend);
					} catch (CustomException e) {
						logger.log(Level.SEVERE, "An error occurred.", e);
					}
				}
				logger.log(Level.INFO, "Exiting the program...");
			case 10:
				String input;
				do {
					logger.log(Level.INFO, "Enter name of employee  ");
					input = sc.nextLine();
					logger.log(Level.INFO, "Enter employeeId:");
					int employeeId = sc.nextInt();
					sc.nextLine();
					try {
						List<Employee> employee = task.listEmployees(input, employeeId);
						for (Employee detail : employee) {
							logger.log(Level.INFO, "Employee Name:" + detail.getName());
							logger.log(Level.INFO, "Employee Id:" + detail.getEmployeeId());
							for (Dependent details : detail.getDependents()) {
								logger.log(Level.INFO, "Dependent name:" + details.getDependentName());
								logger.log(Level.INFO, "Dependent age:" + details.getAge());
								logger.log(Level.INFO, "Dependent Relation:" + details.getRelation());

							}
						}
					}

					catch (CustomException e) {
						logger.log(Level.SEVERE, "An error occurred.", e);
					}
				} while (!input.equalsIgnoreCase("exit"));
				break;
			case 11:
				String number;
				do {
					try {
						logger.log(Level.INFO, "Enter the number of employees : ");
						number = sc.nextLine();
						if (number.equalsIgnoreCase("exit")) {
							break;
						}
						int no = Integer.parseInt(number);

						Map<Integer,Employee> dependentList = task.sortingEmployees(no);
						for (Map.Entry<Integer, Employee> entry : dependentList.entrySet()) {
						   // Integer employeeId = entry.getKey();
						    Employee detail = entry.getValue();

						    logger.log(Level.INFO, "Employee Name: " + detail.getName());
						    logger.log(Level.INFO, "Employee Id: " + detail.getEmployeeId());
							for (Dependent details : detail.getDependents()) {
								logger.log(Level.INFO, "Dependent name:" + details.getDependentName());
								logger.log(Level.INFO, "Dependent age:" + details.getAge());
								logger.log(Level.INFO, "Dependent Relation:" + details.getRelation());

							}


						}
					}catch (CustomException e) {
						logger.log(Level.SEVERE, "An error occurred.", e);
					}
				} while (true);

				break;
			}
		} while (choice <= 12 || choice >= 1);
		sc.close();

	}
}