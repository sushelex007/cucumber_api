package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestUtilities 
{
public static RequestSpecification reqSpec;
public ResponseSpecification resSpec;

public static Properties getGlobalValues() throws IOException
{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("/Users/sushilkumargupta/Documents/javalearnings/apiframework/src/main/java/resources/global.properties");
	prop.load(fis);
	return prop;
}

public RequestSpecification getRequestSpecifications() throws IOException
{
	if(reqSpec == null)
	{
		PrintStream ps = new PrintStream(new FileOutputStream(System.getProperty("user.dir")+"/logfiles/locations.log"));
		reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValues().getProperty("baseUrl")).addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps)).addQueryParam("key", getGlobalValues().getProperty("key"))
		.build();
		return reqSpec;
	}
	
	return reqSpec;
}

public ResponseSpecification getResponseSpecification()
{
	//ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	return resSpec;
}
}
