package regextask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import custom.CustomException;
import util.Utility;

public class RegexTask {
	public <E> List <E>getArrayList() {
		return new ArrayList<>();
	}
public <E> void addElement(List<E> myArrayList,E input) throws CustomException {
	Utility.nullChecker(myArrayList);
	myArrayList.add(input);
	}
	
public boolean mobileNumberValidation(String number) throws CustomException  {
	Pattern pattern=Pattern.compile("^(0|91)?[7-9][0-9]{9}$");
	return getMatch(number,pattern);	
}
public boolean checkAlphaNumeric(String input) throws CustomException {
	Pattern pattern=Pattern.compile("^[\\w]+$");
	return getMatch(input,pattern);
	}
public boolean startsWith(String input,String match) throws CustomException {
	Pattern patternStart=Pattern.compile("^"+match);
	return getMatch(input,patternStart);
}
public boolean endsWith(String input,String match) throws CustomException {
	Pattern patternEnd=Pattern.compile(match+"$");
	return getMatch(input,patternEnd);
}
public boolean contains(String input,String match) throws CustomException {
	Pattern patternContains=Pattern.compile(match);
	return getMatch(input,patternContains);
}
public boolean equalsWithCaseSensitive(String input,String match) throws CustomException {
	Pattern patternEquals=Pattern.compile("^"+match+"$");
	return getMatch(input,patternEquals);
}

public boolean checkEquals(List<String> input,String match) throws CustomException {
	for(String inputs:input) {
	Pattern patternEquals=Pattern.compile("^"+match+"$",Pattern.CASE_INSENSITIVE);//Pattern.CASE_INSENSITIVE-?i
	boolean equals=getMatch(inputs,patternEquals);
	if(equals) {
		return true;
	}
	}
	return false;
	
}
public boolean emailValidation(String input) throws CustomException {
	Pattern pattern=Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
	return getMatch(input,pattern);	
}
public boolean checkRange(List<String> input) throws CustomException {
	 Pattern pattern = Pattern.compile("^.{1,6}$");
	 Utility.nullChecker(pattern);
	    for (String str : input) {
	        Matcher matcher = pattern.matcher(str);
	        if (!matcher.matches()) {
	            return false; 
	        }
	    }
	    return true;
	}
public Map<String,Integer> findMatcher(List<String> list1,List<String> list2) throws CustomException {
	/*Map<String,Integer> map=new HashMap<>();
	Utility.nullChecker(list1);
	for(String str:list2) {
		int index=list1.indexOf(str);
		if(index!=-1) {
			map.put(str,index);
		}
	}
	return map;*/
	Map<String, Integer> map = new HashMap<>();
    for (String str : list2) {
        String regex = "\\b" + str + "\\b"; 
        int size=Utility.findSize(list1);
        for (int i = 0; i < size; i++) {
        	boolean match=list1.get(i).matches(regex);
            if (match) {
                map.put(str, i);
                break; 
            }
        }
    }
    return map;
}
	
public List<String> printHtmlTag(String input) throws CustomException {
	 List<String> list=getArrayList();
	 // Pattern pattern = Pattern.compile("<[^>]*>");
	  Pattern pattern = Pattern.compile("(</?[a-z]*>)");
	  Utility.nullChecker(pattern);
	  Matcher matcher = pattern.matcher(input);
	  Utility.nullChecker(matcher);
	  while(matcher.find()) {
		  list.add(matcher.group());
	  }
	  return list;
}
public boolean passwordValidation(String input) throws CustomException {
	//Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).{8,}$");
	Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[^\\w])(?=.*[A-Z]).{8,}$");
	return getMatch(input,pattern);
}

public boolean getMatch(String input,Pattern pattern) throws CustomException {
	Utility.nullChecker(pattern);
	Matcher match= pattern.matcher(input);
	Utility.nullChecker(match);
	return match.find();
	}

}
