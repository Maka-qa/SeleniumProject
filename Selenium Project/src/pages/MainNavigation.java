package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation {
	
	WebDriver driver;
	WebElement signInButton;
	WebElement signOutButton;
	WebElement nameSurnameButton; //navigation to my account


	public MainNavigation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	

	public WebElement getNameSurnameButton() {
		return driver.findElement(By.className("account"));
	}

	public void clickOnSignInButton() {
		this.getSignInButton().click();
	}
	
	public void clickOnSignOutButton() {
		this.getSignOutButton().click();
	}
	
	public boolean isSignOutDisplayed() {
		return this.getSignOutButton().isDisplayed();
	}
	public void clickOnNameSurnameButton() {
		this.getNameSurnameButton().click();
	}
	public String textFromSignInButton() {
		return this.getSignInButton().getText();
	}
	
	public String textFromNameSurnameButton() {
		return this.getNameSurnameButton().getText();
	}

}