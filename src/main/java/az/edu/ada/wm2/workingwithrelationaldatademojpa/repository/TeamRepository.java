package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    // Example custom query method
    List<Team> findByCountry(String country);

    // Using @Query to fetch teams with a specific minimum number of wins
    @Query("SELECT t FROM Team t WHERE t.wins >= :minWins")
    List<Team> findTeamsWithMinWins(@Param("minWins") int minWins);
}
