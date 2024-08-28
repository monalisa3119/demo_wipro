package basic;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class restmilestone4Test {

	@BeforeClass

	public void setup() {

		RestAssured.baseURI = "https://reqres.in";

	}

	@Test(priority = 1)

	public void testGetUsers() {

		RestAssured.given()

				.when()

				.get("/api/users?page=2")

				.then()

				.statusCode(200)

				.body("page", equalTo(2))

				.body("data", notNullValue())

				.log().all();

	}

	@Test(priority = 2)

	public void testGetUserById() {

		RestAssured.given()

				.when()

				.get("/api/users/2")

				.then()

				.statusCode(200)

				.body("data.id", equalTo(2))

				.body("data.email", equalTo("janet.weaver@reqres.in"))

				.body("data.first_name", equalTo("Janet"))

				.body("data.last_name", equalTo("Weaver"));

	}

	@Test(priority = 3)

	public void testCreateUser() {

		String requestBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

		RestAssured.given()

				.body(requestBody)

				.when()

				.post("/api/users")

				.then()

				.statusCode(201);

	}

	@Test(priority = 4)

	public void testUpdateUser() {

		String requestBody = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

		RestAssured.given()

				.body(requestBody)

				.when()

				.put("/api/users/2")

				.then()

				.statusCode(200);

	}

	@Test(priority = 5)

	public void testPatchUser() {

		String requestBody = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

		RestAssured.given()

				.body(requestBody)

				.when()

				.patch("/api/users/2")

				.then()

				.statusCode(200);

	}

	@Test(priority = 6)

	public void testDeleteUser() {

		RestAssured.given()

				.when()

				.delete("/api/users/2")

				.then()

				.statusCode(204);

	}

}
