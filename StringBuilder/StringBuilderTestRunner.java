package sbtest;
import sbtask.StringBuilderTask;
import java.util.Scanner;
import custom.CustomException;
import util.Utility;

public class StringBuilderTestRunner {
    public static void main(String[] args) {
   	Scanner sc = new Scanner(System.in);
   	StringBuilderTask sbt = new StringBuilderTask();
   	int choice;
   do {
	System.out.println("The entered number should be between 1 to 20");
        System.out.println("Enter the problem to be shown:");
        choice = sc.nextInt();
        sc.nextLine();
switch (choice) {
case 1:
	try{
	StringBuilder strBuilder=sbt.getStringBuilder();
	System.out.println("length of the string is: " + Utility.findLength(strBuilder));
	System.out.println("Enter string to be added:");
	String input = sc.nextLine();
	System.out.println("The final string is " + sbt.addString(strBuilder,input));
	System.out.println("length of the string after adding : " + Utility.findLength(strBuilder));
	}

	catch (CustomException e) {
        e.printStackTrace();
        }
	break;
case 2:
	try{
	System.out.print("Enter the initial string: ");
        String initialString = sc.nextLine();
        System.out.println("Length of input string is:"+Utility.findLength(initialString));
        System.out.print("Enter the separator: ");
        String seperator = sc.nextLine();
        System.out.print("Enter the number of strings to add: ");
        int addString = sc.nextInt();
	sc.nextLine();
	StringBuilder stringBuilder = sbt. getStringBuilder(initialString);
        for (int i = 1; i <= addString; i++) {
           System.out.print("Enter String" + i + ": ");
           String additionalString = sc.nextLine();
           sbt.addString(stringBuilder,seperator);
           sbt.addString(stringBuilder,additionalString);
        }
        System.out.println("Length of final StringBuilder: " +Utility.findLength(stringBuilder) );
        System.out.println("Final StringBuilder content: " + stringBuilder);
        }
        catch(CustomException e){
        e.printStackTrace();
        }
        break;
case 3 :
	try{
	System.out.print("Enter the string: ");
        String inputString = sc.nextLine();
        System.out.println("Length of input string is:"+Utility.findLength(inputString));
        System.out.print("Enter the separator: ");
        String seperator = sc.nextLine();
        System.out.print("Enter the string to insert: ");
        String stringToInsert = sc.nextLine();
        StringBuilder stringBuilder = sbt. getStringBuilder( inputString);
	sbt.insertString(seperator,stringBuilder,stringToInsert );
	sbt.insertString(stringToInsert ,stringBuilder,seperator );
        System.out.println("inserted string is:"+stringBuilder);
        System.out.println("Length of inserted string is:"+Utility.findLength(stringBuilder));
        }
        catch(CustomException e){
        e.printStackTrace();
        }
        break;
case 4:
	try{
	System.out.print("Enter the  string: ");
        String inputString = sc.nextLine();
        System.out.println("the length is "+Utility.findLength(inputString));
        StringBuilder strBuilder = sbt. getStringBuilder( inputString);
        System.out.print("Enter the  String to delete :");
	String stringToDelete=sc.nextLine();
        sbt.deleteString(strBuilder, stringToDelete);
        System.out.println("Final string is "+strBuilder);
        System.out.println("Final string length is "+Utility.findLength(strBuilder)); 
        }
        catch(CustomException e){
        e.printStackTrace();
        }
        break;
        
case 5: 
	try{
	System.out.println("Enter the string:");
        String inputString2 = sc.nextLine();
        System.out.println("The inputString length is " +Utility.findLength(inputString2) );
        StringBuilder stringBuilder = sbt. getStringBuilder( inputString2);
        System.out.println("Enter the separator :");
        String seperator=sc.nextLine();
        System.out.println("Enter the replacement character:");
        String replaceInput = sc.nextLine();
        System.out.println("Replace string is :" +  sbt.replaceString(stringBuilder,seperator,replaceInput));
        System.out.println("length of Replace string is :" + Utility.findLength( stringBuilder));
        }
        catch(CustomException e){
        e.printStackTrace();
        }
        break;
case 6:
	try{
	 System.out.println("Enter the String");
         String inputString1=sc.nextLine();
   	 System.out.println("length of inputString :" +Utility.findLength(inputString1));
  	 StringBuilder stringBuilder = sbt. getStringBuilder( inputString1);
  	 //stringBuilder=null;
  	 sbt.reverseString(stringBuilder);
   	 System.out.println("Reverse string is : " +  stringBuilder);
    	 System.out.println("Reverse string length is: " + Utility.findLength( stringBuilder));
    	 }
    	 catch(CustomException e){
         e.printStackTrace();
         }
         break;
case 7:
	try{
	System.out.print("Enter the  String: ");
        String inputString = sc.nextLine();
        System.out.println("The length is "+Utility.findLength(inputString));
        StringBuilder strBuilder = sbt. getStringBuilder( inputString);
         //stringBuilder=null;
        System.out.print("Enter the character to  delete: ");
 	String charToDelete = sc.nextLine();
        sbt.deleteString(strBuilder,charToDelete);
        System.out.println(" final string is "+strBuilder);
        System.out.println("final string length is "+Utility.findLength(strBuilder));
        }
        catch(CustomException e){
        e.printStackTrace();
        }
        break;
case 8:
	try{
	System.out.println("Enter string");
        String input=sc.nextLine();
        StringBuilder stringBuilder = sbt. getStringBuilder( input);
         //stringBuilder=null;
        int len=Utility.findLength(input);
        System.out.println("length of String is "+ len);
        System.out.print("Enter the  string to remove : ");
        String removeStr=sc.nextLine();
        System.out.println("Enter string to replace :");
        String replaceStr=sc.nextLine();
        sbt.replaceString(stringBuilder,removeStr,replaceStr);
        System.out.println("Replace string is :"+ stringBuilder);
        System.out.println("Replace string length is :"+ Utility.findLength(stringBuilder));
        }
        catch (CustomException e){
        e.printStackTrace();
        }
        break;
case 9:
	try{
	System.out.println("Enter string");
        String input=sc.nextLine();
        StringBuilder stringBuilder = sbt. getStringBuilder( input);
         //stringBuilder=null;
        System.out.println("Enter seperator");
        String seperator=sc.nextLine();
        System.out.println("length is "+Utility.findLength(input) );
        System.out.println("The index of first seperator is :" + sbt.findIndex(seperator,stringBuilder));
        }
        catch (CustomException e){
        e.printStackTrace();
        }
        break;
        
case 10:
	try{
	 System.out.println("Enter string: ");
         String input=sc.nextLine();
         StringBuilder stringBuilder = sbt. getStringBuilder( input);
          //stringBuilder=null;
  	 System.out.println("Enter seperator");
  	 String seperator=sc.nextLine();
         System.out.println("length of input is :"+ Utility.findLength(input));
         System.out.println("The last index is :" + sbt.findLastIndex(seperator,stringBuilder));
         }
        catch (CustomException e){
        e.printStackTrace();
        }
        break;
default :
 	System.out.println("Not valid.Enter the number between 1 to 20");
       

                     
            }
        } while (choice<=10 || choice>=1); 
    }
}


