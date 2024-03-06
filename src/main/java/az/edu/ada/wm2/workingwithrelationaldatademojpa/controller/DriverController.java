package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.TeamService;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {
    static final Logger LOGGER = LoggerFactory.getLogger(DriverController.class);

     DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping({"", "/", "/list"})
    public String getDrivers(Model model) {
        return getDriversByPageNo(model, 1);
    }

    @GetMapping("/page/{no}")
    public String getDriversByPageNo(Model model, @PathVariable("no") Integer pageNo) {
        Page<Driver> driversPage = driverService.list(pageNo);
        model.addAttribute("drivers", driversPage);
        model.addAttribute("drivers", driversPage.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", driversPage.getTotalPages());
        model.addAttribute("nbElements", driversPage.getNumberOfElements());
        model.addAttribute("totalElements", driversPage.getTotalElements());
        return "drivers/index";
    }

    @GetMapping("/new")
    public String createNewDriver(Model model) {
        model.addAttribute("driver", new Driver());
        return "drivers/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("driver") Driver driver) {
        driverService.save(driver);
        return "redirect:/driver/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        driverService.deleteById(id);
        return "redirect:/driver/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateDriver(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("drivers/update");

        mv.addObject("driver", driverService.getById(id));
        return mv;
    }


    @GetMapping("/and/{firstName}/{lastName}")
    public String getDriverByNameAnd(Model model, @PathVariable String firstName, @PathVariable String lastName) {

        var driver = driverService.getDriverByNamesAnd(firstName, lastName);

        model.addAttribute("drivers", driver);

        return "drivers/index";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getDriverByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        model.addAttribute("drivers", driverService.getDriverByNamesOr(firstName, lastName));

        return "drivers/index";
    }

    @GetMapping("/{id}/teams")
    public String getTeamsByDriverId(Model model, @PathVariable Long id) {
        model.addAttribute("teams", driverService.getTeamsByDriverId(id));
        return "teams/index";
    }

    @GetMapping("/{id}/addTeam")
    public String addTeamPage(Model model, @PathVariable Long id) {

        Driver stud = driverService.getById(id);
        model.addAttribute("driver", stud);

        List<Team> allTeams = driverService.getTeamsByDriverIdNot(id);
        model.addAttribute("teams", allTeams);
        return "drivers/add_team";
    }
}
