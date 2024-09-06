package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Base;

public class Homepage extends Base {
	private WebDriver driver;
	 WebDriverWait wait;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		//super.driver=driver;
		
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
	}
	 By selectseachbar = By.xpath("//*[@id=\"searchIconId\"]");
	 By searchBar = By.id("search-box-input");

	public void selectseachbar() {
		driver.findElement(selectseachbar).click();
		
	}

	public void enterSearchTerm() {
		WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
		searchElement.clear(); // Clear the search bar before typing
		searchElement.sendKeys("razor");
		Base.pause(1000);
		searchElement.sendKeys(Keys.ENTER);
	}
	public void clickproducts() {
		  driver.findElement(By.cssSelector("#main-content > div > div.search-tabs-wrapper > div > a.tab-btn.search-tab.pb-6.px-20.font-RegularFont.text-14.font-medium.tracking-xnormal.mdl\\:mr-40.mdl\\:px-0.text-warm-grey.cursor-pointer.text-14.leading-20.event_menu_click > span:nth-child(1) > span > span")).click();

	}

	public void enterSearchinvallid() {
		WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
		searchElement.clear(); // Clear the search bar before typing
		searchElement.sendKeys("gillite1234");
		Base.pause(1000);
		searchElement.sendKeys(Keys.ENTER);
		
		
	}
	public void checkproductcoming(){
		String actresult = driver.findElement(By.cssSelector("#main-content > div > div.search-tabs-wrapper > div > a.tab-btn.search-tab.pb-6.px-20.font-RegularFont.text-14.font-medium.tracking-xnormal.mdl\\:mr-40.mdl\\:px-0.text-navy-dark-blue.active.font-medium.cursor-pointer.text-14.leading-20.event_menu_click > span:nth-child(1) > span > span"))
				.getText();
		String expectedresult = "PRODUCTS - 37";
		Assert.assertEquals(expectedresult, actresult);
	}
	public void nocheckproductcoming(){
		String actresult = driver.findElement(By.cssSelector(
				"#main-content > div > div.search-tabs-wrapper > div > a.tab-btn.search-tab.pb-6.px-20.font-RegularFont.text-14.font-medium.tracking-xnormal.mdl\\:mr-40.mdl\\:px-0.text-warm-grey.cursor-pointer.text-14.leading-20.event_menu_click > span:nth-child(1) > span > span"))
				.getText();
		String expectedresult = "ARTICLES - 00";
		Assert.assertEquals(expectedresult, actresult);
	}
	// Add other methods to interact with the homepage
}

