package wm2.hw1.hw1.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.service.MovieService;

import java.util.List;

//@Service
//@Profile("profile1")
public class MovieServiceImpl2 implements MovieService {
    @Override
    public List<Movie> list() {
        return List.of();
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
