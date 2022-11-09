 package com.crm.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.crm.qa.base.AppDriver;
import com.crm.qa.constants.ElementConstants;
import com.crm.qa.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest {
	private ExtentTest test;
	private ExtentReports report;
	AppDriver ApDrv;
	HomePage hme;
	String title, engURL;
	List<String> hme_detail=null;
	
	
	
	@BeforeSuite
	public void startTest() throws IOException
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("Pearson_Test_Cases");
		

	}
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void homeSetup() throws IOException, InterruptedException {
		
		ApDrv = new AppDriver();
		hme = new HomePage();
		
		ApDrv.BrowserLaunch(AppDriver.getElement(ElementConstants.Main_URL));
		
        ApDrv.explicitWaitByxpath(AppDriver.getElement(ElementConstants.HOME_LINK));
        test.log(LogStatus.PASS, "Browser launched with Pearson home page");
		
	}
		
        
	@Test
	public void verifyHomePageTest() throws IOException, InterruptedException{
			title =ApDrv.verifyHomePageTitle();
						
			
			if(ApDrv.getcurrenturl().equals(AppDriver.getElement(ElementConstants.Main_URL))){
				 hme_detail=hme.home_pagetest();
				 
				 test.log(LogStatus.PASS, "Navigated to the Correct Home URL");
		        }
		        else {
		        	test.log(LogStatus.FAIL, "Navigated to the WRONG URL");
		        }
			
			try{
  
				Assert.assertEquals(hme_detail.get(0), AppDriver.getElement(ElementConstants.BODYTEXT_EXP),"Home page text is correct");
 
				test.log(LogStatus.PASS, "Home page text is correct");
        				
			} 
			catch (AssertionError e) {
				test.log(LogStatus.FAIL, "Navigated to the WRONG URL");
			}
			try{
				
				Assert.assertEquals(title,AppDriver.getElement(ElementConstants.TITLE),"Home page TITLE not matched");
				test.log(LogStatus.PASS, "Home Page Title is correct");
			
			}
			catch (AssertionError e) {
				test.log(LogStatus.FAIL, "Home Page Title is wrong");
			}
		               
		
		
		
	}
	
	
	@AfterSuite
	public void endTest()
	{
	report.endTest(test);
	report.flush();
	report.close();
	}
	
	@AfterMethod
	public void tearDown(){
		ApDrv.tearDown();
	}
}
