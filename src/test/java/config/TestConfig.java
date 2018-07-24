package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestConfig {

    public static RequestSpecification videoGame_requestSpec;
    public static RequestSpecification videoGame_requestSpec_XML;
    public static RequestSpecification football_requestSpec;
    public static ResponseSpecification responseSpec;
    @BeforeClass
    public static void setup() {
       // RestAssured.proxy("localhost", 8888);

        videoGame_requestSpec=new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type","application/json").
                addHeader("Accept","application/json").
                build();
        videoGame_requestSpec_XML=new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type","application/xml").
                addHeader("Accept","application/xml").
                build();

        football_requestSpec=new RequestSpecBuilder().
                setBaseUri("http://api.football-data.org").
                setBasePath("/v2/").
                addHeader("X-Auth-Token","91a3d7548dae4268a1e32ab15b4d8aae").
                addHeader("X-Response-Control","minified").
                build();



     RestAssured.requestSpecification=football_requestSpec;

        responseSpec=new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThan(10000L)).
                build();
     //     RestAssured.responseSpecification=videoGame_responseSpec;
        //

            }
}