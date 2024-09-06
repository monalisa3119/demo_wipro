package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.searchoutlinepage;
import utils.Base;
import pages.Scrennshot;
//import stepdf.Hooks;

public class searchoutline extends Base {

    private searchoutlinepage searchoutline;
    private Scrennshot screnshot;
    private ExtentTest extentTest = Hooks.extentTest;
    @Given("I am on the Gillette India homepages opendd")
    public void i_am_on_the_gillette_india_homepages_opendd() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Opening the Gillette India homepage");
            openBrowser();
            searchoutline = new searchoutlinepage(driver);
            extentTest.pass("Successfully opened Gillette India homepage");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to open Gillette India homepage: " + e.getMessage());
        }
    }

    @When("I clicked search Bar")
    public void i_clicked_search_bar() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on the search bar");
            searchoutline = new searchoutlinepage(driver);
            searchoutline.clickSearchBar();;
            extentTest.pass("Clicked on search bar successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to click on search bar: " + e.getMessage());
        }
    }

    @When("I enter {string} into the searchbar")
    public void i_enter_into_the_searchbar(String string) {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Entering '" + string + "' into the search bar");
            searchoutline = new searchoutlinepage(driver);
            searchoutline.searchBar(string);
            extentTest.pass("Entered '" + string + "' into the search bar successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to enter '" + string + "' into the search bar: " + e.getMessage());
        }
    }

    @When("I click the product")
    public void i_click_the_product() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on the product");
            searchoutline = new searchoutlinepage(driver);
            searchoutline.selectProduct();
            extentTest.pass("Clicked on the product successfully");
        } catch (Exception e) {
            screnshot=new Scrennshot(driver);

         	screnshot.getScreenshot("product page", driver);

            extentTest.log(Status.FAIL, "Failed to click on the product: " + e.getMessage());
        }
    }
    @Then("I should see search results for  check with tittle")
    public void i_should_see_search_results_for_check_with_tittle() {
    	 if (extentTest == null) {
             throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
         }
         try {
             extentTest.info("Checking search results for");
             searchoutline = new searchoutlinepage(driver);
             searchoutline.verifyTitle();
             extentTest.pass("Search results for ' are displayed correctly");
         } catch (Exception e) {
             screnshot=new Scrennshot(driver);

         	screnshot.getScreenshot("_products_not_coming", driver);

             extentTest.log(Status.FAIL, "Failed to see search results for '" + e.getMessage());
         }
         
     

   
    }
}