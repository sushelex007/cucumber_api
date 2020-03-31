package resources;

public enum APIValidatePlaceId 
{
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	AddPlaceAPI("/maps/api/place/add/json");
	String resource;
	
	APIValidatePlaceId(String res)
	{
		this.resource = res;
	}
	
	public String getResource()
	{
		return resource;
	}
	 
}
