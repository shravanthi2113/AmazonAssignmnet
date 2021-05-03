package myDemoProject_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myDemoProject_Base.TestBase;

public class searchPage extends TestBase {
	
	//PageFactory
	@FindBy(id ="twotabsearchtextbox")
	WebElement searchtext;
	
	@FindBy(id="nav-search-submit-button")

	WebElement submit;
	
	@FindBy(linkText="2")
	WebElement secondpage;
	
	@FindBy(partialLinkText="Fire TV")
	WebElement selecteditem;
	
	@FindBy(name="submit.add-to-cart")
	WebElement addCart;
	
	//Intiliaze the page objects
	
	public searchPage() {
			
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String Title() {
		//String title;
		return driver.getTitle();
	}

	public void  search(String searchBox) throws InterruptedException {
		
		searchtext.sendKeys(searchBox);
		
		submit.click();
		secondpage.click();
		Thread.sleep(3000);
		selecteditem.click();		
		
	}
	
	public boolean check_create_new_item_button_visible(){

	    Boolean visible = addCart.isDisplayed();
	    return visible;
	} 
}