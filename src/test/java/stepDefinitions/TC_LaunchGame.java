package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstGameScreen;
import pageObjects.SuribetHome;
import pageObjects.TransferAmountPopUp;

public class TC_LaunchGame 
{
	SuribetHome sh;
	TransferAmountPopUp tapu;
	FirstGameScreen fgs;
	@Given("User is logged in to demo web site")
	public void user_is_logged_in_to_demo_web_site() 
	{
	    sh=new SuribetHome(BaseClass.getDriver());
	    String logOff=sh.getText_logOff_btn();
	    Assert.assertEquals(logOff, "Log Off");
	}

	@When("User searches and launches the game")
	public void user_searches_and_launches_the_game() throws IOException, InterruptedException 
	{
		sh.input_search_box();
		sh.clickPlay_firstGame();
		tapu=new TransferAmountPopUp(BaseClass.getDriver());
		tapu.setAmount_inputBox();
		tapu.clickTransfer_okBtn();
	}

	@Then("User should be able to see the Base game HUD")
	public void user_should_be_able_to_see_the_base_game_hud() throws AWTException, InterruptedException, IOException
	{
		//SRD text under balance heading text
		fgs=new FirstGameScreen(BaseClass.getDriver());
		String text=fgs.getText_SRD().trim();
		Assert.assertEquals(text, "5RD");
	}
}
