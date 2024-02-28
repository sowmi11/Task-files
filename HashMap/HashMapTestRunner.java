package hashmaptest;
import java.util.Scanner;
import java.util.Set;
import hashMapTask.HashMapTask;
import util.Utility;
import custom.CustomException;
import java.util.Map;
public class HashMapTestRunner {
	public static void main(String...args) {
		HashMapTask task=new HashMapTask();
	Scanner sc=new Scanner(System.in);
	int choice;
	do {
		System.out.println("Enter the problem number between 1 to 19:");
		System.out.println("Enter the problem to be shown:");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			try {
			Map<Integer,String> map=task.getHashMap();
			System.out.println("The size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 2:
	try {
	Map<String,String> map=task.getHashMap();
	System.out.println("Enter the number of keys and values to map:");
	int num=sc.nextInt();
	sc.nextLine();
	for(int i=0;i<num;i++) {
	System.out.println("Enter key in words:");
	String key=sc.nextLine();
	System.out.println("Enter value in words:");
	String value=sc.nextLine();
	task.addElement(map,key,value);
	}
	System.out.println(map);
	}
	catch(CustomException e) {
		e.printStackTrace();
	}
	break;
		case 3:
			try {
				Map<Integer,Integer> map=task.getHashMap();
				System.out.println("Enter the number of keys and values to map:");
				int num=sc.nextInt();
				for(int i=0;i<num;i++) {
				System.out.println("Enter key in number:");
				int key=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter value in number:");
				int value=sc.nextInt();
				task.addElement(map,key,value);
				}
				System.out.println(map);
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
			break;
		case 4:
			try {
				Map<String,Integer> map=task.getHashMap();
				System.out.println("Enter the number of keys and values to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
				System.out.println("Enter key in string:");
				String key=sc.nextLine();
				System.out.println("Enter value in number:");
				int value=sc.nextInt();
				sc.nextLine();
				task.addElement(map,key,value);
				}
				System.out.println(map);
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 5:
			try {
				Map<String,Object> map=task.getHashMap();
				System.out.println("Enter the number of keys and values to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
				System.out.println("Enter key in string:");
				String key=sc.nextLine();
				System.out.println("Enter value :");
				String value=sc.nextLine();
				task.addElement(map,key,new CustomObject(value));
				}
				System.out.println(map);
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 6:
			try {
				Map<String,Object> map=task.getHashMap();
				System.out.println("Enter the number of keys  to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=1;i<=num;i++) {
				System.out.println("Enter key in string:");
				String key=sc.nextLine();
				System.out.println("Enter value in string:");
				String value=sc.nextLine();
				task.addElement(map,key,value);
				if(i==num) {
					String values=null;
					task.addElement(map, key,values );
				}
				}
				System.out.println(map);
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 7:
			try {
				Map<String,Object> map=task.getHashMap();
				System.out.println("Enter the number of values to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
				System.out.println("Enter values in string:");
				String value=sc.nextLine();
				task.addElement(map,null,value);
				}
				System.out.println(map);
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 8:
			try {
				Map<String,Object> map=task.getHashMap();
				System.out.println("Enter the number of keys and values to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
				System.out.println("Enter key in string:");
				String key=sc.nextLine();
				System.out.println("Enter value in number:");
				int value=sc.nextInt();
				sc.nextLine();
				task.addElement(map,key,value);
				}
				System.out.println(map);
				System.out.println("Enter the key to check:");
				String keyElement=sc.nextLine();
				System.out.println(task.containsElement(map, keyElement));
				
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 9:
			try {
				Map<String,Object> map=task.getHashMap();
				System.out.println("Enter the number of keys and values to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
				System.out.println("Enter key in string:");
				String key=sc.nextLine();
				System.out.println("Enter value in number:");
				int value=sc.nextInt();
				sc.nextLine();
				task.addElement(map,key,value);
				}
				System.out.println(map);
				System.out.println("Enter the value to check:");
				int valueElement=sc.nextInt();
				sc.nextLine();
				System.out.println(task.containElements(map, valueElement));
				
				}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 10:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter the number of keys and values to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
				System.out.println("Enter key :");
				int key=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter value in words:");
				String value=sc.nextLine();
				task.addElement(map,key,value);
				}
				System.out.println(map);
				Set<Integer> keys=task.getKeyElements(map);
				for(int key:keys) {
					System.out.println("Enter new value for key"+key+":");
					String value=sc.nextLine();
					task.addElement(map,key,value);
				}
				System.out.println(map);
			}
				catch(CustomException e) {
					e.printStackTrace();
				}
				break;
		case 11:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("Enter keys to search:");
				int keyToSearch=sc.nextInt();
				sc.nextLine();
				System.out.println("The value for entered key is:"+task.getValues(map,keyToSearch));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;

		case 12:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				System.out.println("Enter keys to search:");
				int keyToSearch=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter default values:");
				String defaultValue=sc.nextLine();
				System.out.println("The value for entered key is:"+task.getDefaultValues(map,keyToSearch,defaultValue));
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 13:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				System.out.println("Enter the existing key to remove:");
				int key=sc.nextInt();
				sc.nextLine();
				task.removeElements(map,key);
				System.out.println("The final map is:"+map);
				System.out.println("The final size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 14:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				System.out.println("Enter the existing key to remove:");
				int key=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter value to match:");
				String value=sc.nextLine();
				task.removeElements(map,key,value);
				System.out.println("The final map is:"+map);
				System.out.println("The final size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 15:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				System.out.println("Enter the key of value to replace:");
				int key=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the value to replace:");
				String value=sc.nextLine();
				task.replaceElements(map, key, value);
				System.out.println("The replaced map is"+map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 16:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				System.out.println("Enter the key of value to replace:");
				int key=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the value to match:");
				String oldValue=sc.nextLine();
				System.out.println("Enter the value to replace:");
				String newValue=sc.nextLine();
				task.replaceElements(map, key, oldValue,newValue);
				System.out.println("The replaced map is"+map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 17:
			try {
				Map<Integer,String> map1=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map1,keys,value);
					
				}
				System.out.println(map1);
				System.out.println("The size of HashMap is:"+Utility.findSize(map1));
				Map<Integer,String> map2=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num1=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num1;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map2,keys,value);
					
				}
				System.out.println(map2);
				System.out.println("The size of HashMap is:"+Utility.findSize(map2));
				task.addAllElement(map1, map2);
				System.out.println(map1);
				System.out.println("The size of HashMap is:"+Utility.findSize(map1));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 18:
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				task.clearElements(map);
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
		case 19 :
			try {
				Map<Integer,String> map=task.getHashMap();
				System.out.println("Enter number of key pairs to map:");
				int num=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<num;i++) {
					System.out.println("Enter keys:");
					int keys=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter value in words:");
					String value=sc.nextLine();
					task.addElement(map,keys,value);
					
				}
				System.out.println(map);
				System.out.println("The size of HashMap is:"+Utility.findSize(map));
				System.out.println("The set is:"+task.iterateElements(map));
			}
			catch(CustomException e) {
				e.printStackTrace();
			}
			break;
			
			default:
				System.out.println("Enter the correct number.");
			
			
		}
	}
		while(choice<=19|| choice>=1);
	sc.close();
}
}