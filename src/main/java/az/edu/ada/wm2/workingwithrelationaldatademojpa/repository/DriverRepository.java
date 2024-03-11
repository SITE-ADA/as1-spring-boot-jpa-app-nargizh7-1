package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Example custom query method
    List<Driver> findByLastName(String lastName);

    // Example of using @Query annotation for a more complex query
    @Query("SELECT d FROM Driver d WHERE d.teams.size > :minTeams")
    List<Driver> findDriversInMoreThanMinTeams(@Param("minTeams") int minTeams);
}
