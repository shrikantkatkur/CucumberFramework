package nop_Commerce_BDD.stepDef;

import org.openqa.selenium.interactions.Actions;

import Base.Keyword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import utilities.Config;

public class LoginPageSteps extends Keyword {
	Keyword keyword = new Keyword();
	Config conf=new Config();
	LoginPage loginPage=new LoginPage();
	Actions action=new Actions(driver);
		
	@When("user hover on Profile Section")
	public void user_hover_on_profile_section() {
		
		action.moveToElement(loginPage.profile).perform();
		loginPage.profile.click();
		}

	@And("Click on LOGIN Btn")
	public void click_on_login_singup_btn() {
		loginPage.signUp.click();
	}

	@When("Click on CONTINUE")
	public void click_on_continue() {
		loginPage.CONTINUE.click();
		
	}

	@Then("User should get {string}")
	public void user_should_get(String string) {
		
	}


}
