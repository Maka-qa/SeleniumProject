package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTests {
	
	
	@BeforeMethod
	public void navigateToPage() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		
	}
	
	public void signInForm(String email, String password) {
		mainNavigation.clickOnSignInButton();
		signInPage.insertEmailForSignIn(email);
		signInPage.insertPassword(password);
		signInPage.clickOnSignInButton();
		
	}
	public void changePasswordForm(String current, String newPass, String confirm) {
		myAccount.insertCurrentPassword(current);
		myAccount.insertNewPassword(newPass);
		myAccount.confirmNewPassword(confirm);
		myAccount.clickOnSaveButton();
		
	}
	@Test(priority = 0)
	public void changePassword() {
		String email = excelReader.getStringData("TSu3", 39, 3);
		String password = excelReader.getStringData("TSu3", 40, 3);
		String newPassword = excelReader.getStringData("TSu3", 44, 3);
		String confirmPassword = excelReader.getStringData("TSu3", 45, 3);
		
		signInForm(email,password);
		myAccount.clickOnPersonalInformation();
		
		changePasswordForm(password, newPassword, confirmPassword);
		mainNavigation.clickOnSignOutButton();
		signInForm(email, newPassword);		
		assertEquals(mainNavigation.isSignOutDisplayed(), true);
				
	}
	@AfterMethod
	public void deleteCookies() {
		//back to original password
		String password = excelReader.getStringData("TSu3", 40, 3);
		String newPassword = excelReader.getStringData("TSu3", 44, 3);
		myAccount.clickOnPersonalInformation();
		changePasswordForm(newPassword, password, password);
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}