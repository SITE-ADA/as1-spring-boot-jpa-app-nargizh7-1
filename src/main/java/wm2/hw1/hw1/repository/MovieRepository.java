package wm2.hw1.hw1.repository;

import org.springframework.stereotype.Repository;
import wm2.hw1.hw1.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
