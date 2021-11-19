package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sun.xml.internal.bind.v2.model.core.MaybeElement;

import pages.MainNavigation;
import pages.MyAccountPage;
import pages.MyWishListPage;
import pages.PersonalInformationForm;
import pages.ShopPage;
import pages.SignInPage;

public class BaseTests {

	WebDriver driver;
	WebDriverWait wait;
	ExcelReader excelReader;
	String homeUrl;
	SignInPage signInPage;
	MainNavigation mainNavigation;
	PersonalInformationForm personalInfo;
	MyAccountPage myAccount;
	ShopPage shopPage;
	MyWishListPage wishList;
	
	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		excelReader = new ExcelReader("data/AutomationTestPlan.xlsx");
		homeUrl = excelReader.getStringData("TSu1", 4 , 3);
		signInPage = new SignInPage(driver);
		mainNavigation = new MainNavigation(driver);
		personalInfo = new PersonalInformationForm(driver);
		myAccount = new MyAccountPage(driver);
		shopPage = new ShopPage(driver);
		wishList = new MyWishListPage(driver);

	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}