package pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Keyword;

public class ProductSearchPage  {
	Keyword keyword=new Keyword();
	@FindBy(css="input[value='men,men women']")
	public WebElement Men;
	@FindBy(css="input[value='women,men women']")
	public WebElement Women;
	@FindBy(css="input[value='boys,boys girls']")
	public WebElement Boys;
	@FindBy(css="input[value='girls,boys girls']")
	public WebElement Girls;
	//ul[class='gender-list'] li:nth-child(1) label:nth-child(1),
	@FindBy(css="ul[class='gender-list'] li:nth-child(1) label:nth-child(1)")
	public WebElement Brands;
	
	public ProductSearchPage() {
		PageFactory.initElements(keyword.driver, this);
	}
	 
	public void clickOnMen() {
		Men.click();
	}
	

}
