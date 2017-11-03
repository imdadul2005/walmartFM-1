/**
 * 
 */
package walmartHomePage;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import common.base;
import pageObject.WalmartHome;


/**
 * @author Imdadul Hoq
 */
public class searchOptionTest extends base {
	public static Logger log =LogManager.getLogger(searchOptionTest.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
		driver = initialDriver();
		log.info("WebDriver Initialized");
	//	driver.navigate().to(prop.getProperty("url"));
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	public void seachOption() throws IOException, InterruptedException {
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		WalmartHome wh = new WalmartHome(driver);
		wh.searchBox().sendKeys(prop.getProperty("search"));
		log.info("Searching for item "+ prop.getProperty("search"));
		waitFor(wh.searchBox());
		wh.searchIcon().click();
		Thread.sleep(400);
		log.info(driver.getTitle());
		String title = driver.getTitle().toLowerCase();
		Assert.assertEquals(title.contains(prop.getProperty("search")), true);
	}
	@AfterTest
	public void tearDown() {
		log.info("After Method");
		driver.close();
		driver = null;
	}
}
