Feature: validating place API

Scenario Outline: Verify place is added successfully with different values
Given Add place API payload with parameters "<name>" "<language>" and "<address>"
When user calls "GetPlaceAPI" with "get" http method
When user calls "AddPlaceAPI" with "Post" http method 
Then the API call got successfull with status code 200
And "status" is response body is "OK" 
And "scope" is response body is "APP"


Examples:
|name   |language|address  |
|sushil |hindi   |laxmipur |
|jaydeep|Marathi |Nasik    |
|Nikhil |Telgu   |Hyderabad|
|Vikas  |Kannada |Bangalore|
|Vasco  |Konkani |Goa      |
