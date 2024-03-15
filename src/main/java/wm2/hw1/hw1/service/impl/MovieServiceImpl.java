package wm2.hw1.hw1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.repository.MovieRepository;
import wm2.hw1.hw1.service.MovieService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;

    @Override
    public List<Movie> list() {
        return movieRepo.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        var res = movieRepo.save(movie);
        System.out.println(res == movie);
        return res;
    }

    @Override
    public Movie getById(Long id) {
        var res = movieRepo.findById(id);

        return res.orElseThrow(
                () -> new RuntimeException("Movie with id " + id + " is not found,sorry :("));
    }

    @Override
    public void deleteById(Long id) {
        movieRepo.deleteById(id);
    }
}
