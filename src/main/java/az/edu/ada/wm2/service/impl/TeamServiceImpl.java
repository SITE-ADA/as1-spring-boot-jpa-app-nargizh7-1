package az.edu.ada.wm2.service.impl;

import az.edu.ada.wm2.repository.TeamRepository;
import az.edu.ada.wm2.model.Team;
import az.edu.ada.wm2.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    @Override
    public Team saveOrUpdateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    // Implement additional business logic methods as needed
}
