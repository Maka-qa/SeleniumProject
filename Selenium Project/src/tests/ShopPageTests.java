package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopPageTests extends BaseTests {
	
	@BeforeMethod
	public void navigateToPage() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void searchWithBlankField()  {
		String expected = excelReader.getStringData("TSu4", 10, 3);
		shopPage.clickOnSearchButton();
		assertEquals(shopPage.textFromFoundResultLabel(), expected);
		
	}
	
	//Verify that when user starts typing word in "Search" box it suggests results that matches typed keyword:
	@Test(priority = 3)
	public void checkSuggestedResults() {
		String keyword = excelReader.getStringData("TSu4", 18, 3);
		shopPage.insertTextIntoSearchField(keyword);
		int expected = shopPage.sizeOfSuggestedResultsList();
		int actual = shopPage.howManyContainWord(keyword);
		
		assertEquals(actual, expected, "All suggested results doesn't contain keyword!");
		
		
	}
	
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}