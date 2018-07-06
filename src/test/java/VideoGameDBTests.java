import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllgames(){

        given().
        when().get(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void CreateNewGame(){

        String gamebodyjson="{\n" +
                "  \"id\": 18,\n" +
                "  \"name\": \"Mygame28\",\n" +
                "  \"releaseDate\": \"2018-07-06T00:36:12.224Z\",\n" +
                "  \"reviewScore\": 52,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
            given().spec(videoGame_requestSpec).
                    body(gamebodyjson).
             when().
                    post(EndPoint.VIDEOGAMES).
              then().spec(responseSpec);

    }

    @Test
    public void updategame(){

        String updategamebody="{\n" +
                "  \"id\": 18,\n" +
                "  \"name\": \"Mygame178\",\n" +
                "  \"releaseDate\": \"2018-07-06T00:36:12.224Z\",\n" +
                "  \"reviewScore\": 57,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given().spec(videoGame_requestSpec).body(updategamebody).
                when().put("/videogames/18").
                then().spec(responseSpec);
    }



    @Test
    public void getsinglegame(){


        given().spec(videoGame_requestSpec).pathParam("videogameid","18").
         when().
                get(EndPoint.SINGLE_VIDEOGAMES).
                then().spec(responseSpec);
    }

    @Test
    public void deletegame(){


        given().spec(videoGame_requestSpec).
                when().delete("/videogames/18").
                then().spec(responseSpec);
    }
}
