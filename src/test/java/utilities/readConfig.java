package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	Properties pro;
	File src;
	FileInputStream fis;
	
	public readConfig() 
	{
		pro=new Properties();
		try
		{
		src=new File("./configuration/config.properties");
		fis=new FileInputStream(src);
		pro.load(fis);
		}catch( Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getEmail()
	{
		String email=pro.getProperty("email");
		return email;
	}

	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getUrl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getChromePath()
	{
		String chromePath=pro.getProperty("chromePath");
		return chromePath;
	}
	public String getFirefoxPath()
	{
		String firefoxPath=pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	public String getIEPath()
	{
		String iePath=pro.getProperty("iePath");
		return iePath;
	}
}
