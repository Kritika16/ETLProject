package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider() throws Exception{
		File src = new File("C:\\Kritika Study\\Workspace\\MavenETLProject\\Configuration\\config.properties");
		FileInputStream file = new FileInputStream(src);
		prop= new Properties();
		prop.load(file);
	}
	
	public String getPageURL(){
		String URL = prop.getProperty("URL");
		return URL;
	}
	
	public String getChromePath(){
		String ChromePath =  prop.getProperty("ChromeDriver");
		return ChromePath;
	}
	
	public String getExcelPath(){
		String ExcelPath = prop.getProperty("ExcelFile");
		return ExcelPath;
	}
}
