package regextest;

import java.util.logging.Level;
import java.util.logging.Logger;

import custom.CustomException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import regextask.RegexTask;

public class RegexTest {
public static void main(String...args) {
	Logger logger=Logger.getLogger(RegexTest.class.getName());
	RegexTask task=new RegexTask();
	Scanner sc=new Scanner(System.in);
	int choice;
	do {
		logger.log(Level.INFO,"Enter the problem number");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {	
	case 1:
		try {
		logger.log(Level.INFO,"Enter the mobile number:");
		String number=sc.nextLine();
		boolean num=task.mobileNumberValidation(number);
		if(num==true) {
			logger.log(Level.INFO,"Mobile number is valid");
		}
		else {
			logger.log(Level.INFO,"Mobile number is not valid");
		}
		}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
	break;
	case 2:
		try {
		logger.log(Level.INFO,"Enter the string to check alphanumeric:");
		String input=sc.nextLine();
		boolean checked=task.checkAlphaNumeric(input);
		if(checked==true) {
			logger.log(Level.INFO,"Given string is AlphaNumeric");
		}
		else {
			logger.log(Level.INFO,"Given string is not AlphaNumeric");
		}
		}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
		break;
	case 3:
		try {
		logger.log(Level.INFO,"Enter the string :");
		String input2=sc.nextLine();
		logger.log(Level.INFO,"Enter the matching string :");
		String input3=sc.nextLine();	
				logger.log(Level.INFO,"Start with matching string:"+task.startsWith(input2, input3));	
				logger.log(Level.INFO,"Ends with matching string:"+task.endsWith(input2, input3));
				logger.log(Level.INFO,"contains matching string:"+task.contains(input2, input3));
				logger.log(Level.INFO,"Equals with matching string:"+task.equalsWithCaseSensitive(input2, input3));
			}
			catch (CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
	break;
	case 4:
		try {
			List<String> myArray=task.getArrayList();
			logger.log(Level.INFO,"Enter the number of strings to add :");
			int no=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<=no;i++) {
				logger.log(Level.INFO,"Enter the Strings"+i+":");
				String added=sc.nextLine();
				task.addElement(myArray,added);
			}
			logger.log(Level.INFO,"Enter matching string:");
			String match=sc.nextLine();
			logger.log(Level.INFO,"Equals with matching string:"+task.checkEquals(myArray, match));
			}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
		break;
	case 5:
		try {
		logger.log(Level.INFO,"Enter the email:");
		String email=sc.nextLine();
		boolean valid=task.emailValidation( email);
		if(valid==true) {
			logger.log(Level.INFO,"Email address is valid");
		}
		else {
			logger.log(Level.INFO,"Email address is not valid");
		}
		}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
	break;
	case 6:
		try {
			List<String> myArray=task.getArrayList();
			logger.log(Level.INFO,"Enter the number of strings to add :");
			int no=sc.nextInt();
			sc.nextLine();
			for(int i=1;i<=no;i++) {
				logger.log(Level.INFO,"Enter the Strings"+i+":");
				String added=sc.nextLine();
				task.addElement(myArray,added);
			}
			logger.log(Level.INFO,"Arraylist is"+myArray);
			logger.log(Level.INFO,"String range is:"+task.checkRange(myArray));
			}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
		break;
	case 7:
		try {
			List<String> myArray1=task.getArrayList();
			logger.log(Level.INFO,"Enter the number of strings to add in list1 :");
			int list1=sc.nextInt();
			sc.nextLine();
			for(int i=1;i<=list1;i++) {
				logger.log(Level.INFO,"Enter the Strings"+i+":");
				String added=sc.nextLine();
				task.addElement(myArray1,added);
			}
			List<String> myArray2=task.getArrayList();
			logger.log(Level.INFO,"Enter the number of matching strings to add in list2 :");
			int list2=sc.nextInt();
			sc.nextLine();
			for(int i=1;i<=list2;i++) {
				logger.log(Level.INFO,"Enter the Strings"+i+":");
				String added=sc.nextLine();
				task.addElement(myArray2,added);
			}
			Map<String,Integer> result=task.findMatcher(myArray1, myArray2);
			if(result.isEmpty()) {
				logger.log(Level.INFO,"There is no matching string with list 1");
			}
			 for (Map.Entry<String, Integer> entry : result.entrySet()) {
				 logger.log(Level.INFO,"The key  is:" + entry.getKey() +"The value is:"+ entry.getValue());
		        
		         }
			 
			
			}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
		break;
	case 8:
		try {
			
			logger.log(Level.INFO,"Enter the html string:");
			String html=sc.nextLine();
			List<String> result=task.printHtmlTag(html);
			for(String str:result) {
				logger.log(Level.INFO,"The html tag is:"+str);
			}
			
		}
		catch(CustomException e) {
			logger.log(Level.SEVERE,"An error occured",e);
		}
		break;
	case 9:
		try {
			logger.log(Level.INFO,"Enter the  password:");
			String password=sc.nextLine();
			boolean num=task.passwordValidation(password);
			if(num==true) {
				logger.log(Level.INFO,"Password is valid");
			}
			else {
				logger.log(Level.INFO,"Password is not valid");
			}
			}
			catch(CustomException e) {
				logger.log(Level.SEVERE,"An error occured",e);
			}
		break;
		
		
}
}
	while(choice<=8 || choice>=1);
	sc.close();
}
}
