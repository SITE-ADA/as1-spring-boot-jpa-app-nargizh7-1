package wm2.hw1.hw1.repository;

import wm2.hw1.hw1.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Iterable<Movie> findByDirectorsId(Long id);

    @Query("select c from Movie c where c not in " +
            "(select c from Movie c left join c.directors std where std.id = :id)")
    Iterable<Movie> findByDirectorsIdNot(Long id);

    @Query("select c from Movie c where lower(c.country) like %:keyword%")
    Iterable<Movie> getAllWebMoviesUsingJPAQuery(@Param("keyword") String keyword);

    @Query(value = "select * from movies where description like '%Web%'", nativeQuery = true)
    Iterable<Movie> getAllWebMoviesUsingNativeQuery();
}
