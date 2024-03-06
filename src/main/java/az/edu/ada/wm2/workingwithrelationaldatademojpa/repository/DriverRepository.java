package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Page<Driver> findAll(Pageable pageable);

    Iterable<Driver> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Driver> findByFirstNameOrLastName(String firstName, String lastName);

}
