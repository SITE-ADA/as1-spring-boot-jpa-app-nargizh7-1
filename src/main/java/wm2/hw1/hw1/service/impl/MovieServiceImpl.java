package wm2.hw1.hw1.service.impl;

import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.repository.MovieRepository;
import wm2.hw1.hw1.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepo;

    public MovieServiceImpl(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> list() {
        return (List<Movie>) movieRepo.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie getById(Long id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        movieRepo.deleteById(id);
    }

    public List<Movie> getAllWebMovies(String keyword) {
        return (List<Movie>) movieRepo.getAllWebMoviesUsingJPAQuery(keyword);
    }


}
