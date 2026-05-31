import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CricketApiTest {
	  @Test(priority = 1)
	    public void verifyApiResponseCode() {
	        Response response = RestAssured
	            .get("https://jsonplaceholder.typicode.com/posts/1");
	        int statusCode = response.getStatusCode();
	        System.out.println("Status Code: " + statusCode);
	        Assert.assertEquals(statusCode, 200);
	    }

	    @Test(priority = 2)
	    public void verifyResponseBody() {
	        Response response = RestAssured
	            .get("https://jsonplaceholder.typicode.com/posts/1");
	        String body = response.getBody().asString();
	        System.out.println("Response Body: " + body);
	        Assert.assertTrue(body.contains("userId"));
	    }

	    @Test(priority = 3)
	    public void verifyResponseTime() {
	        Response response = RestAssured
	            .get("https://jsonplaceholder.typicode.com/posts/1");
	        long time = response.getTime();
	        System.out.println("Response Time: " + time + "ms");
	        Assert.assertTrue(time < 5000);
	    }

	    @Test(priority = 4)
	    public void verifyMultiplePosts() {
	        Response response = RestAssured
	            .get("https://jsonplaceholder.typicode.com/posts");
	        int statusCode = response.getStatusCode();
	        String body = response.getBody().asString();
	        System.out.println("Status: " + statusCode);
	        Assert.assertEquals(statusCode, 200);
	        Assert.assertTrue(body.contains("userId"));
	    }
	}

