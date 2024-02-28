package hashMapTask;
import custom.CustomException;
import java.util.Set;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
import java.util.Map;
import util.Utility;
public class HashMapTask {
	@SuppressWarnings("unchecked")
	public <K, V> Map<K,V> getHashMap() throws CustomException{
		try {
		Class<?> mapClass=Class.forName("java.util.HashMap");
		Constructor<?> constructor=mapClass.getDeclaredConstructor();
		return (Map<K,V>) constructor.newInstance();
		}
		catch(ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
		throw new CustomException(e.getMessage(),e);
		}
	}
	public <K, V>void  addElement(Map<K, V> map,K key,V value) throws CustomException{
		Utility.nullChecker(map);
		map.put(key, value);
	}
	public <K, V>boolean containsElement(Map<K, V> map,K key) throws CustomException{
		Utility.nullChecker(map);
		return map.containsKey(key);
	}
	public <K, V>boolean containElements(Map<K, V> map,V value) throws CustomException{
		Utility.nullChecker(map);
		return map.containsValue(value);
	}
	public <K, V> Set<K> getKeyElements(Map<K, V> map) throws CustomException{
		Utility.nullChecker(map);
		return map.keySet();
	}
	public <K, V> V getValues(Map<K, V> map,K keyToSearch) throws CustomException{
		Utility.nullChecker(map);
	 return	map.get(keyToSearch);
	}
	public <K, V> V getDefaultValues(Map<K, V> map,K keyToSearch,V defaultValue) throws CustomException{
		Utility.nullChecker(map);
	 return	map.getOrDefault(keyToSearch, defaultValue);
	}
	public <K, V> V removeElements(Map<K, V> map,K key) throws CustomException{
		Utility.nullChecker(map);
	 return	map.remove(key);
	}
	public <K, V> void removeElements(Map<K, V> map,K key,V value) throws CustomException{
		Utility.nullChecker(map);
	map.remove(key, value);
	}
	public <K, V> V replaceElements(Map<K, V> map,K key,V value) throws CustomException{
		Utility.nullChecker(map);
	 return	map.replace(key, value);
	}
	public <K, V> void replaceElements(Map<K, V> map,K key,V oldValue,V newValue) throws CustomException{
		Utility.nullChecker(map);
	 map.replace(key, oldValue, newValue);
	}
	public <K, V>void  addAllElement(Map<K, V> map1,Map<K, V> map2) throws CustomException{
		Utility.nullChecker(map1);
		Utility.nullChecker(map2);
		map1.putAll(map2);
	}
	public <K, V> Set<Map.Entry<K,V>>  iterateElements(Map<K, V> map) throws CustomException{
		Utility.nullChecker(map);
		return map.entrySet();
	}
	
	public <K, V>void  clearElements(Map<K, V> map) throws CustomException{
		Utility.nullChecker(map);
		map.clear();
	}
	
}
