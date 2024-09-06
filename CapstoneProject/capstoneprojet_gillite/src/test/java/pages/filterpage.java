package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class filterpage {
    private WebDriver driver;
    private WebDriverWait wait;

    public filterpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); // Increased timeout for explicit waits
    }

    public void dragDown() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200);");
        } catch (Exception e) {
            handleException("Failed to drag down the page", e);
        }
    }

    public void clickFilter() {
        try {
            WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#plpFilterButton > span.ml-10.relative > svg > g > path")));
            filterButton.click();
        } catch (Exception e) {
            handleException("Failed to click the filter button", e);
        }
    }

    public void clickRazorType() {
        try {
            WebElement razorTypeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                    "#plpFilterContentWrapper > div > button:nth-child(1) > span.my-auto.ml-auto.mr-10.mdl\\:mr-0 > svg")));
            razorTypeButton.click();
        } catch (Exception e) {
            handleException("Failed to click the razor type", e);
        }
    }

    public void manualSelect() {
        try {
            WebElement manualCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-facet_razorsblades_razortype_manual")));
            manualCheckbox.click();
        } catch (Exception e) {
            handleException("Failed to select manual razors", e);
        }
    }

    public void clickBrand() {
        try {
            WebElement brandButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='plpFilterContentWrapper']/div/button[3]")));
            brandButton.click();
        } catch (Exception e) {
            handleException("Failed to click the brand filter", e);
        }
    }

    public void selectGuard() {
        try {
            WebElement guardButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='plpFilterContentWrapper']/div/button[3]")));
            guardButton.click();
            WebElement guardCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-facet_razorsblades_bycollections_guard")));
            guardCheckbox.click();
        } catch (Exception e) {
            handleException("Failed to select the guard collection", e);
        }
    }

    public void clickApplyFilter() {
        try {
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            applyButton.click();
            WebElement filterApplyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                    "#react-portal > div.filter-wrapper.fixed.inset-0.mdl\\:left-unset.mdl\\:right-0.mdl\\:w-450.h-screen.z-50.mdl\\:px-30.pb-40.bg-white > div > div.clearAll-wrapper.fixed.bottom-0.mdl\\:bottom-2.w-full.mdl\\:w-450.mdl\\:px-30.mdl\\:right-0.flex > button.w-1\\/2.block.bg-navy-dark-blue.text-white.py-15.text-14.font-BoldFont.leading-none.event_button_click")));
            filterApplyButton.click();
        } catch (Exception e) {
            handleException("Failed to apply the filter", e);
        }
    }

    public void clickGotIt() {
        try {
            WebElement gotItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='annotationWrapper']/div/div[2]/div[4]/button")));
            gotItButton.click();
        } catch (Exception e) {
            handleException("Failed to click the 'Got It' button", e);
        }
    }

    public void checkTitle() {
        try {
            String actualTitle = driver.getTitle();
            String expectedTitle = "Discover Gillette Razors for Men | Gillette IN";
            Assert.assertEquals(expectedTitle, actualTitle);
        } catch (Exception e) {
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
    }
}
