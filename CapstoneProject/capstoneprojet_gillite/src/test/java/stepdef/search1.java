package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;
import pages.Scrennshot;
import utils.Base;

public class search1 extends Base {

	private Homepage homepage;
	private Scrennshot screenshot;
	private ExtentTest extentTest = Hooks.extentTest;

	@Given("I am on the Gillette India homepage")
	public void i_am_on_the_gillette_india_homepage() {
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

	@When("I clicked search bar")
	public void i_clicked_search_bar() {
		if (extentTest == null) {
			throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
		}
		try {
			extentTest.info("Clicking on the search bar");
			homepage = new Homepage(driver);
			homepage.selectseachbar();
			extentTest.pass("Clicked search bar successfully");
		} catch (Exception e) {
			screenshot.getScreenshot("Search bar", driver);

			extentTest.log(Status.FAIL, "Failed to click search bar: " + e.getMessage());
		}
	}

	@When("I enter razor into the searchbar")
	public void i_enter_razor_into_the_searchbar() {
		if (extentTest == null) {
			throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
		}
		try {
			extentTest.info("Entering 'razor' into the search bar");
			homepage = new Homepage(driver);
			homepage.enterSearchTerm();
			extentTest.pass("Entered 'razor' into the search bar successfully");
		} catch (Exception e) {
			screenshot.getScreenshot("Search bar", driver);

			extentTest.log(Status.FAIL, "Failed to enter 'razor' into the search bar: " + e.getMessage());
		}
	}

	

	@Then("I should see search results for razor check with tittle")
	public void i_should_see_search_results_for_razor_check_with_tittle() {
		if (extentTest == null) {
			throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
		}
		try {
			extentTest.info("Checking search results for 'razor'");
			homepage = new Homepage(driver);
			homepage.clickproducts();
			homepage.checkproductcoming();
			extentTest.pass("Search results for 'razor' displayed correctly");
		} catch (Exception e) {
			screenshot.getScreenshot("1_products_coming", driver);

			extentTest.log(Status.FAIL, "Failed to see search results for 'razor': " + e.getMessage());
		}
	}

	@When("I click on search bar")
	public void i_click_on_search_bar() {
		if (extentTest == null) {
			throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
		}
		try {
			extentTest.info("Clicking on the search bar again");
			homepage = new Homepage(driver);
			homepage.selectseachbar();
			extentTest.pass("Clicked on search bar successfully");
			
		} catch (Exception e) {
			screenshot.getScreenshot("Search bar", driver);

			extentTest.log(Status.FAIL, "Failed to click on search bar: " + e.getMessage());
		}
	}

	@When("I search product name is gillite1234")
	public void i_search_product_name_is_gillite1234() {
		if (extentTest == null) {
			throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
		}
		try {
			extentTest.info("Searching for product name 'gillite1234'");
			homepage = new Homepage(driver);
			homepage.enterSearchinvallid();
			extentTest.pass("Searched for product name 'gillite1234'");
		} catch (Exception e) {
			screenshot.getScreenshot("0_products_not_coming", driver);

			extentTest.log(Status.FAIL, "Failed to search for product name 'gillite1234': " + e.getMessage());
		}
	}

	
		@Then("I validate the products are coming")
		public void i_validate_the_products_are_coming() {
			if (extentTest == null) {
				throw new NullPointerException("ExtentTest is not initialized. Please check your Hooks class.");
			}
			try {
				extentTest.info("Checking search results for 'razor'");
				homepage = new Homepage(driver);
				homepage.clickproducts();
				homepage.nocheckproductcoming();
				extentTest.pass("Search results for 'razor' displayed correctly");
			} catch (Exception e) {
				screenshot.getScreenshot("1_products_coming", driver);

				extentTest.log(Status.FAIL, "Failed to see search results for 'razor': " + e.getMessage());
			}

			
		}
}