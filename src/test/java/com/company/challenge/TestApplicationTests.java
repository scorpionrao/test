package com.company.challenge;

import com.company.challenge.model.RestApiResult;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:/application.properties"})
public class TestApplicationTests {

	@LocalServerPort
	protected int port;

	protected RequestSpecification reqBaseSpec() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("http://localhost").setPort(port);
		requestSpecBuilder.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		return requestSpecBuilder.build();
	}

	private ResponseSpecification respJsonOk() {
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	@Test
	public void testHelloApi() throws Exception {

		// @formatter:off
		Response response = given(reqBaseSpec())
				.when()
				.get("/hello")
				.then()
                .log().body()
				.spec(respJsonOk())
                .extract().response();
        // @formatter:on

        ResponseBody responseBody = response.getBody();
        RestApiResult<LinkedHashMap> restApiResult = responseBody.as(RestApiResult.class);

        LinkedHashMap map = restApiResult.getResult();

        Assert.assertEquals("Greetings", map.get("welcomeText"));

	}
}

