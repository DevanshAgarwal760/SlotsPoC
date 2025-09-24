package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

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
	
	@FindBy(xpath="//input[@ng-model='globalslotsgameCtlr.filterQuery']")
	WebElement search_box;
	
	@FindBy(xpath="//div/span[contains(text(),'PL')]")
	WebElement firstGame_play_btn;
	
	public String getText_logOff_btn() 
	{
		String logOff=logOff_btn.getText();
		return logOff;
	}
	public void input_search_box() throws IOException 
	{
		search_box.sendKeys(BaseClass.getProperties().getProperty("gameName"));
	}
	
	public void clickPlay_firstGame() 
	{
		firstGame_play_btn.click();
	}
	
}
	

