package banktest;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import banktask.BankTask;
import banktask.Branch;
import banktask.User;
import custom.CustomException;

public class BankTest {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		Logger logger = Logger.getLogger(BankTest.class.getName());
		BankTask task=new BankTask();
		int choice;
		do {
			logger.log(Level.INFO,"Enter problem number:");
			 choice=sc.nextInt();
			 sc.nextLine();
			switch(choice) {
			case 1:
				try {
					task.createBranchTable();
					task.createUserTable();
					task.createEmployeeTable();
					task.createCustomerTable();
					task.createAccountsTable();
					task.createTransactionTable();
					
				}
				catch(CustomException e) {
					logger.log(Level.SEVERE,"An error ocurred");
				}
				break;
			
			case 2:
				System.out.println("Enter number of branches to insert:");
				int number=sc.nextInt();
				sc.nextLine();
				for(int i=1;i<=number;i++) {
				System.out.println("Enter Branch Name:");
				String branchName=sc.nextLine();
				System.out.println("Enter Branch Location:");
				String branchLocation=sc.nextLine();
				Branch branch=new Branch(branchName,branchLocation);
				try {
				task.insertBranch(branch);
				}
				
				catch(CustomException e) {
					logger.log(Level.SEVERE,"The branch is not created..");
				}
				}
			
			break;
			case 3:
				System.out.println("Enter number of users to insert:");
				int number1=sc.nextInt();
				sc.nextLine();
				for(int i=1;i<=number1;i++) {
				System.out.println("Enter UserId:");
				long id= sc.nextLong();
				sc.nextLine();
				System.out.println("Enter Password:");
				String password=sc.nextLine();
				System.out.println("Enter Name:");
				String name=sc.nextLine();
				System.out.println("Enter date of birth:");
				String dateOfBirth=sc.nextLine();
				System.out.println("Enter EmailId:");
				String emailId=sc.nextLine();
				System.out.println("Enter mobile number:");
				long mobileNo=sc.nextLong();
				sc.nextLine();
				User user=new User(id,password,name,dateOfBirth,mobileNo,emailId);
				try {
					task.insertUsers(user);;
					}
					
					catch(CustomException e) {
						logger.log(Level.SEVERE,"The user is not created Successfully...");
					}
					}
			
				break;
			case 4:
				
			}
			}
			while(choice<10 || choice>=1);
		sc.close();
		
	}
}

