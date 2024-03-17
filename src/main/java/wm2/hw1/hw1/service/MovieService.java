package wm2.hw1.hw1.service;

import wm2.hw1.hw1.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> list();

    Movie save(Movie movie);

    Movie getById(Long id);

    void deleteById(Long id);

    List<Movie> getAllWebMovies(String keyword);

}
