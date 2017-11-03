/**
 * 
 */
package common;

 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author Imdadul Hoq
 *
 */
public class base {

	 public static WebDriver driver;
	 public static Properties prop;
	
	public WebDriver initialDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Java\\RahulFramework\\src\\main\\java\\resource\\info.properties");
		prop.load(fis);
		
		System.setProperty("webdriver.gecko.driver", "/Java/101617/drivers/geckodriver.exe");
		System.setProperty("webdriver.opera.driver", "/Java/101617/drivers/operadriver.exe");
		System.setProperty("webdriver.chrome.driver", "/Java/101617/drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "/Java/101617/drivers/IEDriverServer.exe");
	 	
		String browserName = prop.getProperty("browser");
	    if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        }
		return driver;
	}
	
	/*public void takeScreenShot() throws IOException {
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenshot.jpg"));
	}*/
	public void takeScreenShot(String name) throws IOException {
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String name1 ="E://sc//"+name+".png";
		 System.out.println(name1);
		 FileUtils.copyFile(src, new File(name1));
		}
	
	public void waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
