import config.EndPoint;
import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class GpathJsonTests extends TestConfig {

    @Test
    public void extractMapofElementsWithFind()
    {

        Response response=get("competitions/");
        Map<String,?> allTeamdataforsingleTeam=response.path("competitions.find{it.name='Primera B Nacional'}");
        System.out.println(allTeamdataforsingleTeam);
    }
    @Test
    public void extractElementWithFind()
    {

        Response response=get("competitions/");
        String allTeamdataforTeam=response.path("competitions.find{it.name='Primera B Nacional'}.area.name");
        System.out.println(allTeamdataforTeam);
    }

    @Test
    public void extractElementWithFindAll()
    {

        Response response=get("competitions/");
        List<String> allTeamdataforTeam=response.path("competitions.findAll{it.numberOfAvailableSeasons>2}.id");
        System.out.println(allTeamdataforTeam);
    }

    @Test
    public void extractElementWithFindAllandFind()
    {

        Response response=get("competitions/");
        int team1=response.path("competitions.findAll{it.numberOfAvailableSeasons>2}.find{it.name='England'}.id");
        System.out.println(team1);
    }
}
