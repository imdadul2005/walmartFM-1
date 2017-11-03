/**
 * 
 */
package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Imdadul Hoq
 *
 */
public class WalmartHome {

	public WebDriver driver;
	public WalmartHome(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#header-GlobalLefthandNav-toggle-1") WebElement headerEle;
	@FindBy(xpath = "//input[@id='global-search-input']") WebElement searchBoxEle;
	@FindBy(xpath = "//a[contains(@title,'Reorder Items')]") WebElement recordItemEle;
	@FindBy(xpath = "//button[@class='header-GlobalSearch-submit btn']") WebElement searchIconEle;
	
	public WebElement header() {
		return headerEle;
	}
	
	public WebElement searchBox() {
		return searchBoxEle;
	}
	
	public WebElement recordItem() {
		return recordItemEle;
	}
	
	public WebElement searchIcon() {
		return searchIconEle;
	}
	
}
