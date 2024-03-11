package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();
    Team getTeamById(Long id);
    Team saveOrUpdateTeam(Team team);
    void deleteTeam(Long id);
    // Additional methods for handling business logic can be added here
}
