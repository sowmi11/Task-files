package dbtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import custom.CustomException;
public class DbTask {
	String url="jdbc:mysql://localhost:3306/incubationDB?useSSL=false";
	String userName="root";
	String password="";
	 Connection con = null;
	public PreparedStatement  connectdb(String input) throws CustomException, SQLException {
	try {
	    Connection con=DriverManager.getConnection(url, userName, password);
			PreparedStatement stmt= con.prepareStatement(input);
		return stmt;
	}
	catch (SQLException e) {
        throw new CustomException(e.getMessage());
    }
	finally {
		if(con !=null) {
			con.close();
		}
	}
	}


	public void createTable() throws CustomException, SQLException {
	    String sql = "CREATE TABLE Employee(" +
	            "Employee_Id int auto_increment PRIMARY KEY," +
	            "Name varchar(100) NOT NULL," +
	            "Mobile numeric(15)," +
	            "Email varchar(50)," +
	            "Department varchar(50)" +
	            ")";
	    try (PreparedStatement stmt = connectdb(sql)) {
	         stmt.execute(); 
	    }
	}

public void insertTable(Employee employee) throws CustomException, SQLException {

	String sql="INSERT INTO Employee(Name,Mobile,Email,Department) VALUES(?,?,?,?)";
	try(PreparedStatement stmt=connectdb(sql)){
		 stmt.setString(1, employee.getName());
	     stmt.setLong(2, employee.getMobile());
	     stmt.setString(3, employee.getEmail());
	     stmt.setString(4, employee.getDepartment());
	     stmt.execute();
	}
}
public List<Employee> retrieveTable(String name) throws CustomException, SQLException {
	List<Employee> resultList=new ArrayList<>();
	String sql="SELECT * FROM Employee WHERE Name=?";
	try(PreparedStatement stmt=connectdb(sql)){
		stmt.setString(1,name);
	try(ResultSet result=	stmt.executeQuery()){
	while(result.next()) {
		 Employee employee = new Employee();
		int id=result.getInt("Employee_Id");
		Long mobile=result.getLong("Mobile");
		String email=result.getString("Email");
		String department=result.getString("Department");
         employee.setEmployee_id(id);
         employee.setMobile(mobile);
         employee.setEmail(email);
         employee.setDepartment(department);
		 resultList.add(employee);
	}
	}
}
	return resultList;
}
public boolean updateTable(String detailToModify,String department,long mobile,String email,String name) throws SQLException, CustomException {
	
	boolean result = false;
	detailToModify=detailToModify.toLowerCase();
		switch(detailToModify) {
        case "department":
        	String sql="UPDATE Employee SET Department=? WHERE Name=?";
        	try(PreparedStatement stmt=connectdb(sql)){
            stmt.setString(1, department);
            stmt.setString(2, name);
            result=stmt.executeUpdate()>0;
            break;
        	}
        case "mobile":
        	String sql1="UPDATE Employee SET Mobile=? WHERE Name=?";
        	try(PreparedStatement stmt=connectdb(sql1)){
        		 stmt.setLong(1, mobile);
        		 stmt.setString(2, name);
        		 result=stmt.executeUpdate()>0;
            break;
        	}
        case "email":
        	String sql2="UPDATE Employee SET Email=? WHERE Name=?";
        	try(PreparedStatement stmt=connectdb(sql2)){
        		 stmt.setString(1, email);
        		 stmt.setString(2, name);
        		 result=stmt.executeUpdate()>0;
            break;
        	}
     
		}
		 
	return result;
}
public List<Employee> listEmployees(int limit,int starting) throws SQLException, CustomException{
	if(starting!=0) {
		starting=starting-1;
	}
	List<Employee> resultList=new ArrayList<>();
	String sql="SELECT * FROM Employee LIMIT ? OFFSET ?";
	try(PreparedStatement stmt=connectdb(sql)){
		 stmt.setInt(1,limit);
		 stmt.setInt(2,starting );
	try(ResultSet result=	stmt.executeQuery()){
		while(result.next()) {
		Employee employee = new Employee();
		String name=result.getString("Name");
		int id=result.getInt("Employee_Id");
		Long mobile=result.getLong("Mobile");
		String email=result.getString("Email");
		String department=result.getString("Department");
         employee.setName(name);
         employee.setEmployee_id(id);
         employee.setMobile(mobile);
         employee.setEmail(email);
         employee.setDepartment(department);
		resultList.add(employee);
				}
				}
			}
				return resultList;
			}
public List<Employee>  orderEmployee(String columnName) throws SQLException, CustomException {
	List<Employee> resultList=new ArrayList<>();
	String sql="SELECT * FROM Employee ORDER BY "+columnName;
	try(PreparedStatement stmt=connectdb(sql)){
		try(ResultSet result=	stmt.executeQuery()){
			while(result.next()) {
			Employee employee = new Employee();
			String name=result.getString("Name");
			int id=result.getInt("Employee_Id");
			Long mobile=result.getLong("Mobile");
			String email=result.getString("Email");
			String department=result.getString("Department");
	         employee.setName(name);
	         employee.setEmployee_id(id);;
	         employee.setMobile(mobile);
	         employee.setEmail(email);
	         employee.setDepartment(department);
			resultList.add(employee);
					}
					}
				}
					return resultList;
				}
public  boolean deleteEmployee(int id) throws SQLException, CustomException {
	boolean result=false;
	String sql="DELETE FROM Employee WHERE Employee_id=?";
	try(PreparedStatement stmt=connectdb(sql)){
		stmt.setInt(1, id);
		result=stmt.executeUpdate()>0;
	}
	return result;
}
public void createDependentTable() throws SQLException, CustomException {
    String sql = "CREATE TABLE Dependent (" +
            "Id int auto_increment PRIMARY KEY," +
            "Employee_id int," +
            "Name varchar(100) NOT NULL," +
            "Age int," +
            "Relationship Varchar(50)," +
            "FOREIGN KEY (Employee_id) REFERENCES Employee(Employee_ID) ON DELETE CASCADE" +
            ")";
    try (PreparedStatement stmt = connectdb(sql)) {
       stmt.executeUpdate() ; 
    }
}
public void insertDependentForEmployee(Employee details)
        throws CustomException, SQLException {
    String sql = "INSERT INTO Dependent (Employee_id, Name, Age, Relationship) VALUES ( ?,?, ?, ?)";

    try (PreparedStatement stmt = connectdb(sql)) {
    	stmt.setInt(1,details.getEmployee_id());
        stmt.setString(2,details.getDep_name());
        stmt.setInt(3, details.getAge());
        stmt.setString(4, details.getRelation());
        stmt.executeUpdate();
    }
}
public List<Employee> listEmployees(String input) throws SQLException, CustomException {
	List<Employee> resultList=new ArrayList<>();
	 String sql = "SELECT Employee.Employee_id, Employee.Name, Dependent.Name As dependentName, " +
             "Dependent.Age, Dependent.Relationship " +
             "FROM Employee " +
             "JOIN Dependent " +
             "ON Employee.Employee_id = Dependent.Employee_id " +
             "WHERE Employee.name = ? OR Employee.Employee_id = ?";
	try(PreparedStatement stmt=connectdb(sql)){
		stmt.setString(1,input);
		stmt.setString(2,input);
		try(ResultSet resultSet=stmt.executeQuery()){
			while(resultSet.next()) {
				 Employee employee = new Employee();
				String Employee_name=resultSet.getString("Name");
				int id=resultSet.getInt("Employee_Id");
				String dependent_name=resultSet.getString("dependentName");
				int age=resultSet.getInt("Age");
				String relationShip=resultSet.getString("Relationship");
		         employee.setName(Employee_name);
		         employee.setEmployee_id(id);
		         employee.setDep_name(dependent_name);
		         employee.setAge(age);
		         employee.setRelation(relationShip);
				resultList.add(employee);
						}
						}
					}
						return resultList;
			}
public List<Employee> sortingEmployees(int number) throws SQLException, CustomException{
	List<Employee> resultList = new ArrayList<>();
	String sql = "SELECT e.employee_id, e.name as employeeName, " +
	             "d.name AS dependentName, d.age, d.relationship " +
	             "FROM (SELECT * FROM Employee ORDER BY name LIMIT ?) e " +
	             "LEFT JOIN Dependent d ON e.employee_id = d.employee_id " +
	             "ORDER BY e.name";

	try (PreparedStatement stmt = connectdb(sql)) {
	    stmt.setInt(1, number);
	    try (ResultSet resultSet = stmt.executeQuery()) {
	        while (resultSet.next()) {
	            Employee employee = new Employee();
	            String Employee_name = resultSet.getString("employeeName");
	            int id = resultSet.getInt("employee_id");
	            String dependent_name = resultSet.getString("dependentName");
	            int age = resultSet.getInt("age");
	            String relationShip = resultSet.getString("relationship");

	            employee.setName(Employee_name);
	            employee.setEmployee_id(id);
	            employee.setDep_name(dependent_name);
	            employee.setAge(age);
	            employee.setRelation(relationShip);

	            resultList.add(employee);
	        }
	    }
	}
	return resultList;

			 }
		 }
	 

			


