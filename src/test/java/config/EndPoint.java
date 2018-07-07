package config;

import java.net.URI;

public interface EndPoint {

    String VIDEOGAMES ="/videogames";
    String SINGLE_VIDEOGAMES = "/videogames/{videogameid}";
    String COMP_TEAM_COUNT="competitions/{comp_num}/teams";
    String COMPETITIONS="competitions/";
}
