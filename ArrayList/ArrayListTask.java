package arraylist;
//import java.util.ArrayList;
import custom.CustomException;
import util.Utility;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

//Coding to the interface - Java 

public class ArrayListTask<E> {
	public <E> List <E>getArrayList() throws CustomException {
		try {
		Class<?> arrayListClass=Class.forName("java.util.ArrayList");
		Constructor<?> constructor=arrayListClass.getDeclaredConstructor();
		return (List<E>) constructor.newInstance();
	}
	catch(ClassNotFoundException | NoSuchMethodException | InstantiationException 
			| IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
	throw new CustomException(e.getMessage(),e);
	}	
	}

	public <E> void addElement(List<E> myArrayList,E input) throws CustomException {
	Utility.nullChecker(myArrayList);
	myArrayList.add(input);
	}
	public <E> int findIndex(List<E> myArrayList,String input) throws CustomException{
		Utility.nullChecker(myArrayList);
		Utility.nullChecker(input);
		return myArrayList.indexOf(input);
		}
	public <E> Iterator<E> doIteration(List<E> myArrayList)throws CustomException{
		Utility.nullChecker(myArrayList);
		return myArrayList.iterator();
	}
	public <E> E findElement(List<E> myArrayList,int index) throws CustomException{
		int size=Utility.findSize(myArrayList);
		Utility.indexChecker(index,size);
		return myArrayList.get(index);
	}
	public <E> int lastIndex(List<E> myArrayList,E input) throws CustomException{
		Utility.nullChecker(myArrayList);
		return myArrayList.lastIndexOf(input);
	}
	public <E>void addString(List<E> myArrayList,E input,int index) throws CustomException{ 
		int size=Utility.findSize(myArrayList);
		Utility.indexChecker(index,size);
		myArrayList.add(index, input);
	}
	public <E> List<E> subArrayList(List<E> myArrayList,int index1,int index2)throws CustomException{
		Utility.nullChecker(myArrayList);
		Utility.indexChecker(index1,index2);
		return myArrayList.subList(index1, index2);
	}
	public <E> void addAllList(List<E> thirdArray,List<E> secondArray,List<E> firstArray)throws CustomException {
		Utility.nullChecker(secondArray);
		Utility.nullChecker(firstArray);
		thirdArray.addAll(secondArray);
		thirdArray.addAll(firstArray);
		}
	public <E> void removeElement(List<E> myArrayList,Object input) throws CustomException{
		Utility.nullChecker(myArrayList);
		myArrayList.remove(input);
	}
	public <E> void removeAllElement(List<E> arrayList1,List<E> arrayList2)  throws CustomException{
		Utility.nullChecker(arrayList1);
		Utility.nullChecker(arrayList2);
		arrayList1.removeAll(arrayList2);
	}
	public <E> void clearAll(List<E> myArrayList) throws CustomException{
		Utility.nullChecker(myArrayList);
		myArrayList.clear();
	}
	public <E> boolean checkStr(List<E> myArrayList,E input) throws CustomException{
		Utility.nullChecker(myArrayList);
		Utility.nullChecker(input);
		return myArrayList.contains(input);
	}
	
}
