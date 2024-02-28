package  sbtask;
import util.Utility;
import custom.CustomException;

public class StringBuilderTask {

public StringBuilder addString(StringBuilder strBuilder ,String str)throws CustomException{

	Utility.nullChecker(strBuilder);
        return  strBuilder.append(str);
       }
	            
public StringBuilder insertString(String seperator,StringBuilder stringBuilder,String stringToInsert)throws CustomException  {

	Utility.nullChecker(stringBuilder);
	Utility.nullChecker(seperator);
	if (stringBuilder.indexOf(seperator) ==-1){
	throw new CustomException("Separtor is missing in the input String !!");
	}
	return stringBuilder.insert(stringBuilder.indexOf(seperator),stringToInsert);
	} 	     
public StringBuilder deleteString(StringBuilder strBuilder,String stringToDelete )throws CustomException{

       Utility.nullChecker(strBuilder);
        Utility.nullChecker(stringToDelete);
       int  startIndex=strBuilder.indexOf(stringToDelete); 
       if(startIndex==-1){
       throw new CustomException("Separtor is missing in the input String !!");
       }
       int endIndex=startIndex+Utility.findLength(stringToDelete);
       return strBuilder.delete(startIndex,endIndex);
      }      
public StringBuilder replaceString(StringBuilder strBuilder,String seperator,String replacement)throws CustomException{
	Utility.nullChecker(strBuilder);
	int startIndex=strBuilder.indexOf(seperator);
	if(startIndex==-1){
	   throw new CustomException("Separtor is missing in the input String !!");
	}
	int endIndex=Utility.findLength(seperator);
	int len=Utility.findLength(replacement);
	while(startIndex !=-1){
	strBuilder.replace(startIndex,startIndex +endIndex, replacement);
        startIndex = strBuilder.indexOf(seperator, startIndex + len);
	}
	return strBuilder;
     }
public StringBuilder reverseString(StringBuilder strBuilder)throws CustomException{

	Utility.nullChecker(strBuilder);
	return strBuilder.reverse();      
       }            	
public int findIndex(String seperator,StringBuilder strBuilder)throws CustomException{
	
	Utility.nullChecker(strBuilder);
	return  strBuilder.indexOf(seperator);
	}
public int findLastIndex(String seperator,StringBuilder strBuilder)throws CustomException{
	
	Utility.nullChecker(strBuilder);
	return strBuilder.lastIndexOf(seperator);
	}
public StringBuilder getStringBuilder(String inputString)throws CustomException{

	Utility.nullChecker(inputString);
	return new StringBuilder(inputString);
	}
public StringBuilder getStringBuilder(){

	return new StringBuilder();	
	}
	}
