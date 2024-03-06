package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.TeamRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class TeamServiceImpl implements TeamService {

    TeamRepository teamRepo;

    public TeamServiceImpl(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Override
    public List<Team> list() {
        return (List<Team>) teamRepo.findAll();
    }

    @Override
    public Team save(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public Team getById(Long id) {
        return teamRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        teamRepo.deleteById(id);
    }

    public List<Team> getAllWebTeams(String keyword) {
        return (List<Team>) teamRepo.getAllWebTeamsUsingJPAQuery(keyword);
    }


}
