package com.bobocode.service;

import com.bobocode.dal.TeamRepository;
import com.bobocode.exceptions.FootballManagerException;
import com.bobocode.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void createNewTeam(Team team) {
        teamRepository.save(team);
    }

    @Transactional(readOnly = true)
    public Team findTeamByName(String name) {
        Optional<Team> team = teamRepository.findTeamByName(name);
        return team.orElseThrow(() -> {
            throw new FootballManagerException();
        });
    }

    @Transactional(readOnly = true)
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

}
