package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MyAccountPage {

	WebDriver driver;
	WebElement personalInfoTab;
	WebElement myAddressesTab;
	WebElement myWishListsTab;
	WebElement mrRadioButton;
	WebElement mrsRadioButton;
	WebElement curentPassswordInputField;
	WebElement newPasswordInputField;
	WebElement confirmationInputField;
	WebElement saveButton;
	WebElement updateAddressButton;
	WebElement newAddressCheck;
	WebElement newCityCheck;
	WebElement newStateCheck;
	WebElement newPostalCodeCheck;
	WebElement addNewAddressButton;
	WebElement deleteAddressButton;
	List<WebElement> addressList;
	List<WebElement> deleteButtonsList;
	List<WebElement> updateButtonsList;
	WebElement succesfullUpdateLabel;
	Select selectDayOfBirth;
	Select selectMonthOfBirth;
	Select selectYearOfBirth;
	WebElement editFirstNameInputField;
	WebElement editLastNameInputField;
	List<WebElement> addresses1List;
	WebElement backToHomeButton;
	


	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getPersonalInfoTab() {
		return driver.findElement(By.linkText("MY PERSONAL INFORMATION"));
	}
	

	public WebElement getMyWishListsTab() {
		return driver.findElement(By.linkText("MY WISHLISTS"));
	}

	public WebElement getMrRadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}

	public WebElement getMrsRadioButton() {
		return driver.findElement(By.id("id_gender2"));
	}

	public WebElement getCurentPassswordInputField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getNewPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getConfirmationInputField() {
		return driver.findElement(By.id("confirmation"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	public WebElement getMyAddressesTab() {
		return driver.findElement(By.linkText("My addresses"));
	}

	public WebElement getUpdateAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getNewAddressCheck() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getNewCityCheck() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[1]"));
	}

	public WebElement getNewStateCheck() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[2]"));
	}

	public WebElement getNewPostalCodeCheck() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[3]"));
	}
	

	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span"));
	}
	

	public WebElement getDeleteAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div[2]/div/ul/li[9]/a[2]/span"));
	}	

	public WebElement getBackToHomeButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span"));
	}

	public List<WebElement> getAddressList() {
		return driver.findElements(By.className("page-subheading"));
	}
	
	public List<WebElement> getDeleteButtonsList() {
		return driver.findElements(By.cssSelector("a[title='Delete']"));
	}

	public List<WebElement> getUpdateButtonsList() {
		return driver.findElements(By.cssSelector("a[title='Update']"));
	}

	
	public List<WebElement> getAddresses1List() {
		return driver.findElements(By.className("address_address1"));
	}

	public WebElement getSuccesfullUpdateLabel() {
		return driver.findElement(By.cssSelector(".alert.alert-success"));
	}
	

	public Select getSelectDayOfBirth() {
		selectDayOfBirth = new Select(driver.findElement(By.id("days")));
		return selectDayOfBirth;
	}

	public Select getSelectMonthOfBirth() {
		selectMonthOfBirth = new Select(driver.findElement(By.id("months"))); 
		return selectMonthOfBirth;
	}

	public Select getSelectYearOfBirth() {
		selectYearOfBirth = new Select(driver.findElement(By.id("years")));
		return selectYearOfBirth;
	}

	public WebElement getEditFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getEditLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}
	

	

	public void clickOnPersonalInformation() {
		this.getPersonalInfoTab().click();
	}

	public void checkMrRadioButton() {
		this.getMrRadioButton().click();
	}

	public void checkMrsRadioButton() {
		this.getMrsRadioButton().click();
	}

	public boolean isMrChecked() {
		return this.getMrRadioButton().isSelected();

	}

	public boolean isMrsChecked() {
		return this.getMrsRadioButton().isSelected();

	}

	public void insertCurrentPassword(String password) {
		this.getCurentPassswordInputField().clear();
		this.getCurentPassswordInputField().sendKeys(password);

	}

	public void insertNewPassword(String password) {
		this.getNewPasswordInputField().clear();
		this.getNewPasswordInputField().sendKeys(password);

	}

	public void confirmNewPassword(String password) {
		this.getConfirmationInputField().clear();
		this.getConfirmationInputField().sendKeys(password);

	}

	public void clickOnSaveButton() {
		this.getSaveButton().click();

	}

	public void clickOnMyAddressesTab() {
		this.getMyAddressesTab().click();
	}

	public void clickOnUpdateAddressButton() {
		this.getUpdateAddressButton().click();
	}

	public String checkNewAddress() {
		return this.getNewAddressCheck().getText();

	}

	public String checkNewCity() {
		return this.getNewCityCheck().getText();
	}
	
	public String checkNewState() {
		return this.getNewStateCheck().getText();
	}
	
	public String checkNewPostalCode() {
		return this.getNewPostalCodeCheck().getText();
	}
	
	public void clickOnAddNewAddress() {
		this.getAddNewAddressButton().click();
		
	}
	
	public void clickOnDeleteAddress() {
		this.getDeleteAddressButton().click();
		
	}
	
	public String textFromSuccesfullUpdateLabel() {
		return this.getSuccesfullUpdateLabel().getText();
		
	}
	
	public void selectDayOfBirth(int day) {
		this.getSelectDayOfBirth().selectByIndex(day);
		
	}
	public void selectMonthOfBirth(String month) {
		this.getSelectMonthOfBirth().selectByValue(month);
		
	}
	public void selectYearOfBirth(String year) {
		this.getSelectYearOfBirth().selectByValue(year);
		
	}
	public String currentFirstName() {
		return this.getEditFirstNameInputField().getText();
	}
	public String currentLastName() {
		return this.getEditLastNameInputField().getText();
	}
	public void editFirstName(String name) {
		this.getEditFirstNameInputField().clear();
		this.getEditFirstNameInputField().sendKeys(name);
		
	}
	public void editLastName(String lastName) {
		this.getEditLastNameInputField().clear();
		this.getEditLastNameInputField().sendKeys(lastName);
		
	}
	public void clickOnMyWishListsTab() {
		this.getMyWishListsTab().click();
	}
	public void clickOnBackToHome() {
		this.getBackToHomeButton().click();
	}
}