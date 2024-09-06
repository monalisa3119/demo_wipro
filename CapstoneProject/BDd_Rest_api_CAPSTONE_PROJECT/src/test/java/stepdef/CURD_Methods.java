package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CURD_Methods {
	private Response res;
	private ExtentTest extentTest = Hooks.extentTest;
	
	@Given("I have a base url of {string}")
	public void i_have_a_base_url_of(String URL) {
		try {
			extentTest.info("Base URI set to: " + URL);
			baseURI = URL;
			extentTest.log(Status.PASS, "Base URI set to: " + URL);
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to set Base URI: " + e.getMessage());
		}
		
		
	    	}

	@When("I send a GEt request to {string}")
	public void i_send_a_g_et_request_to(String endpoint) {
		try {
			extentTest.info("Sending GET request to: " + endpoint);
			res = given().log().all().when().get(endpoint);

			Hooks.extentTest.pass("GET request sent successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to send GET request: " + e.getMessage());
		}
	    	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		try {
			extentTest.info("Validating response status code should be: " + statusCode);
			res.then().log().all().statusCode(statusCode);
			Hooks.extentTest.pass("Response status code validated successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to validate response status code: " + e.getMessage());
		}
	   
	}
	    
	

	@When("I send a GeT ONE request to {string}")
	public void i_send_a_ge_t_one_request_to(String endpoint) {
		try {
			extentTest.info("Sending GET ONE request to: " + endpoint);
			res = given().log().all().when().get(endpoint);
			extentTest.pass("GET ONE request sent successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to send GET ONE request: " + e.getMessage());
		}

	    
	}
	@Then("the response status code shouldbe {int}")
	public void the_response_status_code_shouldbe(Integer int1) {
		try {
			extentTest.info("Validating response status code should be: " + int1);
			res.then().log().all().statusCode(int1);
			Hooks.extentTest.pass("Response status code validated successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to validate response status code: " + e.getMessage());
		}
	   
	}
	
	    
	

	@When("I send a Delete request to {string}")
	public void i_send_a_delete_request_to(String delete) {
		try {
			extentTest.info("Sending DELETE request to: " + delete);
			res = given().log().all().when().delete(delete);
			extentTest.pass("DELETE request sent successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to send DELETE request: " + e.getMessage());
		}
	    
	}

	@Then("the responsed status code should be {int}")
	public void the_responsed_status_code_should_be(Integer int1) {
		try {
			extentTest.info("Validating response status code should be: " + int1);
			res.then().log().all().statusCode(int1);
			Hooks.extentTest.pass("Response status code validated successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to validate response status code: " + e.getMessage());
		}
	}
	    
	

	@When("i send a post request to {string} with the body of {string}")
	public void i_send_a_post_request_to_with_the_body_of(String endpoint, String body) {
		try {
			extentTest.info("Sending POST request to: " + endpoint + " with body: " + body);
			res = given().log().all()
					.body(body).when().post(endpoint);
			extentTest.pass("POST request sent successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to send POST request: " + e.getMessage());
		}    
	}

	@Then("the time is lessthan 5000ms")
	public void the_time_is_lessthan_5000ms() {
		try {
			extentTest.info("Validating response time is less than 5000ms");
			res.then().log().all()
			.time(lessThan(5000L));
			extentTest.pass("Response time validated successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to validate response time: " + e.getMessage());
		}
	    
	}

	@When("i send a put to {string} with the body of {string}")
	public void i_send_a_put_to_with_the_body_of(String endpoint, String body) {
		try {
			extentTest.info("Sending put request to: " + endpoint + " with body: " + body);

			res = given()
					.log().all()
				

					.body(body).when().put(endpoint);
			extentTest.pass("put request sent successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to send put request: " + e.getMessage());
		}

	}
	
	
	@Then("the time is lessthan3 5000ms")
	public void the_time_is_lessthan3_5000ms() {
		try {
			extentTest.info("Validating response time is less than 5000ms");
			res.then().log().all()
			.time(lessThan(5000L));
			extentTest.pass("Response time validated successfully.");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Failed to validate response time: " + e.getMessage());
		}

	    
	}




}
