package myDemoProject_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import myDemoProject_Util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties prop;
	
	public TestBase() {
		
		try {
			
			prop=new Properties();
			
			FileInputStream ip=new FileInputStream(
					System.getProperty("user.dir")+ "/src/main/java/myDemoProject_config/config.properties");
			prop.load(ip);
			
					
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}			
		
	}
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
			
			//System.setProperty("webdriver.chrome.driver", "/Users/shravanmartha/Downloads/chromedriver");
		  WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		
			driver.get(prop.getProperty("url"));
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_wait, TimeUnit.SECONDS);
	
		
		
	
	
}
}

