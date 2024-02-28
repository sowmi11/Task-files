package strTask;
import str.StringTasks;
import custom.CustomException;
import java.util.Scanner;
import util.Utility;
import java.util.Arrays;
public class StringTestRunner {
  public static void main(String[] args) {
  	StringTasks str=new StringTasks();
  int choice;
  if(args.length > 0){
  try {
       System.out.println("Length of the string is " + Utility.findLength(args[0]));
      } 
  catch (CustomException e) {
       e.printStackTrace();
      }
 	}
  Scanner sc =new Scanner(System.in);
  do {
   System.out.println("The entered number should be between 2 to 20");
   System.out.println("Enter the problem to be shown :");
   choice=sc.nextInt();
   sc.nextLine();
  switch (choice){
case 2:
   try {
        System.out.println("String to char array conversion");
        System.out.println("Enter string:");
        String input = sc.nextLine();
        char[] res = str.stringToCharArray(input);
        System.out.println("The character array is ");
        for (char c : res) {
          System.out.println(c + " ");
        }
        }
         catch (CustomException e) {
              e.printStackTrace();
        }
  break;
case 3: 
 	try{
        System.out.println("Find penultimate in string");
        System.out.println("Enter a string: ");
        String inputStr = sc.nextLine();
        int len= Utility.findLength(inputStr);
        System.out.print("Enter the index to display (0 to " +( len-1)+ "): ");
        int index = sc.nextInt();
        System.out.println("The character at index " + index + " is: " + str.findPenultimate(index, inputStr));
            }  
          catch (CustomException e ) {
           e.printStackTrace();
           
         }
         
 break ;
case 4:
   System.out.println("Counting the occurrences in string");
       
            System.out.println("Enter string:");
            String input2 = sc.nextLine();
            System.out.println("Enter a character to find its occurrences:");
            char enteredChar = sc.next().charAt(0);
       try{
            int occurrences = str.countOccurrences(input2, enteredChar);
            System.out.println("The number of occurrences of '" + enteredChar + "' in the string is: " + occurrences);
        } 
        catch ( CustomException e) {
             e.printStackTrace();;
        }
break ;
case 5:
System.out.println("Greatest Position in String");
        System.out.println("Enter string:");
        String input3 = sc.nextLine();
        System.out.println("Enter a character to find its greatest position: ");
        char enteredChar1 = sc.next().charAt(0);

        try {
            int greatestPosition = str.findGreatestPosition(input3, enteredChar1);
            System.out.println("The greatest position of '" + enteredChar1 + "' in the string is: " + greatestPosition);
           } 
           catch (CustomException e) {
            e.printStackTrace();
           } 
break;
case 6: 
	System.out.println("Characters shown from last");  
	System.out.println("Enter string:");
	String input4=sc.nextLine();
	System.out.println("Enter how many characters have to be shown from last:");
	int length=sc.nextInt();
	 try{
	System.out.println("the last character from you entered is :"+str.charactersFromLast(input4,length));
	  } 
	  catch( CustomException e){
           e.printStackTrace();
     }
break;
case 7: 
	System.out.println("Characters shown from first");  
	System.out.println("Enter string:");
	String input5=sc.nextLine();
	System.out.println("Enter how many characters have to be shown from first:");
	int characters=sc.nextInt();
	try{
	System.out.println("the first character  from you entered is :" + str.charactersFromFirst(input5,characters));
		}	
  	catch(CustomException e){
          e.printStackTrace();
     }
break;
case 8:
 System.out.println("Replace characters in string");
 	try{
        System.out.println("Enter string:");
        String input6 = sc.nextLine();
        int charLen= Utility.findLength(input6);
        System.out.print("Enter the number of characters to replace: ");
        int count = sc.nextInt(); sc.nextLine(); 
            System.out.print("Enter the characters to use for replacement: ");
            String replace = sc.nextLine();
            System.out.println("Result after replacing characters: " + str.replaceCharacters(input6, count, replace));
        
        }
        catch(CustomException e){
          e.printStackTrace();
     }
break;
case 9 :
	System.out.println("Check if the string starts with:");
        System.out.println("Enter string:");
        String input7 = sc.nextLine();
        System.out.print("Enter a letter to check if the string starts with it: ");
        String letterToCheck = sc.nextLine();
        try{
        boolean startsWith = str.beginsWithWord(input7, letterToCheck);
        if (startsWith) {
            System.out.println("The string starts with '" + letterToCheck + "'");
        }
         else {
            System.out.println("The string does not start with '" + letterToCheck + "'");
        }
        }
         catch( CustomException e){
           e.printStackTrace();
       }
break;
case 10:
	System.out.println("Check the string whether it ends with:");
	System.out.println("Enter string:");
	String input8=sc.nextLine(); 
	System.out.print("Enter a letter to check if the string ends with it: ");
	String checkLetter = sc.nextLine(); 
	try{   
	boolean endsWith = str.endsWithWord(input8,checkLetter);
        if (endsWith) {
            System.out.println("The string ends with '" + checkLetter + "'");
        }
         else {
            System.out.println("The string does not end with '" + checkLetter + "'");
        }
        }  
        catch(CustomException e){
         e.printStackTrace();
     }
break;
case 11:
	System.out.println(" Uppercase to lowercase conversion");
	System.out.println("Enter string in Uppercase");
	String input9=sc.nextLine();  
	try{
	System.out.println("The lowercase String is " + str.lowerCase(input9));
  	} 
  	catch(CustomException e){
           e.printStackTrace();
       }
break;
case 12:
	System.out.println(" Lowercase to Uppercase conversion");
	System.out.println("Enter string in lowerCase:");
	String input10=sc.nextLine();
	try{
	System.out.println("The uppercase String is " + str.upperCase(input10));
	} 
	catch( CustomException e){
           e.printStackTrace();
     }
break;
case 13:
  System.out.println("Reverse String");
        System.out.println("Enter string:");
        String input11 = sc.nextLine();
        try {
            System.out.println("The reversed String is " + str.reverseString(input11));
        } 
        catch ( CustomException e) {
              e.printStackTrace();
        }
        break;
case 14:
         System.out.println("Concatenation in String");
         System.out.println("Enter multiple strings: ");
         String input12 = sc.nextLine();
         System.out.println("Enter delimiter to concatenate strings: ");
         String delimiter = sc.nextLine();
          try {
                System.out.println("The concatenated String is " + str.removeDelimiters(input12,delimiter));
               } 
                catch ( CustomException e) {
                   e.printStackTrace();
                }
	break;
	case 15 :
            System.out.println("Enclosing String");
            System.out.println("Enter multiple strings:");
            String input13 = sc.nextLine();
            System.out.println("Enter expression to split:");
            String  expression = sc.nextLine();
               try{
                System.out.println("String in the array"+Arrays.toString(str.encloseTheString(input13, expression)));
                }
                catch (CustomException e) {
                     e.printStackTrace();
                }                      
break;
case 16 :

        try {
            System.out.println("Merging Strings");
            System.out.println("Enter number of strings:");
            int num = sc.nextInt();
            sc.nextLine();
            String[] strings = new String[num];
            System.out.println("Enter the Strings:");
            for (int i = 0; i < num; i++) {
                strings[i]=sc.nextLine();
            }
            System.out.println("Enter the symbol to merge:");
            String symbol = sc.nextLine();
            System.out.println(str.mergeStrings( strings, symbol));
        }
         catch ( CustomException e) {
             e.printStackTrace();
        }          
break;
case 18:
 System.out.println("Case Sensitive Check");
        try {
            System.out.println("Enter first string:");
            String input16 = sc.nextLine();
            System.out.println("Enter second string:");
            String input17 = sc.nextLine();
            System.out.println("Are the strings equal? " + str.checkCaseSensitive(input16, input17));
        } 
        catch (CustomException e) {
              e.printStackTrace();
        }
break;
case 19:
	System.out.println("case insensitive ");
	try{
	System.out.println("Enter string:");
	String input18=sc.nextLine();
	System.out.println("Enter string:");
	String input19=sc.nextLine();
	System.out.println("Are the strings equal? " + str.checkCaseInSensitive(input18, input19));
	}
	catch( CustomException e){
   	  e.printStackTrace();
   	}
break;
case 20:
	try{
	System.out.println("Enter string:");
	String input20=sc.nextLine();
	System.out.println(str.removeExtraSpaces(input20));
	}
	catch(CustomException e){
   	  e.printStackTrace();
   	}
break;
default :
 	System.out.println("Not valid.Enter the number between 1 to 20");
}
    }
while (choice<=21 || choice>=1);
    }
    }
    
    
    
  
        
        
   

     

