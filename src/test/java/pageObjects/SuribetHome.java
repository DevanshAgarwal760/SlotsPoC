package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuribetHome extends BasePage
{

	public SuribetHome(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	//If user is logged in, log-off button will appear
	@FindBy(xpath="(//span[@ng-click='frm.Logout()'])[2]/a")
	WebElement logOff_btn;
	
	public void click_logOff_btn() 
	{
		logOff_btn.click();
	}
	
}
	

