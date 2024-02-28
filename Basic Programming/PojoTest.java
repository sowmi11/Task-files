package programtestrunner;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class PojoTest {
public static void main(String...args) throws Exception{
	Class<?> clazz=Class.forName("programtestrunner.BasicProgrammig");
	Constructor<?> defaultConstructor=clazz.getDeclaredConstructor();
	Object instance1=defaultConstructor.newInstance();
	Constructor<?> overLoadedConstructor=clazz.getDeclaredConstructor(String.class,int.class);
	Object instance2=overLoadedConstructor.newInstance("Hello",23);
	Method getterMethod=clazz.getMethod("getStringValue");
	getterMethod.invoke( instance1);
	Method setterMethod=clazz.getMethod("setStringValue",String.class);
	setterMethod.invoke(instance2,"hello");
}
}

