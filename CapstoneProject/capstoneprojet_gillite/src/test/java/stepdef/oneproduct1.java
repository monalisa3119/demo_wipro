package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Scrennshot;
import pages.clickproduct;
import utils.Base;

public class oneproduct1 extends Base {
    private clickproduct clickproducT;
    private Scrennshot screnshot;
    private ExtentTest extentTest = Hooks.extentTest;
    @Given("I am on the Gillett India homepage products")
    public void i_am_on_the_gillett_india_homepage_products() {
     //ExtentTest test = Hooks.getTest();
        try {
            openBrowser();
            extentTest.log(Status.PASS, "Opened the browser successfully");
        } catch (Exception e) {
        	
        	extentTest.log(Status.FAIL, "Failed to open the browser: " + e.getMessage());
        }
    }

    @When("I dragdowned the pages")
    public void i_dragdowned_the_pages() {
       // ExtentTest test = Hooks.getTest();
        try {
            clickproducT = new clickproduct(driver);
            clickproducT.dropDown();
            extentTest.log(Status.PASS, "Dragged down the page successfully");
        } catch (Exception e) {
        	screnshot.getScreenshot("page is not dragged", driver);

        	extentTest.log(Status.FAIL, "Failed to drag down the page: " + e.getMessage());
        }
    }
    @When("I clicked on GilletteLabs Guard shaving Razor  products")
    public void i_clicked_on_gillette_labs_guard_shaving_razor_products() {
    	 //  ExtentTest test = Hooks.getTest();
        try {
            clickproducT = new clickproduct(driver);
            clickproducT.clickTheProduct();
            extentTest.log(Status.PASS, "Clicked on GilletteLabs Guard shaving Razor products successfully");
        } catch (Exception e) {
        	screnshot.getScreenshot("_products_not_coming", driver);

        	extentTest.log(Status.FAIL, "Failed to click on GilletteLabs Guard shaving Razor products: " + e.getMessage());
        }
    }

 



   

    @When("I clicked on Buy Onlines")
    public void i_clicked_on_buy_onlines() {
       // ExtentTest test = Hooks.getTest();
        try {
            clickproducT = new clickproduct(driver);
            clickproducT.buyOnline();
            extentTest.log(Status.PASS, "Clicked on Buy Online successfully");
        } catch (Exception e) {
        	screnshot.getScreenshot("Buy online", driver);

        	extentTest.log(Status.FAIL, "Failed to click on Buy Online: " + e.getMessage());
        }
    }

   
    @Then("I should see search results for razor check the with titles")
    public void i_should_see_search_results_for_razor_check_the_with_titles() {
    	try {
            clickproducT = new clickproduct(driver);
            clickproducT.checkTitle();
            extentTest.log(Status.PASS, "Checked the titles of search results for razor successfully");
        } catch (Exception e) {
        	
        	extentTest.log(Status.FAIL, "Failed to check the titles of search results for razor: " + e.getMessage());
        	screnshot.getScreenshot("retialers", driver);

        }
     
    }
}
