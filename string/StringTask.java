package str;
public class StringTask{

public int lenStr(String[] abc){
	int length=0;
	String inputString=abc[0];
	int len=inputString.length();
	for(int i=0; i<len;i++){
	length++;
        }
	return length;
   }
public  char[] StringToCharArray(String name){
 
	return name.toCharArray();
	
   }
public  char findPenultimate(int inputStr,String inputStri) {
            char characterAtIndex = inputStri.charAt(inputStr);
            return characterAtIndex;
        }
public  int countOccurrences(String inputString, char occurenceLetter) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == occurenceLetter) {
                count++;
            }
        }

        return count;
    }  
 public  int findGreatestPosition(String inputString, char targetChar) {
        int greatestPos = -1;
        int len= inputString.length();
        for (int i = 0; i < len; i++) {
            if (inputString.charAt(i) == targetChar) {
                greatestPos = i;
            }
        }

        return greatestPos;
    } 
public  String charactersFromLast(String inputString,int numberOFCharacters){
	int length=inputString.length();
        if (length >= numberOFCharacters) {
                       String chars = inputString.substring(length-numberOFCharacters) ;
           return chars;   
    }     
   return "invalid input " ;
   } 
  
public  String charactersFromFirst(String inputString,int numberOFCharacters){
  	 int x=inputString.length();
   	if ( x >= numberOFCharacters) {
           String charactersFirst = inputString.substring(0,numberOFCharacters) ;  
           return charactersFirst;
    }      
    return "invalid input "; 
   }  
public  String replaceCharacters(String inputString,int replaceCount,String replacement){
     String replacedString = replacement + inputString.substring(replaceCount);
    return replacedString;
 }
public  boolean beginsWithWord(String inputString,String letterToCheck){
    return inputString.startsWith(letterToCheck);
}
public  boolean endsWithWord(String inputString,String checkLetter){
    return inputString.endsWith(checkLetter);
}
public  String lowerCase(String inputString){
    return inputString.toLowerCase();
}
public  String upperCase(String inputString){
    return inputString.toUpperCase();
}
public  String reverseString(String inputString) {
        StringBuilder reversed = new StringBuilder(inputString);
        
       	StringBuilder reverseStr = reversed.reverse();
        
        return reverseStr.toString();
    }
public String[] concatenateWithoutDelimiters(String inputString, String delimiter) { 
   
     return inputString.split(delimiter);
   
}
    
public  String[]  encloseTheString(String inputString,String regex){
         
      return  inputString.split(regex);
            }
public  String mergedString(int num,String[] inputString,String mergeSymbol){
          if(num<=0 ||inputString== null ||inputString.length==0){
          return " ";
          }
           String merged=inputString[0];
           for(int i=1;i<num;i++){
           merged= merged.concat(mergeSymbol).concat(inputString[i]);
       
     } 
     return merged;
     }
public  boolean checkCaseSensitive(String str1, String str2) {
        return str1.equals(str2);
    } 
public  boolean checkCaseInSensitive(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);       
    } 
public  String removeExtraSpaces(String inputString) {
        return inputString.trim();   
    }
    }
    
    
    
    
    


        
       
  
