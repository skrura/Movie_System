package movies.bean;

import java.util.List;


public class Client extends User{
    private List<String> Rated_over_movie_id;

    public List<String> getRated_over_movie_id() {
        return Rated_over_movie_id;
    }

    public void setRated_over_movie_id(List<String> rated_over_movie_id) {
        Rated_over_movie_id = rated_over_movie_id;
    }
}
