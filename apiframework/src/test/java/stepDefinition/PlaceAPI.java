package stepDefinition;
import static io.restassured.RestAssured.given;
import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.APIValidatePlaceId;
import resources.TestDataBuild;
import resources.TestUtilities;

public class PlaceAPI extends TestUtilities
{
	TestDataBuild data = new TestDataBuild();
	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	JsonPath jp;
	String place_id;
	String post_place_id;
	String get_name;
	String post_name;

	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String res) 
	{
		System.out.println(name+"   "+res);
		APIValidatePlaceId place_id = APIValidatePlaceId.valueOf(res);
		response = req.queryParam("place_id", post_place_id).when().get(place_id.getResource()).then().log().all().spec(resSpec).extract().response();
		get_name = getJsonPathValue("name");
		Assert.assertEquals(get_name, name, "name not matched");
	}
	
	public String getJsonPathValue(String key)
	{
		String res_str = response.asString();
		JsonPath jp = new JsonPath(res_str);
		return jp.get(key);
		
	}
	
	@When("user calls {string} with {string} http method")
	public void user_calls_with_http_method(String resource, String method) 
	{
		APIResources resources = APIResources.valueOf(resource);
	    System.out.println(resources.getResource());
	    if(method.equalsIgnoreCase("post"))
	    {
	    	response = req.post(resources.getResource()).then().spec(getResponseSpecification()).extract().response();
	    	post_place_id = getJsonPathValue("place_id");
//	    	post_name = getJsonPathValue("name");
	    }
	    if(method.equalsIgnoreCase("get"))
	    {
	    	response = req.get(resources.getResource()).then().spec(getResponseSpecification()).extract().response();
	    }
	    
	    
	}
	
	@Given("Add place API payload with parameters {string} {string} and {string}")
	public void add_place_API_payload_with_parameters_and(String name, String lang, String add) throws IOException 
	{
		data.addPlacepayload(name, lang, add);
		req = given().spec(getRequestSpecifications()).body(data.addPlacepayload(name, lang, add));
	
	}
	
	@Given("Add place API payload")
	public void add_place_API_payload() throws IOException {
		req = given().spec(getRequestSpecifications()).body(data.addPlacepayload());
	   
	}

	@When("user calls {string} with Post http method")
	public void user_calls_with_Post_http_method(String string) {
	    response = req.when().post("/maps/api/place/add/json").then().spec(getResponseSpecification()).extract().response();
	
	}

	@Then("the API call got successfull with status code {int}")
	public void the_API_call_got_successfull_with_status_code(Integer int1) {
	   
	    Assert.assertEquals(Integer.valueOf(response.getStatusCode()), int1);
	 
	}

	@Then("{string} is response body is {string}")
	public void is_response_body_is(String string, String string2) {
		String responseString = response.asString();
		jp = new JsonPath(responseString);
	//   Assert.assertEquals(jp.get(string), string2);
	 
	}


	

}
