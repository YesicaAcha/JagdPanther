package tests.workflowtests;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import framework.utils.readers.JXLExcelReader;
import jxl.JXLException;

import static framework.common.ConfigConstants.EXTERNAL_DATA_PATH;
import static framework.common.ConfigConstants.EXTERNAL_DATA_FILE;

public class ExternalData {
	
	public List<Map<String, String>> readExternalData(String sheetName) throws JXLException, IOException {		
		String filePath =  EXTERNAL_DATA_PATH;
		String fileName = EXTERNAL_DATA_FILE;
		JXLExcelReader reader = new JXLExcelReader(filePath, fileName);
		return reader.readExcel(sheetName);
	}
	
	public List<Map<String, String>> readExternalStageData() throws JXLException, IOException {		
		return readExternalData("StageData");
	}
	
	public List<Map<String, String>> readExternalProgramData() throws JXLException, IOException {		
		return readExternalData("ProgramData");
	}
	
	public List<Map<String, String>> readExternalGroupData() throws JXLException, IOException {		
		return readExternalData("GroupsData");
	}
	
	public List<Map<String, String>> readExternalPeriodData() throws JXLException, IOException {		
		return readExternalData("PeriodsData");
	}
	
	public List<Map<String, String>> readExternalApplicantsData() throws JXLException, IOException {		
		return readExternalData("ApplicantsData");
	}
	
	public List<Map<String, String>> readExternalGradesData() throws JXLException, IOException {		
		return readExternalData("ApplicantsGrade");
	}
	
	

}
