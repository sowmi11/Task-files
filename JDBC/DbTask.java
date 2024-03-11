package dbtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import custom.CustomException;

public class DbTask {
	String url = "jdbc:mysql://localhost:3306/incubationDB?useSSL=false";
	String userName = "root";
	String password = "";

	public void createTable() throws CustomException {
		String sql = "CREATE TABLE Employee(" + "Employee_Id int auto_increment PRIMARY KEY,"
				+ "Name varchar(100) NOT NULL," + "Mobile numeric(15)," + "Email varchar(50),"
				+ "Department varchar(50)" + ")";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
		} catch (SQLException e) {
			throw new CustomException("Error Creating Table",e);
		}
	}

	public void insertTable(Employee employee) throws CustomException {

		String sql = "INSERT INTO Employee(Name,Mobile,Email,Department) VALUES(?,?,?,?)";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, employee.getName());
			stmt.setLong(2, employee.getMobile());
			stmt.setString(3, employee.getEmail());
			stmt.setString(4, employee.getDepartment());
			stmt.execute();
		} catch (SQLException e) {
			throw new CustomException("Error Inserting Values..");
		}
	}

	public List<Employee> retrieveTable(String name) throws CustomException {
		List<Employee> resultList = new ArrayList<>();
		String sql = "SELECT * FROM Employee WHERE Name=?";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			try (ResultSet result = stmt.executeQuery()) {
				while (result.next()) {
					Employee employee = new Employee();
					int id = result.getInt("Employee_Id");
					Long mobile = result.getLong("Mobile");
					String email = result.getString("Email");
					String department = result.getString("Department");
					employee.setEmployeeId(id);
					employee.setMobile(mobile);
					employee.setEmail(email);
					employee.setDepartment(department);
					resultList.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error While Retreiving.. ");
		}
		return resultList;
	}

	public boolean updateTable(String detailToModify, String department, long mobile, String email, int employeeId)
			throws CustomException {

		boolean result = false;
		switch (detailToModify) {
		case "department":
			String sql = "UPDATE Employee SET Department=? WHERE Employee_Id=?";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, department);
				stmt.setInt(2, employeeId);
				result = stmt.executeUpdate() > 0;
				break;
			} catch (SQLException e) {
				throw new CustomException("Error while updating Table");
			}
		case "mobile":
			String sql1 = "UPDATE Employee SET Mobile=? WHERE Employee_Id=?";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql1)) {
				stmt.setLong(1, mobile);
				stmt.setInt(2, employeeId);
				result = stmt.executeUpdate() > 0;
				break;
			} catch (SQLException e) {
				throw new CustomException("Error while updating Table");
			}
		case "email":
			String sql2 = "UPDATE Employee SET Email=? WHERE Employee_Id=?";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql2)) {
				stmt.setString(1, email);
				stmt.setInt(2, employeeId);
				result = stmt.executeUpdate() > 0;
				break;
			} catch (SQLException e) {
				throw new CustomException("Error while updating  Table");
			}

		}

		return result;
	}

	public List<Employee> listEmployees(int limit, int starting) throws CustomException {
		if (starting != 0) {
			starting = starting - 1;
		}
		List<Employee> resultList = new ArrayList<>();
		String sql = "SELECT * FROM Employee LIMIT ? OFFSET ?";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, limit);
			stmt.setInt(2, starting);
			try (ResultSet result = stmt.executeQuery()) {
				while (result.next()) {
					Employee employee = new Employee();
					String name = result.getString("Name");
					int id = result.getInt("Employee_Id");
					Long mobile = result.getLong("Mobile");
					String email = result.getString("Email");
					String department = result.getString("Department");
					employee.setName(name);
					employee.setEmployeeId(id);
					employee.setMobile(mobile);
					employee.setEmail(email);
					employee.setDepartment(department);
					resultList.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error while list the table");
		}

		return resultList;
	}

	public List<Employee> orderEmployee(String columnName) throws CustomException {
		List<Employee> resultList = new ArrayList<>();
		String sql = "SELECT * FROM Employee ORDER BY " + columnName;
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet result = stmt.executeQuery()) {
				while (result.next()) {
					Employee employee = new Employee();
					String name = result.getString("Name");
					int id = result.getInt("Employee_Id");
					Long mobile = result.getLong("Mobile");
					String email = result.getString("Email");
					String department = result.getString("Department");
					employee.setName(name);
					employee.setEmployeeId(id);
					employee.setMobile(mobile);
					employee.setEmail(email);
					employee.setDepartment(department);
					resultList.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error while Ordering the Table..");
		}
		return resultList;
	}

	public boolean deleteEmployee(int id) throws CustomException {
		boolean result = false;
		String sql = "DELETE FROM Employee WHERE Employee_id=?";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			result = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new CustomException("Error while deleting the records..");
		}
		return result;
	}

	public void createDependentTable() throws CustomException {
		String sql = "CREATE TABLE Dependent (" + "Id int auto_increment PRIMARY KEY," + "Employee_id int,"
				+ "Name varchar(100) NOT NULL," + "Age int," + "Relationship Varchar(50),"
				+ "FOREIGN KEY (Employee_id) REFERENCES Employee(Employee_ID) ON DELETE CASCADE" + ")";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Error Creating Table..");
		}
	}

	public void insertDependentForEmployee(Dependent details) throws CustomException {
		String sql = "INSERT INTO Dependent (Employee_id, Name, Age, Relationship) VALUES ( ?,?, ?, ?)";

		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, details.getEmployeeId());
			stmt.setString(2, details.getDependentName());
			stmt.setInt(3, details.getAge());
			stmt.setString(4, details.getRelation());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Error while inserting values..");
		}
	}

	public List<Employee> listEmployees(String name, int employeeId) throws CustomException {
		List<Employee> resultList = new ArrayList<>();
		String sql = "SELECT Employee.Employee_id, Employee.Name, Dependent.Name As Dependentname, "
				+ "Dependent.Age, Dependent.Relationship " + "FROM Employee " + "JOIN Dependent "
				+ "ON Employee.Employee_id = Dependent.Employee_id "
				+ "WHERE Employee.name = ? OR Employee.Employee_id = ?";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setInt(2, employeeId);
			try (ResultSet resultSet = stmt.executeQuery()) {
				Map<Integer, Employee> employeeMap = new HashMap<>();
				while (resultSet.next()) {
					int employId = resultSet.getInt("Employee_id");
					String employeeName = resultSet.getString("Name");
					String dependentName = resultSet.getString("Dependentname");
					int age = resultSet.getInt("Age");
					String relationShip = resultSet.getString("Relationship");
					Employee employee = employeeMap.get(employId);
					if (employee == null) {
						employee = new Employee();
						employee.setEmployeeId(employId);
						employee.setName(employeeName);
						resultList.add(employee);
						employeeMap.put(employId, employee);
					}
					Dependent dependent = new Dependent();
					dependent.setDependentName(dependentName);
					dependent.setAge(age);
					dependent.setRelation(relationShip);
					employee.addDependent(dependent);

				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error while listing the Employees..", e);
		}
		return resultList;
	}

	public Map<Integer,Employee> sortingEmployees(int number) throws CustomException {
		Map<Integer, Employee> employeeMap = new HashMap<>();
		String sql = "SELECT e.employee_id, e.name AS employeeName, "
				+ "d.name AS dependentName, d.age, d.relationship "
				+ "FROM (SELECT * FROM Employee ORDER BY name LIMIT ?) e "
				+ "LEFT JOIN Dependent d ON e.employee_id = d.employee_id " + "ORDER BY e.name";

		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, number);
			try (ResultSet resultSet = stmt.executeQuery()) {
				
				while (resultSet.next()) {
					int id = resultSet.getInt("employee_id");
					String employeeName = resultSet.getString("employeeName");
					String dependentName = resultSet.getString("dependentName");
					int age = resultSet.getInt("age");
					String relationship = resultSet.getString("relationship");

					Employee employee = employeeMap.get(id);
					if (employee == null) {
						employee = new Employee();
						employee.setEmployeeId(id);
						employee.setName(employeeName);
						employeeMap.put(id, employee);
					}
					Dependent dependent = new Dependent();
					dependent.setDependentName(dependentName);
					dependent.setAge(age);
					dependent.setRelation(relationship);
					employee.addDependent(dependent);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error while listing the Employees..", e);
		}
		return employeeMap;
	}
}
