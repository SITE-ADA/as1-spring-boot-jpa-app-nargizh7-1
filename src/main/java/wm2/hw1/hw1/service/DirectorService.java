package wm2.hw1.hw1.service;

import wm2.hw1.hw1.model.Director;
import wm2.hw1.hw1.model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    Page<Director> list(int pageNo, String sortField, String sortDir, String filterField, String filterValue);
    Director save(Director director);
    Director getById(Long id);
    List<Director> getDirectorByNamesAnd(String firstName, String lastName);
    List<Director> getDirectorByNamesOr(String firstName, String lastName);
    List<Movie> getMoviesByDirectorId(Long id);
    List<Movie> getMoviesByDirectorIdNot(Long id);
    void deleteById(Long id);
}
