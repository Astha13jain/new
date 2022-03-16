package RestTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Trello {
	public static String baseurl="https://api.trello.com";
	public static String id;
	
	//@test is testng annotation
	//void createboard is method
	@Test(priority=0)
	
	public void createBoard()
	{
		//restassured is an library used in pom file
		//restassured is a class which contains given when then.
		//baseuri is a method which contains objects
		RestAssured.baseURI=baseurl;
		//restassured has three keywords given when and then
		Response response=given().queryParam("name","Astha jain45 Moolya")
		.queryParam("key","b6154828142430bb0cb7fafa33901300")
		.queryParam("token","fce6c768056faf19be8654d4d83becdc7e9075e94a99ea8e4918af61b36ef7cc")
		.header("Content-Type","application/json")
		
		.when()
		.post("/1/boards/")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		//store respons in string format
		String jsonresponse=response.asString();
		System.out.println(jsonresponse);
		//want to convert response in json format
		JsonPath js=new JsonPath(jsonresponse);
		id =js.get("id");
		System.out.println(id);
		}
	
	@Test(priority=1)
	public void getBoard()
	
	{
		RestAssured.baseURI=baseurl;
		Response response=given().queryParam("key","b6154828142430bb0cb7fafa33901300")
		.queryParam("token","fce6c768056faf19be8654d4d83becdc7e9075e94a99ea8e4918af61b36ef7cc")
		.header("Content-Type","application/json")
		
		.when()
		.get("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse=response.asString();
		
		System.out.println(jsonresponse);
		}
	
	
		 @Test(priority=2)
		 public void deleteBoard()
		 {
			 RestAssured.baseURI=baseurl;
		Response response=given().queryParam("key","b6154828142430bb0cb7fafa33901300")
		 .queryParam("token","fce6c768056faf19be8654d4d83becdc7e9075e94a99ea8e4918af61b36ef7cc")
		  .header("Content-Type","application/json")
		  
		  .when() 
		  .delete("/1/boards/"+id)
		  
		  .then()
		  .assertThat().statusCode(200).contentType(ContentType.JSON)
		  .extract().response(); 
		 String jsonresponse=response.asString();
		 System.out.println(jsonresponse); 
		 }
		
	
	}

