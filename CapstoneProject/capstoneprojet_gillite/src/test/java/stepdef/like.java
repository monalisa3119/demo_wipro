package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.likePages;
import pages.Scrennshot;
import stepdef.Hooks;
import utils.Base;

public class like extends Base {

    private likePages pages;
    private Scrennshot screnshot;
    private ExtentTest extentTest = Hooks.extentTest;

    @Given("I am on the Gillette India homepage product")
    public void i_am_on_the_gillette_india_homepage_product() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Opening the Gillette India homepage");
            openBrowser();
            pages = new likePages(driver);
            extentTest.pass("Successfully opened Gillette India homepage");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to open Gillette India homepage: " + e.getMessage());
        }
    }
 
    @When("I dragdown the page")
    public void i_dragdown_the_page() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Dragging down the page");
            pages.dragdown();
            extentTest.pass("Successfully dragged down the page");
        } catch (Exception e) {
        	screnshot.getScreenshot("_products_not_coming", driver);

            extentTest.log(Status.FAIL, "Failed to drag down the page: " + e.getMessage());
        }
    }

    @When("I liked any two products")
    public void i_liked_any_two_products() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Liking any two products");
            pages.likedtwoproducts();
            extentTest.pass("Successfully liked two products");
        } catch (Exception e) {
        	screnshot.getScreenshot("_products_not_coming", driver);

            extentTest.log(Status.FAIL, "Failed to like two products: " + e.getMessage());
        }
    }

    @When("I dragup the page")
    public void i_dragup_the_page() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Dragging up the page");
            pages.dragupthepage();
            extentTest.pass("Successfully dragged up the page");
        } catch (Exception e) {
        	screnshot.getScreenshot("_products_not_coming", driver);

            extentTest.log(Status.FAIL, "Failed to drag up the page: " + e.getMessage());
        }
    }

    @When("I clicked the likedbutton")
    public void i_clicked_the_likedbutton() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking the liked button");
            pages.likeanydanytwoproducts();
            extentTest.pass("Successfully clicked the liked button");
        } catch (Exception e) {
        	screnshot.getScreenshot("_products_not_coming", driver);

            extentTest.log(Status.FAIL, "Failed to click the liked button: " + e.getMessage());
        }
    }

    @Then("I validate the two products is here")
    public void i_validate_the_two_products_is_here() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Validating that the two products are present");
            pages.checktwoproductshere();
            extentTest.pass("Validated that the two products are present");
        } catch (Exception e) {
        	screnshot.getScreenshot("_products_not_coming", driver);
            extentTest.log(Status.FAIL, "Failed to validate that the two products are present: " + e.getMessage());

        }
    }
   
    
}
