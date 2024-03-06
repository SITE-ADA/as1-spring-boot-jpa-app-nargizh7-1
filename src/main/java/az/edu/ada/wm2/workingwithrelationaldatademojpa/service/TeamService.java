package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<Team> list();

    Team save(Team team);

    Team getById(Long id);

    void deleteById(Long id);

    List<Team> getAllWebTeams(String keyword);

}
