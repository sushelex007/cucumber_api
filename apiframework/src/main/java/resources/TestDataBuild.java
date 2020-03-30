package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddLocation;
import pojo.Location;


public class TestDataBuild 
{
	public AddLocation addPlacepayload(String name, String lang, String address)
	{
		AddLocation loc = new AddLocation();
		Location l = new Location();
		loc.setAccuracy(50);
		loc.setAddress(address);
		loc.setLanguage(lang);
		List<String> type = new ArrayList<String>();
		type.add("shoe park");
		type.add("shop");
		loc.setTypes(type);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		loc.setLocation(l);
		loc.setName(name);
		loc.setPhone_number("(+91) 983 893 3937");
		loc.setWebsite("http://google.com");
		return loc;
	}
	
	public AddLocation addPlacepayload()
	{
		AddLocation loc = new AddLocation();
		Location l = new Location();
		loc.setAccuracy(50);
		loc.setAddress("29, side layout, cohen 09");
		loc.setLanguage("French-IN");
		List<String> type = new ArrayList<String>();
		type.add("shoe park");
		type.add("shop");
		loc.setTypes(type);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		loc.setLocation(l);
		loc.setName("Frontline house");
		loc.setPhone_number("(+91) 983 893 3937");
		loc.setWebsite("http://google.com");
		return loc;
	}
}
