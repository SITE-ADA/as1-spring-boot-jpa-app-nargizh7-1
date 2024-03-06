package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Iterable<Team> findByDriversId(Long id);

    @Query("select c from Team c where c not in " +
            "(select c from Team c left join c.drivers std where std.id = :id)")
    Iterable<Team> findByDriversIdNot(Long id);

    @Query("select c from Team c where lower(c.country) like %:keyword%")
    Iterable<Team> getAllWebTeamsUsingJPAQuery(@Param("keyword") String keyword);

    @Query(value = "select * from teams where description like '%Web%'", nativeQuery = true)
    Iterable<Team> getAllWebTeamsUsingNativeQuery();
}
