package arraylist;

public class Person {
	private String name;
	private int age;
public Person(String personName,int personAge) {
	name=personName;
	age=personAge;
}
@Override
public String toString() {
	return "Name:"+name + "Age:"+age;
}
}
