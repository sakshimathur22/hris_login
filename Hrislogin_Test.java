package org.seleniumhq.selenium.Maven3;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.seleniumhq.selenium.Hris_Test.Hrislogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Hrislogin_Test {
WebDriver driver;


Hrislogin login=new Hrislogin();
//TimeSheet ts=new TimeSheet(driver);
@Test(priority=1)
public void  Testing_Test_1() {
		login.LaunchBrowser();
	  Assert.assertTrue(login.driver.getCurrentUrl().contains("https://hris.qainfotech.com/login.php"));
	  
	}
	@Test(priority=2)
	public void  Testing_Test_2() {
		  Assert.assertTrue(login .IncorrectPassword("INVALID_USERN", "INVALUD_PASSWEOR").contains("Invalid Login"));
   }
	
	@Test(priority=3)
	public void  Testing_Test_3() 
	{
		Assert.assertNotEquals( "null",login.BlankCredentialsGiven(" ", "").contains("Invalid Login"));
	
	}
	@Test(priority=4)
	public void TestingValidCredentials() {
		login.ValidCredentials("sakshimathur", "Sakshi@321#");
		Assert.assertTrue(login.driver.getCurrentUrl().contains("https://hris.qainfotech.com:8086/time/timesheet"));
		}
}