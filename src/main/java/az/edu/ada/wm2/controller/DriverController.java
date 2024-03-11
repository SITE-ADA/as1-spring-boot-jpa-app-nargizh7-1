package az.edu.ada.wm2.controller;

import az.edu.ada.wm2.model.Driver;
import az.edu.ada.wm2.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String listDrivers(Model model) {
        List<Driver> drivers = driverService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "drivers/list"; // Thymeleaf template for listing drivers
    }

    @GetMapping("/{id}")
    public String getDriver(@PathVariable Long id, Model model) {
        Driver driver = driverService.getDriverById(id);
        model.addAttribute("driver", driver);
        return "drivers/detail"; // Thymeleaf template for showing driver details
    }

    @GetMapping("/new")
    public String createDriverForm(Model model) {
        Driver driver = new Driver(); // Create an empty driver to hold form data
        model.addAttribute("driver", driver);
        return "drivers/create"; // Thymeleaf template for the driver creation form
    }

    @PostMapping
    public String saveDriver(@ModelAttribute("driver") Driver driver) {
        driverService.saveOrUpdateDriver(driver);
        return "redirect:/drivers"; // Redirect to the listing page after saving
    }

    @GetMapping("/edit/{id}")
    public String editDriverForm(@PathVariable Long id, Model model) {
        Driver driver = driverService.getDriverById(id);
        model.addAttribute("driver", driver);
        return "drivers/edit"; // Thymeleaf template for the driver edit form
    }

    @PostMapping("/{id}")
    public String updateDriver(@PathVariable Long id, @ModelAttribute("driver") Driver driver) {
        // Set the ID to ensure the existing driver is updated
        driver.setId(id);
        driverService.saveOrUpdateDriver(driver);
        return "redirect:/drivers"; // Redirect to the listing page after updating
    }

    @GetMapping("/delete/{id}")
    public String deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return "redirect:/drivers"; // Redirect to the listing page after deletion
    }

    // Additional handler methods for filtering, sorting, and pagination can be added here
}
