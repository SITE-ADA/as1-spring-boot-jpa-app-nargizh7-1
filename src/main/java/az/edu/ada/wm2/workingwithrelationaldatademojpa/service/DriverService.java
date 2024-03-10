package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    Page<Driver> list(int pageNo);

    Driver save(Driver driver);

    Driver getById(Long id);

    List<Driver> getDriverByNamesAnd(String firstName, String lastName);

    List<Driver> getDriverByNamesOr(String firstName, String lastName);

    List<Team> getTeamsByDriverId(Long id);

    List<Team> getTeamsByDriverIdNot(Long id);

    void deleteById(Long id);
}
