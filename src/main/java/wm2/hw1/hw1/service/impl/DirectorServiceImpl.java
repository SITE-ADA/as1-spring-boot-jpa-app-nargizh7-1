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
    public Page<Director> list(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return (Page<Director>) directorRepo.findAll(pageable);
    }

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

    public List<Director> getDirectorByNamesAnd(String firstName, String lastName) {
        return (List<Director>) directorRepo.findByFirstNameAndLastName(firstName, lastName);

    }

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


}
