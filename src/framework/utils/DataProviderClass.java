package framework.utils;

import java.io.IOException;

import jxl.JXLException;

import org.testng.annotations.DataProvider;

import framework.common.ConfigConstants;
import framework.utils.readers.JXLExcelReader;

/**
 * DataProviders for JagdPanher tests
 * @author Yesica Acha
 *
 */
public class DataProviderClass {
	
	/**
	 * This method return an Object with data to create Programs
	 * @return
	 */
	@DataProvider(name = "ProgramCreation")
	public static Object[][] programData() {
		return new Object[][] {{"ProgramName2A","ProgramTitle2","ProgramDescription2"},
							   {"ProgramName3A","ProgramTitle3","ProgramDescription3"}};
	}
	
	/**
	 * This method return an Object with data to create Users
	 * @return
	 */
	@DataProvider(name = "UserData")
	public static Object[][] userData() {
		return new Object[][] {{"98764554","Carlos","Guevara","carlos@guevara.com"},
							   {"98464531","Eliana","Navia","eliana@navia.com"}};
	}
	
	/**
	 * This method return an Object with data to create Stages
	 * @return
	 * @throws IOException
	 * @throws JXLException 
	 */
	@DataProvider(name = "StageDataXlsx")
	public static Object[][] stageData() throws IOException, JXLException {
		
		//Prepare the path of excel file
		String filePath = ConfigConstants.EXTERNAL_DATA_PATH;
				
		//Create a object of ReadGuru99ExcelFile class
		JXLExcelReader excelFile = new JXLExcelReader(filePath, ConfigConstants.DATA_PROVIDER_FILE );

		//Call read file method of the class to read data
		return excelFile.readExcelDataProvider("StageData");		
	}	
}
