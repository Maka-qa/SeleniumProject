package pages;

import java.util.List;

import org.apache.xmlbeans.impl.tool.TypeHierarchyPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage {
	
	WebDriver driver;
	WebElement wishListNameInputField;
	WebElement saveWishListButton;
	WebElement wishListTable;
	WebElement product1;
	WebElement addToWishListButton;
	List<WebElement> productsList;
	WebElement viewProductAfterAdding;
	WebElement closePopUp;
	List<WebElement> deleteWishListButtons;
	List<WebElement> wishListsNamesList;
	
	public MyWishListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	

	public WebElement getWishListNameInputField() {
		return driver.findElement(By.id("name"));
	}
	
	public List<WebElement> getWishListsNamesList() {
		return driver.findElements(By.cssSelector("a[href=\"javascript:;\"]"));
	}


	public WebElement getSaveWishListButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getWishListTable() {
		return driver.findElement(By.tagName("table"));
	}
	
	public WebElement getProduct1() {
		return driver.findElement(By.linkText("Printed Chiffon Dress"));
	}
	
	public WebElement getAddToWishListButton() {
		return driver.findElement(By.id("wishlist_button"));
	}
	

	public WebElement getClosePopUp() {
		return driver.findElement(By.cssSelector("a[title='Close']"));
	}


	public List<WebElement> getProductsList() {
		return driver.findElements(By.className("product-name"));
	}
	
	public WebElement getViewProductAfterAdding() {
		return driver.findElement(By.id("s_title"));
	}


	public List<WebElement> getDeleteWishListButtons() {
		return driver.findElements(By.className("icon"));
	}


	public void insertNameOfWishlist(String name) {
		this.getWishListNameInputField().sendKeys(name);
	}
	
	
	public void clickOnSaveWishList() {
		this.getSaveWishListButton().click();
		
	}
	
	public void clickOnProduct1() {
		this.getProduct1().click();
	}
	public void addProductToWishList() {
		this.getAddToWishListButton().click();
	}
	public String textProductNameAfterAdding() {
		return this.getViewProductAfterAdding().getText();
	}
	
	public void closePopUp() {
		this.getClosePopUp().click();
	}
	public boolean isWishListTableDisplayed() {
		return this.getWishListTable().isDisplayed();
	}
}