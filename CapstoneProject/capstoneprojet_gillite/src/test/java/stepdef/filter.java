package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Scrennshot;
import pages.filterpage;
import stepdef.Hooks;
import utils.Base;

public class filter extends Base {

    private filterpage productpag;
    private Scrennshot screenshot;
    private ExtentTest extentTest = Hooks.extentTest;

    @Given("I am on the Gillette India homepages")
    public void i_am_on_the_gillette_india_homepages() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Opening the Gillette India homepage");
            openBrowser();
            extentTest.pass("Successfully opened Gillette India homepage");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to open Gillette India homepage: " + e.getMessage());
        }
    }

    @When("I dragdown the page visbile filter")
    public void i_dragdown_the_page_visbile_filter() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Dragging down to visible filter");
            productpag = new filterpage(driver);
            productpag.dragDown();
            extentTest.pass("Dragged down to visible filter successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to drag down to visible filter: " + e.getMessage());
        }
    }

    @When("I clicked filter")
    public void i_clicked_filter() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on filter");
            productpag = new filterpage(driver);
            productpag.clickFilter();
            extentTest.pass("Clicked on filter successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to click on filter: " + e.getMessage());
        }
    }

    @When("I clicked razor type")
    public void i_clicked_razor_type() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on razor type");
            productpag = new filterpage(driver);
            productpag.clickRazorType();
            extentTest.pass("Clicked on razor type successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to click on razor type: " + e.getMessage());
        }
    }

    @When("I select the Manula selector")
    public void i_select_the_manula_selector() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Selecting the Manual selector");
            productpag = new filterpage(driver);
            productpag.manualSelect();
            extentTest.pass("Selected the Manual selector successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to select the Manual selector: " + e.getMessage());
        }
    }

    @When("I clicked By brands")
    public void i_clicked_by_brands() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on By brands");
            productpag = new filterpage(driver);
            productpag.clickBrand();
            extentTest.pass("Clicked on By brands successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to click on By brands: " + e.getMessage());
        }
    }

    @When("I select Guard")
    public void i_select_guard() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Selecting Guard");
            productpag = new filterpage(driver);
            productpag.selectGuard();
            extentTest.pass("Selected Guard successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to select Guard: " + e.getMessage());
        }
    }

    @When("I click Apply filters")
    public void i_click_apply_filters() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on Apply filters");
            productpag = new filterpage(driver);
            productpag.clickApplyFilter();
            extentTest.pass("Clicked on Apply filters successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to click on Apply filters: " + e.getMessage());
        }
    }

    @When("I click got it")
    public void i_click_got_it() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Clicking on Got It");
            productpag = new filterpage(driver);
            productpag.clickGotIt();
            extentTest.pass("Clicked on Got It successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to click on Got It: " + e.getMessage());
        }
    }

    @Then("I should see search results")
    public void i_should_see_search_results() {
        if (extentTest == null) {
            throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
        }
        try {
            extentTest.info("Checking search results");
            productpag = new filterpage(driver);
            productpag.checkTitle();
            extentTest.pass("Search results are displayed correctly");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to see search results: " + e.getMessage());
        }
    }

    }

