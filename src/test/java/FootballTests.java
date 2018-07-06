import config.TestConfig;
import static io.restassured.RestAssured.*;
import org.junit.Test;


public class FootballTests extends TestConfig {

    @Test
    public void getAllCompetitionsOneSeason()
    {
        given().
                spec(football_requestSpec).
                queryParam("season",2016).
         when().get("competitions/");

    }
}
