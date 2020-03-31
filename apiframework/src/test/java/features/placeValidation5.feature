Feature: validating place API

@AddPlace
Scenario Outline: Verify place is added successfully with different values
Given Add place API payload with parameters "<name>" "<language>" and "<address>"
When user calls "AddPlaceAPI" with "Post" http method 
Then the API call got successfull with status code 200
And "status" is response body is "OK" 
And "scope" is response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"


Examples:
|name   |language|address  |
|sushil |hindi   |laxmipur |
#|jaydeep|Marathi |Nasik    |
#|Nikhil |Telgu   |Hyderabad|
#|Vikas  |Kannada |Bangalore|
#|Vasco  |Konkani |Goa      |

@del
Scenario: verify if Delete place functionality is working 
Given Delete place payload
When user calls "deletePlaceAPI" with "Post" http method
Then "status" is response body is "OK" 
