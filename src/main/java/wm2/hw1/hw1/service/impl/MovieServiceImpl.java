package wm2.hw1.hw1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.repository.MovieRepository;
import wm2.hw1.hw1.service.MovieService;
import org.springframework.stereotype.Service;
import wm2.hw1.hw1.specifications.MovieSpecifications;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.ArrayList;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepo = movieRepository;
    }
    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }
    @Override
    public Page<Movie> list(int pageNo, String sortField, String sortDir, String filterField, String filterValue) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5, Sort.by(Sort.Direction.fromString(sortDir), sortField));
        if (!filterField.isEmpty() && !filterValue.isEmpty()) {
            return movieRepo.findAll(MovieSpecifications.filterBy(filterField, filterValue), pageable);
        }
        return movieRepo.findAll(pageable);
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
