package az.edu.ada.wm2.controller;

import az.edu.ada.wm2.service.TeamService;
import az.edu.ada.wm2.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String listTeams(Model model) {
        List<Team> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);
        return "teams/list"; // Thymeleaf template for listing teams
    }

    @GetMapping("/{id}")
    public String getTeam(@PathVariable Long id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        return "teams/detail"; // Thymeleaf template for showing team details
    }

    @GetMapping("/new")
    public String createTeamForm(Model model) {
        Team team = new Team(); // Create an empty team to hold form data
        model.addAttribute("team", team);
        return "teams/create"; // Thymeleaf template for the team creation form
    }

    @PostMapping
    public String saveTeam(@ModelAttribute("team") Team team) {
        teamService.saveOrUpdateTeam(team);
        return "redirect:/teams"; // Redirect to the listing page after saving
    }

    @GetMapping("/edit/{id}")
    public String editTeamForm(@PathVariable Long id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        return "teams/edit"; // Thymeleaf template for the team edit form
    }

    @PostMapping("/{id}")
    public String updateTeam(@PathVariable Long id, @ModelAttribute("team") Team team) {
        // Set the ID to ensure the existing team is updated
        team.setId(id);
        teamService.saveOrUpdateTeam(team);
        return "redirect:/teams"; // Redirect to the listing page after updating
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return "redirect:/teams"; // Redirect to the listing page after deletion
    }

    // Additional handler methods for filtering, sorting, and pagination can be added here
}
