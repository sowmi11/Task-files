package programtestrunner;
import java.io.File;
import java.time.*;
import custom.CustomException;

import java.util.List;
import java.util.Properties;
import programtask.BasicProgrammigTask;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BasicProgrammingTest {
	public static void main(String...args) {
		 Logger logger=Logger.getLogger(BasicProgrammingTest.class.getName());
		Scanner sc=new Scanner(System.in);
		BasicProgrammigTask  task=new BasicProgrammigTask();
		BasicProgrammig  tasks=new BasicProgrammig();
		int choice;
		do {
			logger.log(Level.INFO,"Enter the problem between 1 to 12:");
			logger.log(Level.INFO,"Enter the problem number to be shown:");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			try {
	
			logger.log(Level.INFO,"Enter file name:");
			String fileName=sc.nextLine();
			String currentDirectory=System.getProperty("user.dir");
			File file=task.getfile(currentDirectory,fileName);
			logger.log(Level.INFO,"File created"+file);
				List<String> myArr=task.getArrayList();
				logger.log(Level.INFO,"Enter number of lines to add:");
				int number=sc.nextInt();
				sc.nextLine();
				for(int i=1 ;i<=number;i++) {
					logger.log(Level.INFO,"Enter line"+ i+ ":");
					String added=sc.nextLine();
					task.addElement(myArr, added);
					}
			task.writeFile(file,myArr);
			
			}
			catch(IOException|CustomException e) {
				logger.log(Level.SEVERE,"An error occured",e);
			}
			break;
		case 2:
			  try {
				  logger.log(Level.INFO,"Enter the number of keys and values :");
			int num=sc.nextInt();
			sc.nextLine();
			String[] key=new String[num];
			String[] value=new String[num];
			for (int i = 0; i < num; i++) {
				logger.log(Level.INFO,"Enter key " + (i + 1) + ":");
                key[i] = sc.nextLine();

                logger.log(Level.INFO,"Enter value for " + key[i] + ":");
                value[i] = sc.nextLine();
            }
			Properties properties=task.getProperties();
			  task.addProperty(properties,key,value,num);
			  logger.log(Level.INFO,"Properties"+properties);			
			  logger.log(Level.INFO,"Enter file name to store files:");
				String fileName=sc.nextLine();
				String currentDirectory=System.getProperty("user.dir");
				File file=task.getfile(currentDirectory,fileName);
				logger.log(Level.INFO,"File created"+file);

				task.storeToFile(properties,fileName,file);
			  }
			
				catch(IOException|CustomException e) {
					logger.log(Level.SEVERE,"An error occured",e);
				}
			
			  break;
		case 3:
			
			try {
				Properties properties1=task.getProperties();
				logger.log(Level.INFO,"Enter file name to read:");
				String fileName=sc.nextLine();
				String currentDirectory=System.getProperty("user.dir");
				File file=task.getfile(currentDirectory,fileName);
				task.loadPropertiesFromFile(properties1,file);
				logger.log(Level.INFO,"The values read from file is"+properties1);
			}
			catch(IOException|CustomException e) {
				logger.log(Level.SEVERE,"An error occured",e);
			}
			break;
		case 4:
			try {
				logger.log(Level.INFO,"Enter the directory:");
				String directoryName=sc.nextLine();
				logger.log(Level.INFO,"Directory created"+task.createDirectory(directoryName));
				logger.log(Level.INFO,"Enter the number of files:");
				int number=sc.nextInt();
				sc.nextLine();
				for(int i=1;i<=number;i++) {
					logger.log(Level.INFO,"Enter file name"+i+":");
				String fileName=sc.nextLine();
				File file=task.getfile(directoryName,fileName);
				logger.log(Level.INFO,"File created"+file);
				}
				logger.log(Level.INFO,"Enter file name:");
				String fileName=sc.nextLine();
				File file=task.getfile(directoryName,fileName);

					List<String> myArr=task.getArrayList();
					logger.log(Level.INFO,"Enter number of lines to add:");
					int num=sc.nextInt();
					sc.nextLine();
					for(int i=1 ;i<=num;i++) {
						logger.log(Level.INFO,"Enter line"+ i+ ":");
						String added=sc.nextLine();
						task.addElement(myArr, added);
						}
				task.writeFile(file,myArr);
				logger.log(Level.INFO,"Enter the number of keys and values :");
				int num1=sc.nextInt();
				sc.nextLine();
				String[] key=new String[num1];
				String[] value=new String[num1];
				for (int i = 0; i < num1; i++) {
					logger.log(Level.INFO,"Enter key " + (i + 1) + ":");
	                key[i] = sc.nextLine();

	                logger.log(Level.INFO,"Enter value for " + key[i] + ":");
	                value[i] = sc.nextLine();
	            }
				  logger.log(Level.INFO,"Enter file name to store files:");
					String fileName2=sc.nextLine();
					File file2=task.getfile(directoryName,fileName2);
				Properties properties=task.getProperties();
				  task.addProperty(properties,key,value,num1);
				  logger.log(Level.INFO,"Properties"+properties);			
					task.storeToFile(properties,fileName2,file2);
					
						logger.log(Level.INFO,"Enter file name to read:");
						String fileName3=sc.nextLine();
						File file3=task.getfile(directoryName,fileName3);
						task.loadPropertiesFromFile(properties, file3);
						logger.log(Level.INFO,"The values read from file is"+properties);
					}

			catch(IOException|CustomException e) {
				logger.log(Level.SEVERE,"An error occured",e);
			}

			
		case 5:
			logger.log(Level.INFO,"Enter string in the constructor:");
			String str=sc.nextLine();
			BasicProgrammig task1=new BasicProgrammig(str);
			logger.log(Level.INFO,"Task:"+tasks);
			logger.log(Level.INFO,"Task1:"+task1);
			break;
		case 6:
			logger.log(Level.INFO,"Enter string variable :");
			String string=sc.nextLine();
			logger.log(Level.INFO,"Enter int values :");
			int values=sc.nextInt();
			sc.nextLine();
			BasicProgrammig  task2=new BasicProgrammig(string,values);
			logger.log(Level.INFO,"The pojo class contains:"+task2);
			break;
		case 7:
			logger.log(Level.INFO,"Enter string variable :");
			String string1=sc.nextLine();
			logger.log(Level.INFO,"Enter int values :");
			int values1=sc.nextInt();
			sc.nextLine();
			tasks.setStringValue(string1);
			tasks.setIntValue(values1);
			logger.log(Level.INFO,"String value:"+tasks.getStringValue());
			logger.log(Level.INFO,"Int value:"+tasks.getIntValue());
			break;
		case 8:
			programtask.RainbowColour colors []= programtask.RainbowColour.getValues();
			for( programtask.RainbowColour color:colors){
				logger.log(Level.INFO,"color code of "+color+" is:"+color.getColorCode());
				logger.log(Level.INFO,"Ordinal of "+color+" is:"+color.ordinal());
			}
			break;
		case 9:
			EagerSingleton single1 = EagerSingleton.getInstance();
			 EagerSingleton single2 = EagerSingleton.getInstance();
		        Singleton enum1 = Singleton.INSTANCE;
		        Singleton enum2  = Singleton.INSTANCE;
		        Singleton enum3 = Singleton.INSTANCE;
		        DoubleCheckedLocking dcl1=DoubleCheckedLocking.getInstance();
		        DoubleCheckedLocking dcl2=DoubleCheckedLocking.getInstance();
		        DoubleCheckedLocking dcl3=DoubleCheckedLocking.getInstance();
		        BillPughSingleton singleton1 = BillPughSingleton.getInstance();
		        BillPughSingleton singleton2= BillPughSingleton.getInstance();
		        logger.log(Level.INFO,"Hashcode of cs is "+ single1.hashCode());
		        logger.log(Level.INFO,"Hashcode of cs is "+ single2.hashCode());
		        logger.log(Level.INFO,"Hashcode of x is " + enum1.hashCode());
		        logger.log(Level.INFO,"Hashcode of y is "+ enum2.hashCode());
		        logger.log(Level.INFO,"Hashcode of z is "+ enum3.hashCode());
		        logger.log(Level.INFO,"Hashcode of a is " + dcl1.hashCode());
		        logger.log(Level.INFO,"Hashcode of b is "+ dcl2.hashCode());
		        logger.log(Level.INFO,"Hashcode of cs is "+ dcl3.hashCode());
		        logger.log(Level.INFO,"Hashcode of cs is "+ singleton1.hashCode());
		        logger.log(Level.INFO,"Hashcode of cs is "+ singleton2.hashCode());
		         break;
		case 10:
			LocalDateTime currentTime=task.printCurrentTime();
			logger.log(Level.INFO,"current time is:"+currentTime);
			long currentTimeMillis=task.printCurrentTimeMillis();
			logger.log(Level.INFO,"The current time in millis:"+currentTimeMillis);
			logger.log(Level.INFO,"Enter the number of zones:");
			int number=sc.nextInt();
			sc.nextLine();
			  Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		        for (String zoneId : zoneIds) {
		            System.out.println(zoneId);
		        }
			for(int i=1;i<=number;i++) {
				logger.log(Level.INFO,"Enter zone:");
			String zone=sc.nextLine();
			ZoneId id=task.getId(zone);			
			logger.log(Level.INFO,"zonedate"+task.getZonedDateTime(id));
			}
			logger.log(Level.INFO,"Enter zone to get week,month,year:");
			String zone=sc.nextLine();
			ZoneId id=task.getId(zone);	
			ZonedDateTime zoneDate=task.getZonedDateTime(id);
			logger.log(Level.INFO,"Week day for current time: " + task.getWeekDay(zoneDate));
			logger.log(Level.INFO,"Month for current time: " + task.getMonth(zoneDate));
			logger.log(Level.INFO,"year for current time: " + task.getYear(zoneDate));
			break;
	}
		}
		while(choice<=12 ||choice>=1);
		sc.close();
}
}
