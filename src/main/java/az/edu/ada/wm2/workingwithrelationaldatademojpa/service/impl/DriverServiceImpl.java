package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.DriverRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.TeamRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

     DriverRepository driverRepo;

     TeamRepository teamRepo;

    public DriverServiceImpl(DriverRepository driverRepo, TeamRepository teamRepo) {
        this.driverRepo = driverRepo;
        this.teamRepo = teamRepo;
    }

    @Override
    public Page<Driver> list(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return (Page<Driver>) driverRepo.findAll(pageable);
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    public Driver getById(Long id) {
        return driverRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        driverRepo.deleteById(id);
    }

    public List<Driver> getDriverByNamesAnd(String firstName, String lastName) {
        return (List<Driver>) driverRepo.findByFirstNameAndLastName(firstName, lastName);

    }

    public List<Driver> getDriverByNamesOr(String firstName, String lastName) {
        return (List<Driver>) driverRepo.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<Team> getTeamsByDriverId(Long id) {
        return (List<Team>) teamRepo.findByDriversId(id);
    }

    @Override
    public List<Team> getTeamsByDriverIdNot(Long id) {
        return (List<Team>) teamRepo.findByDriversIdNot(id);
    }


}
