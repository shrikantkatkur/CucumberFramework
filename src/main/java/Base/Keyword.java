package Base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Exceptions.InvalidBrowserNameError;


	public class Keyword {
		public static RemoteWebDriver driver;
		public FluentWait<WebDriver> wait;
		private static final Logger LOG=Logger.getLogger(Keyword.class);
			/*Dont create Wait consturctor
		 * public Keyword(){//it is constructor to initialiaze wait
		 * wait=new FulentWait<Webdriver>(driver)
		 * }
		to initialz wait,becasue it will take driver value as null
		therefore initialize wait in OpenBrowser method itself
		*/
		public void openBrowser(String browserName) {
			if(browserName.equalsIgnoreCase("Chrome")) {
				driver=new ChromeDriver();
				LOG.info("Launching Chrome Browser");
			}else if(browserName.equalsIgnoreCase("Firefox")) {
				driver=new FirefoxDriver();
				LOG.info("Launching Firefox Browser");
			}else if(browserName.equalsIgnoreCase("IE")) {
				driver=new InternetExplorerDriver();
				LOG.info("Launching IE Browser");
			}else {
				LOG.error("Invalid Browser");
				throw new InvalidBrowserNameError(browserName);
			}
			wait= new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(60));
			wait.pollingEvery(Duration.ofMillis(500));
			wait.withMessage("");
			wait.ignoring(NoSuchElementException.class);
		}
		public void launchUrl(String url) {
			driver.get(url);
		}
		
		public void enterText(WebElement e,String textToEnter) {
			e.sendKeys(textToEnter);
		}
		public void click(WebElement e) {
			e.click();
			}
		public void waitForElementToBeVisible(By element) {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		}
		public void waitForElementToBeClikable(By element) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public void click(String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
		public void enterText(String xpath,String text) {
			driver.findElement(By.xpath(xpath)).sendKeys(text);

		}
		public String getText(String xpath) {
			return driver.findElement(By.xpath(xpath)).getText();
		
		}
		public void closeBrowser() {
			driver.close();
		}
		public void quitBrowser() {
			driver.quit();
		}

	}


