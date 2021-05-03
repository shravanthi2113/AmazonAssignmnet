
package myDemoProject_Test1;


import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import myDemoProject_Base.TestBase;
import myDemoProject_Pages.searchPage;

public class searchPageTest extends TestBase {

	searchPage searchpage;
	
	public searchPageTest() throws IOException{
		
		super();			
	}
	@BeforeMethod
	public void setup(){
		initialization();
		searchpage =new searchPage();
	}
	
	
	@Test(priority=1)
	public void titletest() {
String title=searchpage.Title();
System.out.println(title);
	}
		
	@Test(priority=2)
	public void searchtest() throws InterruptedException {
		searchpage.search(prop.getProperty("searchterm"));	
	}
	
	
	@Test(priority=3)
	public void validateButton() {
		boolean visibility=searchpage.check_create_new_item_button_visible();
		Assert.assertEquals(true, visibility);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}

