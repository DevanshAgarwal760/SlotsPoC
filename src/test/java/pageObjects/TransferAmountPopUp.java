package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class TransferAmountPopUp extends BasePage 
{
	public TransferAmountPopUp(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="(//input[@id='transferInput'])[1]")
	WebElement amount_inputBox;
	
	@FindBy(xpath="//div[@class='Transfer_Ok_but']")
	WebElement transfer_okBtn;
	
	//action methods
	public void setAmount_inputBox() throws IOException, InterruptedException 
	{
		amount_inputBox.clear();
		Thread.sleep(1000);
		amount_inputBox.sendKeys(BaseClass.getProperties().getProperty("gameAmount"));
	}
	public void clickTransfer_okBtn() 
	{
		transfer_okBtn.click();
	}
}
