package appModule;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LoginPage;
import utility.Constants;
import utility.ExcelUtility;
import utility.PlugInFunctions;

public class Login {
			
		static boolean results=false;
		static ExtentTest logger;
		public static WebDriver logon(WebDriver driver, ExtentReports report) throws Exception{
			try{
				ExcelUtility.setExcel(Constants.xcelPath+"test.xlsx", "Sheet1");
			//ExcelUtility.setExcel(Constants.xcelPath+Constants.xcelfile, Sheet);
			
			 logger = report.startTest("Login");
			String username=ExcelUtility.getCellValue(1,Constants.Col_UserName);
			System.out.println(username);
			logger.log(LogStatus.INFO, "Username entered  successfully");
			LoginPage.Username(driver).sendKeys(username);
			
			String password=ExcelUtility.getCellValue(1,Constants.Col_Password);
			pageObjects.LoginPage.Password(driver).sendKeys(password);
			logger.log(LogStatus.INFO, "Password entered  successfully");
			
			pageObjects.LoginPage.Submit(driver).click();
			logger.log(LogStatus.INFO, "Clicked on login successfully");
			System.out.println("Logged in successfully");
			Reporter.log("Logon Successfully");
			Thread.sleep(8000);
			
			}
				catch(Exception e)
				{
					results=false;	
					PlugInFunctions.errorHandling(driver, results, logger, "Click on Login successfull");
						
				}
				report.endTest(logger);
				report.flush();
			
			return driver;
		}
	}

