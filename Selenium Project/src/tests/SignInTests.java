package tests;

import static org.testng.Assert.assertEquals;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.org.apache.xml.internal.security.utils.SignerOutputStream;

public class SignInTests extends BaseTests {
	
	@BeforeMethod
	public void navigateToPage() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	
	//sign in form
		public void signInForm(String email, String password) {
			mainNavigation.clickOnSignInButton();
			signInPage.insertEmailForSignIn(email);
			signInPage.insertPassword(password);
			signInPage.clickOnSignInButton();
			
		}
			
	@Test(priority = 0)
	public void signInWithValidCredentials() {
		String email = excelReader.getStringData("TSu2", 8, 3);
		String password = excelReader.getStringData("TSu2", 9, 3);
		signInForm(email, password);
		wait.until(ExpectedConditions.visibilityOf(mainNavigation.getSignOutButton()));
		assertEquals(mainNavigation.isSignOutDisplayed(), true);

	}
	@Test(priority = 1)
	public void signInWithInvalidEmail() {
		String email = excelReader.getStringData("TSu2", 21, 3);
		String password = excelReader.getStringData("TSu2", 22, 3);
		signInForm(email, password);
		String expected = excelReader.getStringData("TSu2", 25, 3);
		assertEquals(signInPage.emailSignInAlert(), expected);

	}
	@Test(priority = 2)
	public void signInWithInvalidPassword() {
		String email = excelReader.getStringData("TSu2", 34, 3);
		String password = excelReader.getStringData("TSu2", 35, 3);
		String expected = excelReader.getStringData("TSu2", 38, 3);

		signInForm(email, password);
		assertEquals(signInPage.passwordAlert(), expected);

	}
	@Test(priority = 4)
	public void signInWithoutCredentials() {
		String email = "";
		String password = "";
		String expected = excelReader.getStringData("TSu2", 51, 3);

		signInForm(email, password);
		assertEquals(signInPage.emailSignInAlert(), expected);

	}
	
	@Test(priority = 6)
		public void signOutFromAccount() {
		String expected = excelReader.getStringData("TSu2", 62, 3);
		signInWithValidCredentials();
		mainNavigation.clickOnSignOutButton();
		
		assertEquals(mainNavigation.textFromSignInButton(), expected);
	}
	
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}