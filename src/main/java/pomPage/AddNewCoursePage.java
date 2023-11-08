package pomPage;


import java.util.Locale.Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WEBDRIVERUTILITY;


public class AddNewCoursePage
{
	//Declaration
	@FindBy(xpath = "//b[text()='Add New Course']")
	private WebElement pageHeader ;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameTF ;
	
	@FindBy(id = "category")
	private WebElement  categoryDropdown;
	
	@FindBy(id = "price")
	private WebElement priceTF ;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement photoButton ;
	
	@FindBy(xpath = "//button[@name='add]")
	private WebElement saveButton ;
	
	
	
	@FindBy(xpath = "//html/body/p")
	private WebElement  descriptionFrame;
	
	//Initialization
	public  AddNewCoursePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	public void setName(String courseName)
	{
		nameTF.sendKeys(courseName);
	}
	
	
	public void selectCategory(WEBDRIVERUTILITY web, String courseName) {
		web.handleDropdown(categoryDropdown ,Category);
		
	}
	
	


	
	public void setPrice(String price)
	{
		priceTF.sendKeys(price);
	}
	
	public void uploadphoto(String photopath)
	{
		photoButton.sendKeys(photopath);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	

	
}
