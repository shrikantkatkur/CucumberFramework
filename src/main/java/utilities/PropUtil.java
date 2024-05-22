package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class can be used to read properties file.It contains utility methods 
 * to read any properties file in different ways.
 */

public class PropUtil {
	private String filePath;
//created instance because we have to use prop.load(fis),if fis not inctance 
// we are not able to use prop.load(fis)
/**
 * This method can be used to get the value of a specified key
 * @param filePath-from which you want  to read value
 * @param Key-of which you need value
 * @return 
 * @throws IOException
 */
	public PropUtil(String LocatorFile) {//created "CONSTRUCTOR",so that we can pass filepath at the time object creation iniliakized
		filePath=LocatorFile;
	}
	public PropUtil() {
		
	}
public String getValues(String filePath,String Key) throws IOException {
	FileInputStream fis=null;
	try {
		fis=new FileInputStream(filePath);
	} catch (Exception e) {
		//Handling Code
	}
	Properties prop=new Properties();
	try {
		prop.load(fis);
	} catch (Exception e) {
		//Handling Code
	}
	String value=prop.getProperty(Key);
	return value;
	
 
//return prop.getProperty(Key); istead of line no 27 and 28
	}
public String getValues(String key)throws IOException {
	FileInputStream  fis=new FileInputStream(filePath);
	Properties prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	
}

}