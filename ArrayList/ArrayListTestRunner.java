package arraylisttest;
import custom.CustomException;
import java.util.List;
import util.Utility;
import arraylist.ArrayListTask;
import arraylist.Person;
import java.util.Scanner;
public class ArrayListTestRunner {
	public static void main(String...args) {
	ArrayListTask task=new ArrayListTask();
	Scanner sc=new Scanner(System.in);
	
	int choice;
	do 
	{
		System.out.println("The entered number should be between  1 to 16");
		System.out.println("Enter the  problem to be shown");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1 : 
		try {
		List<Object> myArray=task.getArrayList();
		System.out.println("Size of arraylist is: "+Utility.findSize(myArray));
		}
		catch (CustomException e) {
	        e.printStackTrace();
	        }
		break;
		case 2:
			try {
				List<String> myArr=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int number=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=number;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArr, added);
				}
			System.out.println("The array list is :"+myArr);
			System.out.println("The arrayList size is:"+Utility.findSize(myArr));
			}
			catch (CustomException  e) {
		        e.printStackTrace();
		        }
			break;
		case 3:
			try {
			List<Number> arrayList=task.getArrayList();
			System.out.println("Enter number of numbers to add:");
			int num=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter numbers to add:");
			for(int i=1 ;i<=num;i++) {
				System.out.println("Enter number"+ i+ ":");
				int added=sc.nextInt();
				sc.nextLine();
				task.addElement(arrayList, added);
				}
			System.out.println("The array list is :"+arrayList);
			System.out.println("The arrayList size is:"+Utility.findSize(arrayList));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 4:
			try {
			List<Object> list=task.getArrayList();
			System.out.println("Enter number of persons to add:");
			int person=sc.nextInt();
			sc.nextLine();
			for(int i=1;i<=person;i++) {
				System.out.println("Enter name of person:");
				String name=sc.nextLine();
				System.out.println("Enter age of person:");
				int age=sc.nextInt();
				task.addElement(list,new Person(name,age));
			}
			System.out.println("The array list is :"+list);
			System.out.println("The arrayList size is:"+Utility.findSize(list));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 5:
			try {
			List<Object> obj=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int numbers=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=numbers;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(obj, added);
				}
			System.out.println("Enter numbers to add:");
			for(int i=1 ;i<=numbers;i++) {
				System.out.println("Enter number"+ i+ ":");
				int added=sc.nextInt();
				sc.nextLine();
				task.addElement(obj, added);
				}
			for(int i=1;i<=numbers;i++) {
				System.out.println("Enter name of person:");
				String name=sc.nextLine();
				System.out.println("Enter age of person:");
				int age=sc.nextInt();
				task.addElement(obj,new Person(name,age));
			}
			System.out.println("The array list is :"+obj);
			System.out.println("The arrayList size is:"+Utility.findSize(obj));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 6:
			try {
			List<String> myArrays=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int no=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=no;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArrays, added);
				}
			System.out.println("Enter the String to know its index");
			String index=sc.nextLine();
			System.out.println("The array list is :"+myArrays);
			System.out.println("The index of typed string is :"+task.findIndex(myArrays, index));
			System.out.println("The arrayList size is:"+Utility.findSize(myArrays));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 7:
			try {
			List<String> myArray1=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num1=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num1;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray1, added);
				}
			System.out.println("The array list is :"+myArray1);
			System.out.println("The iteration list is");
			task.doIteration(myArray1);
			for(Object element : myArray1) {
				System.out.println(element);
			}
			}
			catch (CustomException  e) {
		        e.printStackTrace();
		        }
			break;
		case 8 :
			try {
			List<String> myArray2=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num2=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num2;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray2, added);
				}
			System.out.println("Enter index of string to dispaly:");
			int index1=sc.nextInt();
			System.out.println("The string at entered index is:"+task.findElement(myArray2, index1));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 9:
			try {
			List<String> myArray3=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num3=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num3;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray3, added);
				}
			System.out.println("The array list is :"+myArray3);
			System.out.println("Enter the String to know its index");
			String index3=sc.nextLine();
			System.out.println("The index of typed string first position is :"+task.findIndex(myArray3, index3));
			System.out.println("The index of typed string last position is :"+task.lastIndex(myArray3, index3));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 10:
			try {
			List<String> myArray4=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num4=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num4;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray4, added);
				}
			System.out.println("The array list is :"+myArray4);
			System.out.println("Enter strings to add:");
			String stringToAdd=sc.nextLine();
			System.out.println("Enter the position to add string");
			int position=sc.nextInt();
			//position=position-1;
			task.addString(myArray4, stringToAdd, position);
			System.out.println("Final arraylist is:"+ myArray4);
			System.out.println("The arrayList size is:"+Utility.findSize(myArray4));
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 11:
			try {
			List<String> myArray5=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num5=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num5;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray5, added);
				}
			System.out.println("The array list is :"+myArray5);
			List<String> myArray6=task.getArrayList();
			System.out.println("Enter the started string:");
			String started =sc.nextLine();
			System.out.println("Enter the ended String:");
			String end=sc.nextLine();
			int index4=task.findIndex(myArray5, started);
			System.out.println(index4);
			int index5=task.findIndex(myArray5, end);
			System.out.println(index5);
			myArray6=task.subArrayList(myArray5, index4, index5);
			System.out.println("The sub arraylist is:"+ myArray6);
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
			break;
		case 12:
			try {
			List<String> myArray7=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num6=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num6;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray7, added);
				}
			System.out.println("The first array list is :"+myArray7);
			List<String> myArray8=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int num7=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=num7;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(myArray8, added);
				}
			System.out.println("The second array list is :"+myArray8);
			List<String> myArray9=task.getArrayList();
			task.addAllList(myArray9, myArray8,myArray7);
			System.out.println("Third Arraylist is:"+myArray9);
			System.out.println("The arrayList size is:"+Utility.findSize(myArray9));
			}
			catch (CustomException  e) {
		        e.printStackTrace();
		        }
			break;
		case 13:
			try {
			List<Object> arrayList1=task.getArrayList();
			System.out.println("Enter number of numbers to add:");
			int number1=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter numbers to add:");
			for(int i=1 ;i<=number1;i++) {
				System.out.println("Enter number"+ i+ ":");
				float added=sc.nextFloat();
				sc.nextLine();
				task.addElement(arrayList1, added);
				}
			System.out.println("The array list is :"+arrayList1);
			System.out.println("Enter number to remove:");
			Object removeNum= sc.nextFloat();
			task.removeElement(arrayList1,removeNum);
			System.out.println("The array list is :"+arrayList1);
			System.out.println("The arrayList size is:"+Utility.findSize(arrayList1));
			}
			catch (CustomException  e) {
		        e.printStackTrace();
		        }
			break;
		case 14:
			try {
			List<String> arrayList2=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int number2=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=number2;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(arrayList2, added);
				}
			System.out.println("The first array list is :"+arrayList2);
			List<String> arrayList3=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int number3=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=number3;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(arrayList3, added);
				}
			System.out.println("The second array list is :"+arrayList3);
			task.removeAllElement(arrayList2,arrayList3);
			System.out.println("The first array list is :"+arrayList2);
			System.out.println("The second array list is :"+arrayList3);
			}
			catch (CustomException  e) {
		        e.printStackTrace();
		        }
			break;
		case 15:
			try{
				List<Number> arrayList5=task.getArrayList();
			System.out.println("Enter number of numbers to add:");
			int number5=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter numbers to add:");
			for(int i=1 ;i<=number5;i++) {
				System.out.println("Enter number"+ i+ ":");
				long added=sc.nextLong();
				task.addElement(arrayList5, added);
				}
			System.out.println("The array list is :"+arrayList5);
			task.clearAll(arrayList5);
			System.out.println("The array list is :"+arrayList5);
			System.out.println("The arrayList size is:"+Utility.findSize(arrayList5));
			}
			catch (CustomException  e) {
		        e.printStackTrace();
		        }
			break;
		case 16:
			try {
			List<String> arrayList6=task.getArrayList();
			System.out.println("Enter number of strings to add:");
			int number4=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter strings to add:");
			for(int i=1 ;i<=number4;i++) {
				System.out.println("Enter string"+ i+ ":");
				String added=sc.nextLine();
				task.addElement(arrayList6, added);
				}
			System.out.println("Enter the string to check");
			String str=sc.nextLine();
			System.out.println(task.checkStr(arrayList6,str));
			System.out.println("The first array list is :"+arrayList6);
			}
			catch (CustomException e) {
		        e.printStackTrace();
		        }
		}
	}while (choice<=19 || choice>=1); 
	sc.close();
	}
	
}
