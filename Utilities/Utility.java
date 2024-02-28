package util;

import java.io.File;
import java.util.List;
import java.util.Map;

import custom.CustomException;

public class Utility {
	   public static int findLength(String inputString) throws CustomException
	     {
	     nullChecker(inputString);
	     return inputString.length();
	     }
    public static void nullChecker(Object obj) throws CustomException
	     {
	     if(obj==null ){
	     throw new CustomException("Input is null.Provide some values to th input");
	     }
	     }
	     
	       public static void indexChecker(int index,int length)  throws CustomException
	     {
	     if (index < 0 || length<= index) 
	    	    {
	    	     
	    		throw new  CustomException("The index is either negative number or index is greater than length of the input.Give correct index");
	    	    }
	     }
	       public static void fileChecker(File file) throws CustomException{
	    	   if(file==null || !file.exists()) {
	    		   throw new CustomException("File not found !!!");  
	    	   }
	       }
	    	public static <E> int findSize(List<E> input ) throws CustomException{
	     		nullChecker(input);
	       		return input.size();
	       		}
	    	public static <K,V> int findSize(Map<K,V> input) throws CustomException{
	    		nullChecker(input);
	    		return input.size();
	    	}
	    	

}
