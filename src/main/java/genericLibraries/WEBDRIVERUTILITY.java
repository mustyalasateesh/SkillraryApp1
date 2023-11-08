package genericLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class contains all reusable methodes to perform webdriver actions
 * @author sateesh
 */
public class WEBDRIVERUTILITY 
{
	WebDriver driver ;
	/**
	 * This method is used to launch user desired browser
	 * @param
	 * @return
	 */
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break ;
			default :
				System.out.println("invalid browser info");
			
			
			
		}
		
		driver.manage().window().maximize();
		return driver ;
	}
/**
 * This method is used  to navigate  to the application
 * @param url
 */

	public void navigateToApp(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used ia an implicitly wait statement
	 * @param time
	 */
	public void waitTillElementFound(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	/**
	 * This method is used to wait until element is visible
	 * @param
	 * @param element
	 * @return
	 */
	public WebElement explicitWait( long time , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,  time);
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	
	/**
	 * This method is used to wait until element is enabled
	 * @param element
	 * @param time
	 * @returnn
	 * 
	 */
	public WebElement explicitWait(WebElement element , long time )
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * This method is used to wait until title of the webpage appeares
	 * @param title
	 * @param time
	 * @return
	 */
	public Boolean explicitwait(String title , long time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait .until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This method is used to mouse hover on an element
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
	
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public void doubleClickonElement(WebElement element)
	{
		Actions   actions  = new Actions(driver);
		actions.doubleClick(element).perform();
		
	}
	/**
	 * This method is used to right click on an element 
	 * @param element
	 
	 */
	public void rightClick(WebElement element)
	{
		Actions   actions  = new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop an element
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement( WebElement element , WebElement target)
	{
		Actions   actions  = new Actions(driver);
		actions.dragAndDrop(element, target).perform();
	}
	public void handleDropdown(Object category, WebElement categoryDropdown) {
		// TODO Auto-generated method stub
		
	}
	

}
