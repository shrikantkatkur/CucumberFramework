package utilities;

import java.io.IOException;

public class Config  {
		
	//to reduce duplicate code,we need to extract method.give the name readProperty
		//and make necessary changes,so that no need to write same code for every property
			
		private String readProperty(String property)  {
			String basedir=System.getProperty("user.dir");
			PropUtil prop=new PropUtil(basedir+"./src/main/resources/config.properties");
			String value=null;
			try{
				value=prop.getValues(property);
			}catch(IOException e) {
			}
			return value;
		}
		
		public String getBrowserName() {
			return readProperty("browser_name");
		}
		public String getAppUrl() {
			return readProperty("app_url");
		}
		public String getUserName() {
			return readProperty("userName");
		}
		public String getPassword() {
			return readProperty("password");
		}

	}



