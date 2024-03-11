package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();
    Driver getDriverById(Long id);
    Driver saveOrUpdateDriver(Driver driver);
    void deleteDriver(Long id);
    // Additional methods for handling business logic can be added here
}
