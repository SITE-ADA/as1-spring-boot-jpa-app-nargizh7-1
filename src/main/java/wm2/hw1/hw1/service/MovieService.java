package wm2.hw1.hw1.service;

import org.springframework.data.domain.Page;
import wm2.hw1.hw1.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Page<Movie> list(int pageNo, String sortField, String sortDir, String filterField, String filterValue);


    Movie save(Movie movie);

    Movie getById(Long id);

    void deleteById(Long id);

    List<Movie> getAllWebMovies(String keyword);

}
