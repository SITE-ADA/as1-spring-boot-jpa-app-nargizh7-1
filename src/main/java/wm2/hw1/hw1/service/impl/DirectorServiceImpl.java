package wm2.hw1.hw1.service.impl;

import wm2.hw1.hw1.model.Director;
import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.repository.DirectorRepository;
import wm2.hw1.hw1.repository.MovieRepository;
import wm2.hw1.hw1.service.DirectorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import wm2.hw1.hw1.specifications.DirectorSpecifications;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {
    DirectorRepository directorRepo;
    MovieRepository movieRepo;

    public DirectorServiceImpl(DirectorRepository directorRepo, MovieRepository movieRepo) {
        this.directorRepo = directorRepo;
        this.movieRepo = movieRepo;
    }

    @Override
    public Page<Director> list(int pageNo, String sortField, String sortDir, String filterField, String filterValue) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5, Sort.by(Sort.Direction.fromString(sortDir), sortField));
        if (!filterField.isEmpty() && !filterValue.isEmpty()) {
            return directorRepo.findAll(DirectorSpecifications.filterBy(filterField, filterValue), pageable);
        }
        return directorRepo.findAll(pageable);
    }

    @Override
    public void addMovieToDirector(Long directorId, Long movieId) {
        Director director = directorRepo.findById(directorId).orElseThrow(() -> new RuntimeException("Director not found"));
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        director.getMovies().add(movie);
        directorRepo.save(director);
    }

    @Override
    public void removeMovieFromDirector(Long directorId, Long movieId) {
        Director director = directorRepo.findById(directorId).orElseThrow(() -> new RuntimeException("Director not found"));
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        director.getMovies().remove(movie);
        directorRepo.save(director);
    }


    //Continuation of DirectorServiceImpl
    @Override
    public Director save(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public Director getById(Long id) {
        return directorRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        directorRepo.deleteById(id);
    }

    @Override
    public List<Director> getDirectorByNamesAnd(String firstName, String lastName) {
        return (List<Director>) directorRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Director> getDirectorByNamesOr(String firstName, String lastName) {
        return (List<Director>) directorRepo.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<Movie> getMoviesByDirectorId(Long id) {
        return (List<Movie>) movieRepo.findByDirectorsId(id);
    }

    @Override
    public List<Movie> getMoviesByDirectorIdNot(Long id) {
        return (List<Movie>) movieRepo.findByDirectorsIdNot(id);
    }
    @Override
    public List<Director> getAllDirectors() {
        return directorRepo.findAll();
    }

}
