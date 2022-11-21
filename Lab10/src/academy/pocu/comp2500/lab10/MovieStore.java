package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public boolean remove(int index) {
        return movies.remove(index) != null;
    }

    public ResultBase handle(Request request) {
        // 요청한 영화가 존재한다면 OkResult를 반환합니다. (OkResult는 찾은 영화 개체를 포함해야 함.)
        // 만약 영화를 찾지 못했다면 NotFoundResult 개체를 반환합니다.
    }
}
