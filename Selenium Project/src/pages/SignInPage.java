package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

public class SignInPage {

	WebDriver driver;
	WebElement emailInputField; // email for registration field
	WebElement createAnAccountButton;
	WebElement createAcountErrorAlert; // when trying to register twice with the same email adress
	WebElement invalidEmailAlert; //when trying to register
	WebElement emailSignInInputField; // email for sign in field
	WebElement passwordInputField;
	WebElement signInButton; 
	WebElement emailSignInAlert;
	WebElement invalidPasswordAlert;

	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email_create"));
	}

	public WebElement getCreateAnAccountButton() {
		return driver.findElement(By.id("SubmitCreate"));
	}

	public WebElement getCreateAcountErrorAlert() {
		return driver.findElement(By.id("create_account_error"));
	}

	public WebElement getInvalidEmailAlert() {
		return driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
	}

	public WebElement getEmailSignInInputField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getEmailSignInAlert() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	
	public WebElement getInvalidPasswordAlert() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public void insertEmail(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
	}

	public void clickOnCreateAnAccount() {
		this.getCreateAnAccountButton().submit();
	}

	public boolean isErrorAlertDisplayed() {
		return this.getCreateAcountErrorAlert().isDisplayed();
	}

	public boolean isInvalidEmailAlertDisplayed() {
		return this.getInvalidEmailAlert().isDisplayed();
	}

	public void insertEmailForSignIn(String email) {
		this.getEmailSignInInputField().clear();
		this.getEmailSignInInputField().sendKeys(email);
	}

	public void insertPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);
	}

	public void clickOnSignInButton() {
		this.getSignInButton().click();

	}
	public String emailSignInAlert() {
		return this.getEmailSignInAlert().getText();
	}
	
	public String passwordAlert() {
		return this.getInvalidPasswordAlert().getText();
	}
}