package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.LinkedList;

public class MovieStore implements IRequestHandler {
    private LinkedList<Movie> movies;

    public MovieStore() {
        movies = new LinkedList<>();
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public boolean remove(int index) {
        // out of bounds
        if (movies.size() <= index) {
            return false;
        }
        return movies.remove(index) != null;
    }

    @Override
    public ResultBase handle(Request request) {
        // 요청한 영화가 존재한다면 OkResult를 반환합니다. (OkResult는 찾은 영화 개체를 포함해야 함.)
        // 만약 영화를 찾지 못했다면 NotFoundResult 개체를 반환합니다.
        for (Movie movie : movies) {
            if (movie.getTitle().equals(request.getTitle())) {
                return new OkResult(movie);
            }
        }
        return new NotFoundResult();
    }
}
