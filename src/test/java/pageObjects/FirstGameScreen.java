package pageObjects;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.OCR;
import factory.BaseClass;

public class FirstGameScreen extends BasePage
{

	//Constructor
	public FirstGameScreen(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators 
	
	//to locate canvas
	//first iFrame
	@FindBy(css="#iframeSlotGame")
	WebElement firstIframe;
	
	//second iFrame
	@FindBy(tagName="iframe")
	WebElement secondIframe1;
	
	//locate canvas
	@FindBy(tagName="canvas")
	WebElement canvas;
	
	public void switchIFrames() 
	{
		BaseClass.getDriver().switchTo().frame(firstIframe);
		BaseClass.getDriver().switchTo().frame(secondIframe1);
	}
	
	//SRD text under balance heading text
	public String getText_SRD() throws InterruptedException, AWTException, IOException
	{
		Thread.sleep(15000);
		return OCR.extractTxt(516, 913, 35, 17);
	}
	
		
}
