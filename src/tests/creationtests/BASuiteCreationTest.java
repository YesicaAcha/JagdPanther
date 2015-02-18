package tests.creationtests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static framework.common.ConfigConstants.USER_MAIL;
import static framework.common.ConfigConstants.PASSWORD;
import framework.pages.HomePage;
import framework.pages.login.LoginPage;


public class BASuiteCreationTest {
	
	@BeforeSuite
	public void init() {

		//Create LoginPage object
		LoginPage jagdPantherLogin = new LoginPage();

		//login to application
		jagdPantherLogin.loginToJagdPanther(USER_MAIL, PASSWORD);		
	}
	
	@AfterSuite
	public void quit() {
		/*Create HomePage object*/
		HomePage HomePage = new HomePage();
		HomePage
			.logout()				/*logout application*/
			.terminateBrowser();	/*quit browser*/  
	} 
}
