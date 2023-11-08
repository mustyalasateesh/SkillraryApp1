package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userspage 
{
	//Declaration
	
	@FindBy(xpath = "//h1[normalize-space(text())='Users']")
	private WebElement  pageHeader;
	
	
	@FindBy(xpath = "//a[text()=\" New\"]")
	
	private WebElement  plusNewButton;
	
	@FindBy(xpath ="//ul[@class='pagination']/li[last()-1]/a")
	
	private WebElement  usersListLastpage;
	
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
	
	private WebElement  lastUser;
	
	//Initialization
	public Userspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	public String getpageHeader()
	{
		return pageHeader.getText();
	}
	
	
	public void clickNewButton()
	{
		plusNewButton.click();
	}
	
	public void clickUserListLastPage()
	{
		usersListLastpage.click();
	}
	public String getLastUserName()
	{
		return lastUser.getText();
	}
	
	
	
	

}
