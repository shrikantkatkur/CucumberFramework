package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Keyword;

public class LoginPage   {
	Keyword keyword=new Keyword();
	
	@FindBy(css=".myntraweb-sprite.desktop-logo.sprites-headerLogo ")
	public WebElement Logo;
	////span[normalize-space()='Profile']
	@FindBy(css="div[class='desktop-userIconsContainer'] span[class='desktop-userTitle']")
	public WebElement profile;
	
	@FindBy(css="a[class='desktop-wishlist'] span[class='desktop-userTitle']")
	public WebElement wishlist;
	
	@FindBy(css="a[class='desktop-cart'] span[class='desktop-userTitle']")
	public WebElement bag;
	
	@FindBy(css="input[placeholder='Search for products, brands and more']")
	public WebElement productSearch;
	@FindBy(css=".myntraweb-sprite.desktop-iconSearch.sprites-search")
	public WebElement searchBtn;
	@FindBy(css=".desktop-main[href='/shop/men']")
	public WebElement MEN ;
	
	@FindBy(css=".desktop-main[href='/shop/women']")
	public WebElement WOMEN;
	@FindBy(css=".desktop-main[href='/shop/kids']")
	public WebElement KIDS;
	@FindBy(css=".desktop-main[href='/shop/home-living']")
	public WebElement HOME_LIVING;
	@FindBy(css=".desktop-main[href='/personal-care']")
	public WebElement BEAUTY;
	@FindBy(css=".desktop-main[href='/studio/home']")
	public WebElement STUDIO;
	@FindBy(css="input[type='tel']")
	public WebElement mobileNo;
	@FindBy(linkText="LOGIN/SIGNUP")
	public WebElement signUp;
	@FindBy(css=".submitBottomOption")
	public WebElement CONTINUE;
	public LoginPage() {
		PageFactory.initElements(keyword.driver, this);
	}
	
	
	
	public void clickOnProductSearch() {
		productSearch.click();
		
	}
	public void clickOnSearchBtn() {
		searchBtn.click();
		
	}
	public void clickOnProfile() {
		profile.click();
		
	}

}


