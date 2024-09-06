package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class searchoutlinepage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Scrennshot screenshot;
    public searchoutlinepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(30)); // Initialize WebDriverWait with a 10-second timeout
    }

    public void clickSearchBar() {
        try {
            WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='searchIconId']")));
            searchIcon.click();
            pause(1000); // Use explicit waits instead of hardcoded pauses where possible
        } catch (Exception e) {
            handleException("Failed to click the search bar", e);
        } 
    }

    public void searchBar(String query) {
        try {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-box-input")));
            searchBox.sendKeys(query);
            searchBox.sendKeys(Keys.ENTER);
            pause(1000); // Use explicit waits instead of hardcoded pauses where possible
        } catch (Exception e) {
            handleException("Failed to enter text in the search bar", e);
        }
    }

    public void selectProduct() {
        try {
            WebElement productTab = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "#main-content > div > div.search-tabs-wrapper > div > a.tab-btn.search-tab.pb-6.px-20.font-RegularFont.text-14.font-medium.tracking-xnormal.mdl\\:mr-40.mdl\\:px-0.text-warm-grey.cursor-pointer.text-14.leading-20.event_menu_click > span:nth-child(1) > span > span")));
            productTab.click();
        } catch (Exception e) {
            handleException("Failed to select the product tab", e);
        }
    }

    public void verifyTitle() {
        try {
            String actualTitle = driver.getTitle();
            String expectedTitle = "Search For Shaving Products And Articles | Gillette India";
            Assert.assertEquals(expectedTitle, actualTitle);
        } catch (Exception e) {
 			screenshot.getScreenshot("_products_not_coming", driver);

            handleException("Failed to verify the page title", e);
        }
    }

    private void handleException(String message, Exception e) {
        // Handle exception (e.g., log it, take a screenshot, etc.)
        System.err.println(message + ": " + e.getMessage());
        // Optionally: capture screenshot on failure
        takeScreenshot(message);
    }

    private void takeScreenshot(String screenshotName) {
        try {
            // Assuming you have a method to take screenshots (not provided in your code)
            // Replace with your screenshot logic if needed
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
       
        	driver.quit();
      
    }

    // Consider using explicit waits instead of hardcoded pauses
    private void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Pause interrupted: " + e.getMessage());
        }
    }
}
