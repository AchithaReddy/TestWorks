package appModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import pageObjects.LoginPage;
import pageObjects.flightChecking;
//import utility.Constants;
//import utility.ExcelUtility;
import utility.PlugInFunctions;

public class flightFinder {
	static boolean results=false;
	static ExtentTest logger;
	public static WebDriver flightCheck(WebDriver driver, ExtentReports report) throws Exception{
		try{
			//ExcelUtility.setExcel(Constants.xcelPath+"test.xlsx", "Sheet1");
		//ExcelUtility.setExcel(Constants.xcelPath+Constants.xcelfile, Sheet);
	
		 logger = report.startTest("Find Flights");
		 System.out.println("FINDING FLIGHTS");
		 flightChecking.typeOW(driver).click();
		 System.out.println("Clicked on Oneway");
		 logger.log(LogStatus.INFO, "Selected the type of travel successfully");
		 
		 Select passDrop=new Select(flightChecking.passengers(driver));
		 passDrop.selectByIndex(2);
		 System.out.println("Clicked on passangers");
		 
		 Select fromDrop=new Select(flightChecking.from(driver));
		 fromDrop.selectByIndex(2);
		 //flightChecking.from(driver).selectByIndex(4);
		 System.out.println("Clicked on fromdate");
		 
		 Select onMonthDrop=new Select(flightChecking.onMonth(driver));
		 onMonthDrop.selectByIndex(3);
		 System.out.println("Clicked on onMonth");
		 
		 Select onDateDrop=new Select(flightChecking.onDate(driver));
		 onDateDrop.selectByVisibleText("7");
		 System.out.println("Clicked on onDate");
		 
		 logger.log(LogStatus.INFO, "Entered all the flight details successfully");
		 
		 flightChecking.firstClass(driver).click();
		 System.out.println("Clicked on firstClass");
		 
		 Select airlineDrop=new Select(flightChecking.airline(driver));
		 airlineDrop.selectByVisibleText("Unified Airlines");
		 System.out.println("Selected airline");
		 
		 logger.log(LogStatus.INFO, "Entered preferences successfully");
		 flightChecking.continuePage(driver).click();
		 System.out.println("Flights searched");
		 Reporter.log("Flight search success");

}
		catch(Exception e)
		{
			results=false;	
			PlugInFunctions.errorHandling(driver, results, logger, "Flights searched");
				
		}
		report.endTest(logger);
		report.flush();
	
	return driver;
}
}
