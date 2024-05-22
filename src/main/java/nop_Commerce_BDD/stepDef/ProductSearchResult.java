package nop_Commerce_BDD.stepDef;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.Keyword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.ProductSearchPage;
import utilities.Config;

public class ProductSearchResult {
	Keyword keyword=new Keyword();
	ProductSearchPage pSP=new ProductSearchPage();
	Config conf=new Config();
	LoginPage loginPage= new LoginPage();	
	String mainPage;
	@When("user search the product")
	public void user_search_the_product() {
		loginPage.productSearch.sendKeys("Shoes for Men",Keys.ENTER);
	}
	@Then("User should get desired result")
	public void validateDisplayResult() throws InterruptedException {

//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(keyword.driver);
//			       wait.withTimeout(Duration.ofMillis(5000));
//			       wait.pollingEvery(Duration.ofSeconds(250));
//			       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"][1]")));
//			       System.out.println("Searching for element");
		List<WebElement> productTitles=keyword.driver.findElements(By.cssSelector("h4[class='product-product']"));
		for (WebElement e : productTitles) {
			String productTitle =e.getText();
			if(productTitle.contains("Men")) {
				System.out.println("PASS");
			} else if(productTitle.contains("UniSex")) {
				System.out.println("PASS");
			}else {
				System.out.println("FAIL");
			}
			//System.out.println(productTitle);
			//productTitle.contains("Sneaker");
			}
		keyword.driver.close();
	/**	
		Iterator<WebElement> itr=resultList.iterator();
		while (itr.hasNext()) {
		WebElement productName = (WebElement) itr.next();
		String actualName=productName.getText();
		System.out.println(actualName);
		Boolean result=actualName.contains("Sneaker");
		System.out.println(result);
	**/	
	}
	
	@And("Close the Tab")
	public void closeBrowser() {
		keyword.closeBrowser();
	}
	@When("user search Invalid the product")
	public void user_search_invalid_the_product() {
		keyword.driver.findElement(By.cssSelector("input[placeholder='Search for products, brands and more']")).sendKeys("dfhg4f56452h5wd54342893739847%$6",Keys.ENTER);
	}

	@Then("User should get Invalid search message {string}")
	public void user_should_get_invalid_search_message(String string) throws InterruptedException {
		Thread.sleep(3000);
		String actMessage=keyword.driver.findElement(By.cssSelector(".index-infoBig")).getText();
		Assert.assertEquals(actMessage, string);
	}
	@And("Click on product image")
	public void Click_on_product_image() {
		 mainPage=keyword.driver.getWindowHandle();
		keyword.driver.findElement(By.cssSelector("img[title='Red Tape Men Perforated Slip Resistant Lace-Up Sneakers']")).click();
	}
	@And("Enter Valid pincode and click on check")
	public void Enter_Valid_pincode_and_clcik_on_check() {
		Set<String> handles=keyword.driver.getWindowHandles();
		for (String handle : handles) {
			if(!handle.equals(mainPage)) {
				keyword.driver.switchTo().window(handle);
				break;
			}
			
		}
		keyword.driver.findElement(By.cssSelector("input[placeholder=\"Enter pincode\"]")).sendKeys("411027");
		keyword.driver.findElement(By.cssSelector("input[type='Submit']")).click();;
		
	}
	@Then("should accept valid pincode")
	public void should_accept_valid_pincode() throws InterruptedException  {
		
		boolean actMessage=keyword.driver.findElement(By.xpath("//div[@class='pincode-tickcontainer']")).isDisplayed();
		Assert.assertTrue(actMessage);
	}
	
	
		
	@Then("User should get desired Product Brand result")
	public void user_should_get_desired_product_brand_result() {
		List<WebElement> resultList=keyword.driver.findElements(By.cssSelector(".product-product"));
		for (WebElement webElement : resultList) {
			String actualName =webElement.getText();
			System.out.println(actualName);
			Boolean result=actualName.contains("Men");
			System.out.println(result);
		}
	}

}
