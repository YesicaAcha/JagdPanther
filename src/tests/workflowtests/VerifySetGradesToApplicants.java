package tests.workflowtests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.periods.PeriodDetailsPage;
import framework.pages.periods.PeriodsPage;
import framework.pages.periods.StageGradePage;

public class VerifySetGradesToApplicants {
	Database db = new Database();

	/**
	 * Connect to the database and create a program
	 * @throws Exception
	 */
		@BeforeClass
		public void setUp() throws Exception {
			db.setUp();
			db.createStagesDB();
			db.createProgramsByBD();
			db.createGroupDB();
			db.createPeriodDB();
			db.createApplicantDB();	
		}

	/**
	 * This test case verifies program information is modified and displayed in Program Details Page 
	 * and this information is saved in the database
	 * @param name: Program's name
	 * @param title: Program's title
	 * @param description: Program's description
	 * @throws Exception
	 */
	@Test(groups = {"BVT", "Acceptance"})
	public void verifyApplicantsGradesCanBeSet() throws Exception {
		ExternalData externalData = new ExternalData();
		
		List<Map<String, String>> gradesXLS = externalData.readExternalGradesData();
		for (Map<String, String> gradeInfo : gradesXLS) {
			
			String grade = gradeInfo.get("GRADE");
			String applicantCI = gradeInfo.get("CI");
//			String grade = "80";
//			String applicantCI = "4902260";
			
			HomePage HomePage = new HomePage();
			PeriodsPage periodsPage = HomePage.clickPeriodsLink();
			PeriodDetailsPage periodDetailsPage = periodsPage.clickEditPeriodButton();
			StageGradePage stageGradePage = periodDetailsPage.clickStagesButton().clickGradeButton();
			stageGradePage.setGrade(grade).clickSaveButton();

			Assert.assertEquals(db.getApplicantGrade(applicantCI), grade);
		}
		
	}

	/**
	 * Delete Stage data from table
	 * @throws Exception
	 */
	@AfterClass
	public void closeConnection() throws Exception {
		db.deleteDataFromDB();
		db.tearDown();
	}
}
