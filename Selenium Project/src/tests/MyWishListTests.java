package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListsTests extends BaseTests {
	
	@BeforeMethod
	public void navigateToPage() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		signInForm();
		
	}
	public void signInForm() {
		mainNavigation.clickOnSignInButton();
		signInPage.insertEmailForSignIn(excelReader.getStringData("TSu2", 8, 3));
		signInPage.insertPassword(excelReader.getStringData("TSu2", 9, 3));
		signInPage.clickOnSignInButton();
		
	}
	
	@Test(priority = 0)
	public void createWishList() {
		String wishListName = excelReader.getStringData("TSu6", 8, 3);
		myAccount.clickOnMyWishListsTab();
		wishList.insertNameOfWishlist(wishListName);
		wishList.clickOnSaveWishList();
		
		boolean actual = false;
		for (int i = 0; i < wishList.getWishListsNamesList().size(); i++) {
			if(wishList.getWishListsNamesList().get(i).getText().equals(wishListName)) {
				actual = true;
			}
		}
		assertEquals(actual, true);
		
	}
	
	@Test(priority = 1)
	public void addOneProductToWishList() {
		String productName = excelReader.getStringData("TSu6", 21, 3);
		String wishListName = excelReader.getStringData("TSu6", 25, 3);
		myAccount.clickOnBackToHome();
		for (int i = 0; i < wishList.getProductsList().size(); i++) {
			if(wishList.getProductsList().get(i).getText().equals(productName)) {
				wishList.getProductsList().get(i).click();
			}
		}
		wishList.addProductToWishList();
		wishList.closePopUp();
		mainNavigation.clickOnNameSurnameButton();
		myAccount.clickOnMyWishListsTab();
		for (int i = 0; i < wishList.getWishListsNamesList().size(); i++) {
			if(wishList.getWishListsNamesList().get(i).getText().equals(wishListName)) {
				wishList.getWishListsNamesList().get(i).click();
			}
		}
		
		assertEquals(wishList.textProductNameAfterAdding().contains(productName), true);
	}
	@Test(priority = 3)
	public void deleteWishList() {
		String wishListForDelete = excelReader.getStringData("TSu6", 36, 3);
		myAccount.clickOnMyWishListsTab();
		for (int i = 0; i < wishList.getWishListsNamesList().size(); i++) {
			if(wishList.getWishListsNamesList().get(i).getText().equals(wishListForDelete)) {
				wishList.getDeleteWishListButtons().get(i).click();
				driver.switchTo().alert().accept();
				break;
				
			}
		}		
	}
	
	
	@AfterMethod
	public void deleteCookies() {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}