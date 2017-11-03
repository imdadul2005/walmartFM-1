package walmartHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import common.base;
import pageObject.WalmartHome;

public class searchWithDataTest extends base{
	public static Logger log =LogManager.getLogger(searchWithDataTest.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
		driver = initialDriver();
		log.info("WebDriver Initialized");
		log.info( prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="getData")
	public void seachOption(String item) throws IOException, InterruptedException {
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		WalmartHome wh1 = new WalmartHome(driver);
		waitFor(wh1.searchBox());
		wh1.searchBox().sendKeys(item);
		log.info("Searching for item " + item);
		wh1.searchIcon().click();
		Thread.sleep(2000);
		//takeScreenShot(item);
		log.info("Searching for "+ item + " received title "+ driver.getTitle());
		String title = driver.getTitle().toLowerCase();
		Assert.assertEquals(title.contains(item), true);
	}
	
	@DataProvider
	public Object[][] getData(){
		// [x][y] x stand for number of test, y stand for number of value per test
		Object[][] obj = new Object[3][1];
		obj[0][0] ="playstation";
		obj[1][0]="ipad";
		obj[2][0]="iphone";
		
		return obj;
	}
	
	@AfterTest
	public void tearDown() {
		log.info("After Test");
		driver.close();
		driver = null;
	}
	
	
	
}
