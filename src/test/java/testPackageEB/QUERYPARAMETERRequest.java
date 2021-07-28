package testPackageEB;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QUERYPARAMETERRequest {

	@Test(priority=2)
	public void queryParameter() {

		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/";
		RequestSpecification request = RestAssured.given();

		Response response = request.queryParam("q", "London,UK").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
				.get("/weather");

		String jsonString = response.asString();
		System.out.println(response.getStatusCode());
		System.out.println(jsonString);
		Assert.assertEquals(jsonString.contains("London"), true);

	}
	
	@Test(priority=1)
	 public void GetWeatherDetails()
	 { 
	 System.out.println("I am GetWeatherDetails method");
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	 
	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	 Response response = httpRequest.request(Method.GET, "/Hyderabad");
	 
	 // Now let us print the body of the message to see what response
	 // we have recieved from the server
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody);
	 
	 }
}