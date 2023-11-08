package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPage.AddNewCategoryPage;
import pomPage.AddNewCoursePage;
import pomPage.AddNewUserPage;
import pomPage.AdminHomepage;
import pomPage.CategoryPage;
import pomPage.CourseListPage;
import pomPage.Loginpage;
import pomPage.Userspage;
import pomPage.Welcomepage;

public class BaseClass {
	//@BeforeSuite
	//@BeforeTest
	
	protected PROPERTIESUTILITY property;
	protected ExcelUtility excel;
	protected JAVAUTILITY jutil;
	protected WEBDRIVERUTILITY webutil;
	protected WebDriver driver;
	public static WebDriver sdriver;
	public static JAVAUTILITY sjutil;
	
	protected Welcomepage welcome;
	protected Loginpage login;
	protected AdminHomepage home;
	protected Userspage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage adduser;
	protected AddNewCoursePage addcourse;
	protected AddNewCategoryPage addcategory;
	
	
	
	@BeforeClass
	public void classconfig() {
		property = new PROPERTIESUTILITY();
		excel = new ExcelUtility();
		jutil= new JAVAUTILITY();
		webutil= new WEBDRIVERUTILITY();
	
		property.propertiesInitialization(IConstantPath.PROPERTIE_PATH);
		driver = webutil.launchBrowser(property.readFromproperties("browser"));
		 sdriver =driver;
		 sjutil = jutil;
		 
		
	}
	@BeforeMethod
	public void methodConfig() {
		excel.excelIntialization(IConstantPath.EXCEL_PATH);
		
		welcome = new Welcomepage(driver);
	    login = new Loginpage(driver);
	    home = new AdminHomepage(driver);
	    users = new Userspage(driver);
	    course = new CourseListPage(driver);
	    category = new CategoryPage(driver);
	    adduser = new AddNewUserPage(driver);
	    addcourse = new AddNewCoursePage(driver);
	    addcategory = new AddNewCategoryPage(driver);
	    
	    webutil.navigateToApp(property.readFromproperties("url"));
	    
	    long time = Long.parseLong(property.readFromproperties("timeouts"));
	    
	    webutil.waitTillElementFound(time);
	    
	    welcome.clickLoginButton();
	    login.setEmail(property.readFromproperties("username"));
	    login.setpassword(property.readFromproperties("password"));
	    login.clickLogin();    
	    
	}
	@AfterMethod
	public void methodTeardown() {
		excel.closeExcel();
		home.signOutOfApp();
		
	}
	@AfterClass
	public void classteardown() {
		webutil.clos
	}
	//@AfterTest
	//@AfterSuite
	
	
	

}
