package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationForm {
	//form for creating account
	WebDriver driver;
	WebElement personalInfoLabel;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement passwordInputField;
	WebElement addressInputField;	
	WebElement cityInputField;
	Select stateDropDownManu;
	WebElement mobilePhoneInputField;
	WebElement postalCodeInputField;
	WebElement adressAliasInputField;
	WebElement registerButton;
	WebElement saveAddressUpdateButton;

	public PersonalInformationForm(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getPersonalInfoLabel() {
		return driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3"));
	}

	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("customer_firstname"));
	}
	
	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("customer_lastname"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}

	public Select getStateDropDownManu() {
		stateDropDownManu = new Select(driver.findElement(By.id("id_state")));
		return stateDropDownManu;
	}

	public WebElement getMobilePhoneInputField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getPostalCodeInputField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getAdressAliasInputField() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getRegisterButton() {
		return driver.findElement(By.id("submitAccount"));
	}
	
	public WebElement getSaveAddressUpdateButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public String textFromPersonalInfoLabe() {
		return this.getPersonalInfoLabel().getText();
	}
	
	public void insertFirstName(String firstName) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(firstName);
		
	}
	public void insertLastName(String lastName) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(lastName);
		
	}
	public void insertPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);
		
	}
	public void insertAddress(String address) {
		this.getAddressInputField().clear();
		this.getAddressInputField().sendKeys(address);
		
	}
	public void insertCity(String city) {
		this.getCityInputField().clear();
		this.getCityInputField().sendKeys(city);
		
	}
	public void insertMobilePhone(String phone) {
		this.getMobilePhoneInputField().clear();
		this.getMobilePhoneInputField().sendKeys(phone);
		
	}
	public void insertPostalCode(String postalCode) {
		this.getPostalCodeInputField().clear();
		this.getPostalCodeInputField().sendKeys(postalCode);
		
	}
	public void insertAddressAlias(String alias) {
		this.getAdressAliasInputField().clear();
		this.getAdressAliasInputField().sendKeys(alias);
		
	}
	public void selectState(String state) {
		 this.getStateDropDownManu().selectByVisibleText(state);
	}
	public void clickOnRegisterButton() {
		this.getRegisterButton().click();
		
	}
	public void clickOnSaveAddressUpdateButton() {
		this.getSaveAddressUpdateButton().click();
	}
}