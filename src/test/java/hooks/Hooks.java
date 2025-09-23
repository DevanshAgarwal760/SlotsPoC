package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks 
{

	 WebDriver driver;
	 Properties p;
     
	//Runs before each scenario
	@Before
    public void setup() throws IOException, InterruptedException
    {
    	driver=BaseClass.initializeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	login();
    			
	}
		
    //Runs after each scenario
    @After
    public void tearDown() {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) 
    {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }
    
    public void login() throws InterruptedException 
    {
    	String url=p.getProperty("appURL");
    	String accID=p.getProperty("accID");
    	String accPwd=p.getProperty("accPwd");
    	driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Email / Mobile / CardNo']")).sendKeys(accID);
		driver.findElement(By.xpath("//input[@placeholder='Password / Card Pin']")).sendKeys(accPwd);
		driver.findElement(By.xpath("//input[@class='loginActive']")).click();
		////i[@ng-click='DayValShow=false']
		// click on upload document pop up
		WebElement upload=driver.findElement(By.xpath("//i[@ng-click='DayValShow=false']"));
		Thread.sleep(3000);
		if(upload.isDisplayed()) 
		{
			upload.click();
			Thread.sleep(1000);
		}
    }
   
}