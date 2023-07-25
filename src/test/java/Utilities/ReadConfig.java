package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String returnURL(String environment)
	{
		return pro.getProperty("URL_"+environment);
	}
	
	public String returnUsername(String environment)
	{
		return pro.getProperty("Username_"+environment);
	}
	
	public String returnPassword(String environment)
	{
		return pro.getProperty("Password_"+environment);
	}

}
