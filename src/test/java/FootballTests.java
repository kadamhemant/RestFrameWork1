import config.EndPoint;
import config.TestConfig;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class FootballTests extends TestConfig {

    @Test
    public void getAllCompetitionsOneSeason()
    {
        given().
                spec(football_requestSpec).
                queryParam("season",2016).
         when().get(EndPoint.COMPETITIONS);

    }

    @Test
    public void getCompetition_Count(){
        given().
                spec(football_requestSpec).
        when().
                get(EndPoint.COMPETITIONS).
          then().
                body("count",equalTo(141));
    }

    @Test
    public void getCompetition_teamname(){
        given().
                spec(football_requestSpec).
                when().
                get(EndPoint.COMPETITIONS).
                then().
                body("competitions.area[0].name",equalTo("Africa"));
    }

    @Test
    public void getAllCompetitions(){
        String allCompetions= given().
                spec(football_requestSpec).
                when().
                get(EndPoint.COMPETITIONS).
                asString();
        System.out.println(allCompetions);
    }

    @Test
    public void getAllCompetitions_doCheckFirst(){
        Response allCompetionsJson= given().
                spec(football_requestSpec).
                when().
                get(EndPoint.COMPETITIONS).
                then().contentType(ContentType.JSON).
                extract().response();
        System.out.println(allCompetionsJson.asString());
    }

    @Test
    public void extractHeaders(){
        Response response= given().
                spec(football_requestSpec).
                when().
                get(EndPoint.COMPETITIONS).
                then().contentType(ContentType.JSON).
                extract().response();
        Headers headers=response.getHeaders();
        String contentType=response.getHeader("Content-Type");
        System.out.println(contentType);

    }

    @Test
    public void getCompetition__Firstteamname_asString(){
        String firstTeamname=given().
                spec(football_requestSpec).
                when().
                get(EndPoint.COMPETITIONS).jsonPath().getString("competitions.area[0].name");
        System.out.println(firstTeamname);

    }

    @Test
    public void getCompetition__allteamnames(){
        Response response= given().
                spec(football_requestSpec).
                when().
                get(EndPoint.COMPETITIONS).
                then().contentType(ContentType.JSON).
                extract().response();
        List<String> team_names=response.path("competitions.area.name");
        List<String> distinct_team_names=team_names.stream().distinct().collect(Collectors.toList());
        for (String name:distinct_team_names
             ) {
            System.out.println(name);


        }
    }
}
