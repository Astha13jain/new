package RestTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class E_Commerce {
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	public static String message;
	public static String accessToken;
	public static String UserId;
	public static String EmailId;
		@Test(priority = 0)
		public void signup()
		{
			RestAssured.baseURI =baseurl;
			
		String 	requestbody = "{\r\n"
				+ "	\"email\": \"jjjjssahil@gmail.com\",\r\n"
				+ "	\"password\": \"krishna@123\"\r\n"
				+ "}";

		
		Response resposne = given()
				.header("Content-Type","application/json")
				.body(requestbody)
				
				.when()
				.post("/user/signup")
				
				.then()
				.assertThat().statusCode(201).contentType(ContentType.JSON)
				.extract().response();	
		
		String jsonresponse = resposne.asString();
		//i want to convert the response in to json format
		//why do i use jsonpath to convert the string in to a json format
		JsonPath js = new JsonPath(jsonresponse);
		//nw i have to fetch the id
		message = js.get("message");
		System.out.println(message);
		
		
	}
		
		
		@Test(priority = 1)
		public void Login()
		{
			RestAssured.baseURI =baseurl;
			
		String 	requestbody = "{\r\n"
				+ "	\"email\": \"jjjjssahil@gmail.com\",\r\n"
				+ "	\"password\": \"krishna@123\"\r\n"
				+ "}";
		
		Response resposne = given()
				.header("Content-Type","application/json")
				.body(requestbody)
				
				.when()
				.post("/user/login")
				
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response();	
		
		String jsonresponse = resposne.asString();
		//i want to convert the response in to json format
		//why do i use jsonpath to convert the string in to a json format
		JsonPath js = new JsonPath(jsonresponse);
		//nw i have to fetch the id
		accessToken = js.get("accessToken");
		System.out.println(accessToken);

}
		@Test(priority=2)
		
		public void getAllUser()
		{
			RestAssured.baseURI=baseurl;
			Response resposne = given()
					.header("Content-Type","application/json")
					.header("Authorization","bearer "+accessToken)
					
					
					.when()
					.get("/user")
					
					.then()
					//.contentType(ContentType.JSON)
					.assertThat().statusCode(200).contentType(ContentType.JSON)
					.extract().response();	
			String jsonresponse = resposne.asString();
			JsonPath js = new JsonPath(jsonresponse);
			System.out.println(jsonresponse);
			UserId=js.get("users[50]._id");
			System.out.println("user[50] "+UserId);
			EmailId=js.get("users[50].email");
			System.out.println("user[50] "+EmailId);
		}
		@Test(priority=3)
		public void delete()
		{
			RestAssured.baseURI=baseurl;
			Response resposne = given()
					.header("Content-Type","application/json")
					.header("Authorization","bearer "+accessToken)
					
					
					.when()
					.delete("/user/"+UserId)
					
					.then()
					//.contentType(ContentType.JSON)
					.assertThat().statusCode(200).contentType(ContentType.JSON)
					.extract().response();
			String jsonresponse = resposne.asString();
			JsonPath js = new JsonPath(jsonresponse);
			message=js.getString("message");
			System.out.println(message);
			System.out.println("user holding this id got deleted "+EmailId);
		}
		
		
	}