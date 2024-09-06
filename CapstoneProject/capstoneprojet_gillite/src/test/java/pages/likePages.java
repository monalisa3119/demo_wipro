package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utils.Base;

public class likePages {
	private WebDriver driver;
	private Scrennshot screnshot;
	public likePages(WebDriver driver) {
		this.driver=driver;
	}
	public void dragdown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
		
		
	}
	public void likedtwoproducts() {
		driver.findElement(By.cssSelector("#product-3 > div > button > svg")).click();
		Base.pause(1000);
		driver.findElement(By.cssSelector("#product-1 > div > button > svg")).click();

		
	}
	public void dragupthepage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200);");
	  
	}
	public void likeanydanytwoproducts() {
		Base.pause(1000);
		driver.findElement(By.cssSelector("#heartIcon > svg > rect")).click();

		
	
	}
	public void checktwoproductshere() {
		try {
		String actresult=driver.findElement(By.cssSelector("#wrap > div > div:nth-child(3) > div > a.tab-btn.fav-tab.mr-40.text-14.text-navy-dark-blue.active.font-medium.cursor-pointer.text-14.leading-20.event_menu_click > span:nth-child(1) > span > span")).getText();
	     String expectedresult="PRODUCTS - 02";
		Assert.assertEquals(expectedresult, actresult);
		screnshot=new Scrennshot(driver);
    	screnshot.getScreenshot("_products_not_coming", driver);
		
		}
		catch(Exception e) {
        	screnshot=new Scrennshot(driver);
        	screnshot.getScreenshot("_products_not_coming", driver);
        	e.printStackTrace();

			
		}

		
	}
	
}



