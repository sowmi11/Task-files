package programtestrunner;

public class BasicProgrammig {
	private String myString;
	private int intValue;
	public BasicProgrammig() {
	System.out.println("default constructor");	
	}
	public BasicProgrammig(String str,int value) {
	myString=str;
	intValue=value;
	System.out.println("overloaded constructor");	
	
	}
	
	public String toString() {
		if(intValue!=0) {
		return "my string is "+myString+"Int value is:"+intValue;
	}
		else {
			return "my string is "+myString;
		}
	}
	public BasicProgrammig(String str) {
	myString=str;	
		
	}

	public String getStringValue() {
		System.out.println("Get string value");
		return myString;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setStringValue(String str) {
		System.out.println("Set string value");
		myString=str;
	}
	public void setIntValue(int value) {
		intValue=value;
	}
}

