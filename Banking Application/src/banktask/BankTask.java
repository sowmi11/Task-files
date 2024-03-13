package banktask;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import custom.CustomException;
//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
public class BankTask {

	String url = "jdbc:mysql://localhost:3306/Banking?useSSL=false";
	String userName = "root";
	String password = "";

	public void createBranchTable() throws CustomException {
		String sql = "CREATE TABLE IF NOT EXISTS Branch ("
				+ "branchId INT(10) AUTO_INCREMENT PRIMARY KEY, " 
				+ "branchName VARCHAR(45),"
				+ "branchLocation VARCHAR(45)"
				+ ")";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
		} catch (SQLException e) {

			throw new CustomException("Error occured.",e);
		}
	}
	

	public void createUserTable() throws CustomException {
		String sql = "CREATE TABLE IF NOT EXISTS User (" + "UserId INT(10)  PRIMARY KEY, " 
				+"Password VARCHAR(12) NOT NULL,"
				+ "Name VARCHAR(100) NOT NULL,"
				+ "DateOfBirth DATE,"
				+"Mobile VARCHAR(100) NOT NULL,"
				+"EmailId VARCHAR(100) NOT NULL,"
				+"Status ENUM('active','inactive') NOT NULL DEFAULT 'active',"
				+"Role ENUM('Admin','Employee','Customer') NOT NULL"
				+ ")";
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
		} catch (SQLException e) {

			throw new CustomException("Error occured.",e);
		}
	}
		public void createEmployeeTable() throws CustomException {
			String sql = "CREATE TABLE IF NOT EXISTS Employee (" 
					+ "UserId int,"
					+"branchId int(10),"
					+ "FOREIGN KEY(UserId) REFERENCES User(UserId),"
					+"FOREIGN KEY(branchId) REFERENCES Branch(branchId)"
					+ ")";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.execute();
			} catch (SQLException e) {

				throw new CustomException("Error occured.",e);
			}
	}
		public void createCustomerTable() throws CustomException {
			String sql = "CREATE TABLE IF NOT EXISTS Customer (" 
					+ "UserId int,"
					+"AdhaarNo VARCHAR(12) NOT NULL,"
					+"PanNo VARCHAR(10) NOT NULL,"
					+ "FOREIGN KEY(UserId) REFERENCES User(UserId)"
					+ ")";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.execute();
			} catch (SQLException e) {

				throw new CustomException("Error occured.",e);
			}
	}
		public void createAccountsTable() throws CustomException {
		    String sql = "CREATE TABLE IF NOT EXISTS Accounts("
		                 + "AccountId INT(10) AUTO_INCREMENT PRIMARY KEY, "
		                 + "AccountNo VARCHAR(18), "
		                 + "UserId INT(10), "
		                 + "Balance DECIMAL(10, 2), "
		                 + "OpenDate DATE, "
		                 + "Status ENUM('active', 'inactive') NOT NULL DEFAULT 'active',"
		                 +"FOREIGN KEY(UserId) REFERENCES User(UserId)"
		                 + ")";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.execute();
			} catch (SQLException e) {

				throw new CustomException("Error occured.",e);
			}
	}
		public void createTransactionTable() throws CustomException  {
		    String sql = "CREATE TABLE IF NOT EXISTS Transaction ("
		               + "TransactionId INT(10) AUTO_INCREMENT PRIMARY KEY, "
		               + "AccountId INT(10), "
		               + "TransactionType ENUM('deposit', 'withdraw', 'transfer'), "
		               + "TransactionAmount DECIMAL(10,2), "
		               +"TransactionAccountNo VARCHAR(18),"
		               + "TransactionDate DATE, "
		               + "TransactionStatus ENUM('pending', 'completed', 'failed'), "
		               +"CurrentBalance DECIMAL(10,2),"
		               + "FOREIGN KEY (AccountId) REFERENCES Accounts(AccountId)"
		               + ")";
		    try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.execute();
			} catch (SQLException e) {

				throw new CustomException("Error occured.",e);
			}
		}


		public void insertUsers(User user) throws CustomException {
			String sql = "INSERT INTO User(userId,password,Name,DateOfBirth,Mobile,EmailId) VALUES(?,?,?,?,?,?)";
			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setLong(1, user.getUserId());
				stmt.setString(2, user.getPassword());
				stmt.setString(3, user.getName());
				stmt.setDate(4,Date.valueOf(user.getDateOfBirth()));
				stmt.setLong(5, user.getMobileNumber());
				stmt.setString(6, user.getEmailId());
				stmt.executeUpdate();
			} catch (SQLException e) {

				throw new CustomException("Error occured.", e);
			}

		}

		public void insertBranch(Branch branch) throws CustomException {
			String sql = "INSERT INTO Branch(branchName,branchLocation) VALUES (?,?)";

			try (Connection con = DriverManager.getConnection(url, userName, password);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1,branch.getBranchName());
				stmt.setString(2, branch.getBranchLocation());
				stmt.execute();
			} catch (SQLException e) {

				throw new CustomException("Error occured.", e);
			}
		}

	}
 