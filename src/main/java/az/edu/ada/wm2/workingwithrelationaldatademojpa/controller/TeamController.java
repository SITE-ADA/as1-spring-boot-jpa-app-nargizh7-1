package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Driver;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.DriverService;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping({"", "/", "/list"})
    public String getTeams(Model model) {
        List<Team> teams = teamService.list();
        model.addAttribute("teams", teams);

        LOGGER.info(teams.toString());

        return "teams/index";
    }

    @GetMapping("/new")
    public String createNewTeam(Model model) {
        model.addAttribute("team", new Team());
        return "teams/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/team/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        teamService.deleteById(id);
        return "redirect:/team/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateTeam(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teams/update");

        mv.addObject("team", teamService.getById(id));
        return mv;
    }

    @GetMapping("/filter/{keyword}")
    public String getWebTeams(Model model, @PathVariable String keyword) {
        model.addAttribute("teams", teamService.getAllWebTeams(keyword));

        return "teams/index";
    }
}
