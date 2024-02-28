package programtask;
import custom.CustomException;
import java.time.*;
import util.Utility;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
public class BasicProgrammigTask {
public <E> List <E>getArrayList() {
			return new ArrayList<>();
		}
public <E> void addElement(List<E> myArrayList,E input) throws CustomException {
		Utility.nullChecker(myArrayList);
		myArrayList.add(input);
		}

public File getfile(String directoryName,String fileName) throws IOException,CustomException{
	File file=new  File(directoryName,fileName);
	file.createNewFile();
	Utility.fileChecker(file);
	return file;
}
public Properties getProperties() throws IOException{
	return new Properties();
}
public void writeFile(File file, List<String> myList) throws IOException, CustomException {
	Utility.fileChecker(file);
	Utility.nullChecker(myList);
   try( BufferedWriter  writer=new BufferedWriter(new FileWriter(file))){
    for (String item : myList) {
        writer.write(item);
        writer.newLine(); 
    }
}
}

public  void addProperty(Properties property,String[] key,String[] value,int length) throws CustomException{
	Utility.nullChecker(property);
	Utility.nullChecker(value);
	Utility.nullChecker(key);
    for (int i = 0; i <length; i++) {
        property.setProperty(key[i], value[i]);
    }
}

public void storeToFile(Properties property,String fileName,File directory) throws IOException,CustomException{
	try(FileOutputStream fos=new FileOutputStream(directory)){
	Utility.nullChecker(property);
	 property.store(fos, fileName);
	}	 
}

public void loadPropertiesFromFile(Properties property,File directory)throws IOException,CustomException{
	try(FileInputStream fis=new FileInputStream(directory)){
	Utility.nullChecker(property);
	property.load(fis);
}
}
public boolean createDirectory(String directoryName) throws IOException,CustomException{
	File directory=new File(directoryName);
	Utility.fileChecker(directory);
	return directory.mkdirs();
	}

public LocalDateTime printCurrentTime() {
	return LocalDateTime.now();
}
public long printCurrentTimeMillis() {
	return System.currentTimeMillis();
}
public ZoneId getId(String name) {
	return ZoneId.of(name);
}
public ZonedDateTime getZonedDateTime(ZoneId zone) {
	return ZonedDateTime.now(zone);
}

public String getWeekDay(ZonedDateTime zonedDateTime) {
    return zonedDateTime.getDayOfWeek().toString();
}
public String getMonth(ZonedDateTime zonedDateTime) {
    return zonedDateTime.getMonth().toString();
}
public int getYear(ZonedDateTime zonedDateTime) {
    return zonedDateTime.getYear();
}
}
