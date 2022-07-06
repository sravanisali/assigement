package Fullstack;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class stackfull {
	
//	@Test
//	public void test(){
//		
//		Response obj=RestAssured.get("http://localhost:3000/ibmstudents");
//		
//		System.out.println(obj.asString());
//		
//		
//		
//	}
	@Test(enabled = false)
	public void firsttestcase()
	{
		Response obj = RestAssured.get("http://localhost:3000/ibmstudents");
		System.out.println(obj.asString());
		System.out.println(obj.statusCode());
		System.out.println(obj.headers());
		
	}
	@Test(enabled = false)
	public void testcase2()
	{
		Response obj = RestAssured.delete("http://localhost:3000/ibmstudents/2");
		System.out.println(obj.asString());
	}
	
	@Test(enabled = false)
	public void testcase3()
	{
		
		RestAssured.baseURI="http://localhost:3000/";
		
		
		JSONObject obj=new JSONObject();
		//creating json body
		//this put is your json object class function
		//its not http method
		
		obj.put("name","sushma");
		obj.put("batchno", "wert");
		System.out.println(obj);
		
		
		
		
//		String bodyvariable="{\"name\":\"Sushma\",\"batchno\":\"erty\"}";
		given()
//			.contentType(ContentType.JSON)
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
			when()
			.post("ibmstudents").
			then()
			.statusCode(201)
			.log().all();
//			
		
//		given()
//			.get("ibmstudents").
//		then()
//			.statusCode(200).log().all();
	}
	
	/////////////
	@Test(enabled=true)
	public void testcase4(){
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		given()
		.queryParam("username", "sushma")
		.queryParam("password","1234567").log().all().
		when()
		.get("/user/login").
		then()
		.statusCode(200)
		.log().all();
		
	}
	/////////
	@DataProvider(name="testdata")
	public Object[][] data()
	{
		Object[][] studentsdata = new Object[2][2];
		studentsdata[0][0]= "manasa";
		studentsdata[0][1]= "5";
		studentsdata[1][0]= "sumathi";
		studentsdata[1][1]= "6";
		return studentsdata;
		
	}
	@Test(enabled = false,dataProvider="testdata")
	public void testcase7(String fname,String bno)
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject obj = new JSONObject();
		
		obj.put("name", fname);
		obj.put("batchno", bno);
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.post("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
			
		
		
	}
	
	
	
	
}
