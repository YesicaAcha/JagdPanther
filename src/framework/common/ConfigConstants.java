package framework.common;

import framework.utils.readers.XmlReader;


public class ConfigConstants {
	static XmlReader xmlReader = new XmlReader();
	
	/**
	 * Framework configuration Data
	 */
	public static final String BROWSER = xmlReader.getData("frameworkinformation","browser");
	public static final String CHROMEDRIVER_PATH = System.getProperty("user.dir") 
			+ xmlReader.getData("frameworkinformation","chromedriverpath");
	public static final String IEDRIVER_PATH = System.getProperty("user.dir") 
			+ xmlReader.getData("frameworkinformation","iedriverpath");
	public static final String URL = xmlReader.getData("frameworkinformation","url");
	public static final String USER_MAIL = xmlReader.getData("frameworkinformation","usermail");
	public static final String PASSWORD = xmlReader.getData("frameworkinformation","password");
	public static final String EXTERNAL_DATA_PATH = System.getProperty("user.dir") 
			+ xmlReader.getData("frameworkinformation","externaldatapath");
	public static final String DATA_PROVIDER_FILE =  xmlReader.getData("frameworkinformation","dataproviderfile");
	public static final String EXTERNAL_DATA_FILE =  xmlReader.getData("frameworkinformation","externaldatafile");
	
	/**
	 * Framework configuration file
	 */
	public static final String DB_URL = xmlReader.getData("dbinformation","dburl");
	public static final String DB_USER = xmlReader.getData("dbinformation","dbuser");
	public static final String DB_PASSWORD = xmlReader.getData("dbinformation","dbpassword");
}