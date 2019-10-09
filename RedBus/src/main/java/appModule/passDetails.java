package appModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import pageObjects.flightChecking;
import pageObjects.passangerDetails;
import utility.Constants;
import utility.ExcelUtility;
import utility.PlugInFunctions;

public class passDetails {
	static boolean results=false;
	static ExtentTest logger;
	public static WebDriver passDetail(WebDriver driver, ExtentReports report) throws Exception{
		try{
			logger=report.startTest("Passanger details");
			
			passangerDetails.departPangea(driver).click();
			
			passangerDetails.returnUnified(driver).click();
			
			passangerDetails.reserveFlights(driver).click();
			System.out.println("Reserved Flights");
			
			String fname=ExcelUtility.getCellValue(1,Constants.Col_fname);
			passangerDetails.firstName(driver).sendKeys(fname);
			logger.log(LogStatus.INFO, "entered first name successfully");
			System.out.println("Entered First name");
			
			String lname=ExcelUtility.getCellValue(1, Constants.Col_lname);
			passangerDetails.lastName(driver).sendKeys(lname);
			logger.log(LogStatus.INFO, "Entered last name successfully");
			System.out.println("Entered last name");
			
			Select mealDrop= new Select(passangerDetails.meal(driver));
			mealDrop.selectByIndex(3);
			logger.log(LogStatus.INFO, "Selected meal");
			System.out.println("Meal selected");
			
			Select cardTypeDrop= new Select(passangerDetails.cardType(driver));
			cardTypeDrop.selectByIndex(3);
			logger.log(LogStatus.INFO, "Selected type of card");
			
			String num=ExcelUtility.getCellValue(1, Constants.Col_Number);
			passangerDetails.cardNumber(driver).sendKeys(num);
			
			Select expMonth=new Select(passangerDetails.expMonth(driver));
			expMonth.selectByIndex(12);
			
			Select expDate=new Select(passangerDetails.expYear(driver));
			expDate.selectByIndex(11);
			
			String address=ExcelUtility.getCellValue(1, Constants.Col_Address);
			passangerDetails.address(driver).clear();
			passangerDetails.address(driver).sendKeys(address);
			
			String city=ExcelUtility.getCellValue(1, Constants.Col_city);
			passangerDetails.city(driver).clear();
			passangerDetails.city(driver).sendKeys(city);
			
			String state=ExcelUtility.getCellValue(1, Constants.Col_State);
			passangerDetails.state(driver).clear();
			passangerDetails.state(driver).sendKeys(state);
			
			String zip=ExcelUtility.getCellValue(1, Constants.Col_postalCode);
			passangerDetails.postalCode(driver).clear();
			passangerDetails.postalCode(driver).sendKeys(zip);;
			logger.log(LogStatus.INFO,"Entered address successfully");
			System.out.println("Address entered");
			
			Select countryDP=new Select(passangerDetails.country(driver));
			countryDP.selectByIndex(20);
			
			passangerDetails.deliverAdd(driver).click();
			
			passangerDetails.securePurchase(driver).click();
			logger.log(LogStatus.INFO,"Booked successfully");
			System.out.println("booking confirmed");
			
			PlugInFunctions.takeScreenShot(driver, "TicketBooked");
				
			
					
		}
		catch(Exception e){
			
			results=false;	
			PlugInFunctions.errorHandling(driver, results, logger, "Flights searched");
		}
		report.endTest(logger);
		report.flush();
	return driver;	
	}
	
	public static WebDriver ticketVerification(WebDriver driver, ExtentReports report) throws Exception{
		try{
			logger=report.startTest("Ticket Verification");
			passangerDetails.flights(driver).click();
			logger.log(LogStatus.INFO,"Clicked on flights successfully");
			passangerDetails.itenary(driver).click();
			logger.log(LogStatus.INFO,"Clicked on itenary successfully");
			PlugInFunctions.takeScreenShot(driver, "TicketConfirm");
			
		}
catch(Exception e){
			
			results=false;	
			PlugInFunctions.errorHandling(driver, results, logger, "Flights searched");
		}
		report.endTest(logger);
		report.flush();
	return driver;	
	}
	
}
	
	
	
	
	
	
