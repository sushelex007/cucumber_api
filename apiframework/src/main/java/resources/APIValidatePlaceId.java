package resources;

public enum APIValidatePlaceId 
{
	getPlaceAPI("/maps/api/place/get/json");
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
