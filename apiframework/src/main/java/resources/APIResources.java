package resources;

public enum APIResources {
AddPlaceAPI("/maps/api/place/add/json"),
GetPlaceAPI("/maps/api/place/get/json");	
String resource;

APIResources(String resource1)
{
	this.resource = resource1;
}
public String getResource()
{
	return resource;
}
}

/*
 package resources;

public enum APIValidatePlaceId 
{
	GetPlaceAPI("/maps/api/place/get/json");
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
 */