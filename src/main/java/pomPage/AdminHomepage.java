package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage 
{

	//Declaration
	
	@FindBy(xpath = "//span[text()='SkillRary Admin']")
	
	private WebElement  adminIcon;
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement  userTab;
	
	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement  coursesTab;
	
	
	@FindBy(xpath = "//a[text()=\" Course List\"]")
	private WebElement  courseListLink;
	
	
	@FindBy(xpath = "//a[text()=\" Category\"]")
	private WebElement categoryLink ;
	
	@FindBy(xpath = "//a[text()='SignOutLink")
	private WebElement  signout;
	
	
	
	
	
	//Initialization
	
	public AdminHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getAdminIcon()
	{
		return adminIcon.getText();
	}
	
	public void clickCoursesTab()
	{
		coursesTab.click();
	}
	
	public void clickCourseListLink()
	{
		courseListLink.click();
	}
	
	public void clickCategory()
	{
		categoryLink.click();
	}
	
	public void signOutOfApp() {
		adminIcon.click();
		signoutLink.click();
	}
	
	
	
	
	
	
	 
	

	
	
	
	@FindBy(xpath = "//a[text()='SignOutLink")
	private WebElement  signoutLink;
	
	
	
	
	
	
	
	
	
	

}
