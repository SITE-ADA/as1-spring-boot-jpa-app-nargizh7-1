package wm2.hw1.hw1.service;

import org.springframework.stereotype.Service;
import wm2.hw1.hw1.model.Movie;
import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    List<Movie> list();

    Movie save(Movie movie);

    Movie getById(Long id);

    void deleteById(Long id);

}
