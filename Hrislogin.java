package org.seleniumhq.selenium.Maven3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hrislogin {
	WebDriver driver;
	
	 WebElement userNameEntry;
	 WebElement passwordEntry;
     
    
	 public  void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sakshimathur\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://hris.qainfotech.com/login.php");

}	
	 private WebElement getUserNameEntry(){
    return this.driver.findElement(By.id("txtUserName"));
}

	private WebElement getPasswordEntry(){
    return this.driver.findElement(By.id("txtPassword"));
    
}

	public void login(String username, String password){
	
		driver.findElement(By.className("active")).click();
    getUserNameEntry().clear();
    getUserNameEntry().sendKeys(username);
   
	 getPasswordEntry().clear();
    getPasswordEntry().sendKeys(password);
    
 
    getPasswordEntry().submit();
    driver.findElement(By.className("active")).click();
	
    
 } 
	/*public WebElement getErrorMessageElement(){
    return this.driver.findElement(By.cssSelector(".alert-error"));
}*/

	public String IncorrectPassword(String username,String password) {
	login(username,password);
	return driver.findElement(By.className("loginTxt")).getText();
	
}
	public String BlankCredentialsGiven(String username,String password) {
	//return driver.findElement(By.xpath("//*[@id=\'login']/form"));
	login(username,password);
	return driver.findElement(By.className("loginTxt")).getText();

}
	/*public String URL()
    {
    return driver.getCurrentUrl();
    }*/
	public String ValidCredentials(String username,String password){
		//login(username,password);
		  // driver.findElement(By.xpath("//*[@id=\'demo-2\']/div/div[2]/ul/li[1]/a/span")).click();
		getUserNameEntry().clear();
	    getUserNameEntry().sendKeys(username);
	   
		 getPasswordEntry().clear();
	    getPasswordEntry().sendKeys(password);
	    
	 
	    getPasswordEntry().submit();
	    return driver.getCurrentUrl().toString();
	
	}	

	

}

