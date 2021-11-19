package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends BaseTests {
	
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
	
	public void addressForm(String newAddress, String newCity,String newState, String newPostalCode) {
		personalInfo.insertAddress(newAddress);
		personalInfo.insertCity(newCity);
		personalInfo.selectState(newState);
		personalInfo.insertPostalCode(newPostalCode);
	}
	
	
	//Verify that only one radio button can be checked at the same time
	@Test(priority = 1)
	public void checkRadioButtons() {
		
		myAccount.clickOnPersonalInformation();
		myAccount.checkMrRadioButton();
		myAccount.checkMrsRadioButton();
		
		assertEquals(myAccount.isMrChecked(), false);
		
	}
	@Test(priority = 3)
	public void updateAddress() {
		
		String addressAliasToDelete = excelReader.getStringData("TSu5", 10, 3).toUpperCase();
		String newAddress = excelReader.getStringData("TSu5", 13, 3);
		String newCity = excelReader.getStringData("TSu5", 14, 3);
		String newState = excelReader.getStringData("TSu5", 15, 3);
		String newPostalCode = String.valueOf(excelReader.getIntegerData("TSu5", 16, 3));
		String newAlias = excelReader.getStringData("TSu5", 17, 3);

		
		myAccount.clickOnMyAddressesTab();
		for (int i = 0; i < myAccount.getAddressList().size(); i++) {
			if(myAccount.getAddressList().get(i).getText().equals(addressAliasToDelete)) {
				myAccount.getUpdateButtonsList().get(i).click();
				break;
			}
		}
		personalInfo.insertAddress(newAddress);
		
		if(!personalInfo.getCityInputField().getText().equals(newCity)) {
			personalInfo.insertCity(newCity);
		}
		if(!personalInfo.getStateDropDownManu().getFirstSelectedOption().toString().equals(newState)) {
			personalInfo.selectState(newState);
		}
		if(!personalInfo.getPostalCodeInputField().getText().equals(newPostalCode)) {
			personalInfo.insertPostalCode(newPostalCode);
		}
		if(!personalInfo.getAdressAliasInputField().getText().equals(newAlias)) {
			personalInfo.insertAddressAlias(newAlias);
		}
		personalInfo.clickOnSaveAddressUpdateButton();
		
		for (int i = 0; i < myAccount.getAddressList().size(); i++) {
			if(myAccount.getAddressList().get(i).getText().equals(newAlias)){
				
			
		assertEquals(myAccount.getAddresses1List().get(i).getText(), newAddress, "New address isn't saved.");
		/*assertEquals(myAccount.checkNewCity(), newCity  + ",", "New city isn't saved.");
		assertEquals(myAccount.checkNewState(), newState, "New state isn't saved.");
		assertEquals(myAccount.checkNewPostalCode(), newPostalCode, "New postal code isn't saved.");*/
			}
		}
	}
	@Test (priority = 2)
	public void addNewAddress() {
		String newAddress = excelReader.getStringData("TSu5", 31, 3);
		String newCity = excelReader.getStringData("TSu5", 32, 3);
		String newState = excelReader.getStringData("TSu5", 33, 3);
		String newPostalCode = String.valueOf(excelReader.getIntegerData("TSu5", 34, 3));
		String newMobilePhone = excelReader.getStringData("TSu5", 35, 3);
		String newAlias = excelReader.getStringData("TSu5", 36, 3);
		myAccount.clickOnMyAddressesTab();
		myAccount.clickOnAddNewAddress();
		addressForm(newAddress, newCity, newState, newPostalCode);
		personalInfo.insertMobilePhone(newMobilePhone);
		personalInfo.insertAddressAlias(newAlias);
		personalInfo.clickOnSaveAddressUpdateButton();
		
		int counter = 0;
		for (int i = 0; i < myAccount.getAddressList().size(); i++) {
			if(myAccount.getAddressList().get(i).getText().equals(newAlias.toUpperCase())) {
				counter++;
			}
			
		}
		assertEquals(counter, 1);
		
		
	}
	
	@Test(priority = 4)
	public void deleteAddress() {
		String addressAliasToDelete = excelReader.getStringData("TSu5", 48, 3).toUpperCase();
		myAccount.clickOnMyAddressesTab();
		for (int i = 0; i < myAccount.getAddressList().size(); i++) {
			if(myAccount.getAddressList().get(i).getText().equals(addressAliasToDelete)) {
				myAccount.getDeleteButtonsList().get(i).click();
				driver.switchTo().alert().accept();

			}
		}
		int actualNumber = 0;
		for (int i = 0; i < myAccount.getAddressList().size(); i++) {
			if(myAccount.getAddressList().get(i).getText().equals(addressAliasToDelete)) {
				actualNumber++;
			}
			
		}
		assertEquals(actualNumber, 0);
	}
	
	@Test(priority = 5)
	public void editPersonalInfo() {
		String firstName = excelReader.getStringData("TSu3", 62, 3);
		String lastName = excelReader.getStringData("TSu3", 63, 3);
		int day = excelReader.getIntegerData("TSu3", 64, 3);
		String month = excelReader.getStringData("TSu3", 65, 3);
		String year = excelReader.getStringData("TSu3", 66, 3);
		String password = excelReader.getStringData("TSu3", 67, 3);
		String expectedText = excelReader.getStringData("TSu3", 70, 3);

		myAccount.clickOnPersonalInformation();
		myAccount.checkMrsRadioButton();
		if(myAccount.currentFirstName().equals(firstName)){
			myAccount.getEditFirstNameInputField().sendKeys(Keys.TAB);
		}
		else {
			myAccount.editFirstName(firstName);
		}
		
		if(myAccount.currentLastName().equals(lastName)) {
			myAccount.getEditLastNameInputField().sendKeys(Keys.TAB);

		}
		else {
			myAccount.editLastName(lastName);
		}

		myAccount.selectDayOfBirth(day);
		myAccount.selectMonthOfBirth(month);
		myAccount.selectYearOfBirth(year);
		myAccount.insertCurrentPassword(password);
		
		myAccount.clickOnSaveButton();
		
		String actualNameAndSurname = mainNavigation.textFromNameSurnameButton();
		assertEquals(actualNameAndSurname, firstName + " " + lastName);
		assertEquals(myAccount.textFromSuccesfullUpdateLabel(), expectedText);
	}
	
	@AfterMethod
	public void deleteCookies() {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}