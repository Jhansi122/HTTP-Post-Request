package post;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostRequestTest 
{
 @Test
 public void postRequestDemo()
 {
	 RestAssured.baseURI="https://reqres.in/";
	 
	RequestSpecification req =RestAssured.given();
	
	JSONObject obj = new JSONObject();
	
	obj.put("name", "morpheus12");
	obj.put("job", "leader1");
	
	obj.put("id", 3070);
	obj.put("createdAt", "2019-05-13T14:28:29.573Z1");
	
	req.header("Content-Type", "application/json");
	
	req.body(obj.toString());
	Response res =req.post("/api/users");
	System.out.println("Response body = "+res.body().asString());  
	
    String Status_Line = res.getStatusLine();
    System.out.println("Status Line = "+Status_Line);
    
    int StatusCode = res.getStatusCode();
    System.out.println("Status Code = "+StatusCode);
    
    long time = res.getTime();
    System.out.println("Time " +time);
	
	Assert.assertEquals(StatusCode, 201);
	//Assert.assertEquals(8754, time);
	
	
	 
 }
}
