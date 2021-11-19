package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {

	WebDriver driver;
	WebElement searchButton;
	WebElement searchField;
	WebElement foundResultLabel;
	List<WebElement> suggestedResultsList;

	public ShopPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSearchButton() {
		return driver.findElement(By.name("submit_search"));
	}

	public WebElement getSearchField() {
		return driver.findElement(By.id("search_query_top"));
	}

	public WebElement getFoundResultLabel() {
		return driver.findElement(By.className("heading-counter"));
	}

	public List<WebElement> getsuggestedResultsList() {
		return driver.findElements(By.cssSelector(".ac_results>ul li"));
	}

	public void clickOnSearchButton() {
		this.getSearchButton().submit();
	}

	public String textFromFoundResultLabel() {
		return this.getFoundResultLabel().getText();
	}

	public void insertTextIntoSearchField(String keyword) {
		this.getSearchField().clear();
		this.getSearchField().sendKeys(keyword);
	}

	public int sizeOfSuggestedResultsList() {
		return this.getsuggestedResultsList().size();
	}

	public int howManyContainWord(String keyword) {
		int counter = 0;
		for (int i = 0; i < sizeOfSuggestedResultsList(); i++) {
			if (this.getsuggestedResultsList().get(i).getText().toLowerCase().contains(keyword.toLowerCase())) {
				counter++;
			}
		}
		return counter;

	}

}