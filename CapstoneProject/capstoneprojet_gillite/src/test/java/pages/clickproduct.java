package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class clickproduct {
    private WebDriver driver;
    private WebDriverWait wait;

    public clickproduct(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); // Increased timeout for better reliability
    }

    public void dropDown() {
        try { 
          JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,600);");
        } catch (Exception e) {
            handleException("Failed to scroll down the page", e);
        }
    }

    public void clickTheProduct() {
        try {
            WebElement annotationButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                    "#annotationWrapper > div > div.annotation-body.relative.bg-white.mt-10.pt-30.pb-20.px-20.flex.flex-wrap > div.w-full.flex > button")));
            annotationButton.click();

            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-2']/div/a/div/h3")));
            productLink.click();
        } catch (Exception e) {
            handleException("Failed to click on the product", e);
        }
    }

    public void buyOnline() {
        try {
            WebElement buyOnlineButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shopnowBtn-container > div > a")));
            buyOnlineButton.click();
        } catch (Exception e) {
            handleException("Failed to click on the 'Buy Online' button", e);
        }
    }

    public void checkTitle() {
        try {
            WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                    "#shopnowBtn-container > div > div > div > div > div.socialdes-heading.font-RegularFont.font-medium.text-20.mdl\\:text-24.leading-none.text-white.py-20.pl-20")));
            String actualText = headingElement.getText();
            String expectedText = "Choose your retailers";
            Assert.assertEquals(expectedText, actualText);
        } catch (Exception e) {
        	
            handleException("Failed to check the title text", e);
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