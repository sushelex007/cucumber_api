package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;
import resources.APIValidatePlaceId;

public class Hooks 
{
	PlaceAPI place;
@Before("@del")
public void beforeDelete() throws IOException
{
	place = new PlaceAPI();
	if(PlaceAPI.post_place_id == null)
	{
		APIValidatePlaceId method = APIValidatePlaceId.valueOf("AddPlaceAPI");
		System.out.println(method.toString());
		
		place.add_place_API_payload_with_parameters_and("sushil", "arbi","Iran");
		place.user_calls_with_http_method(method.toString(), "post");
		place.delete_place_payload();
		
	}
}
}
