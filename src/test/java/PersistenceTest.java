import com.bobocode.config.PersistenceConfig;
import com.bobocode.config.RootConfig;
import com.bobocode.exceptions.FootballManagerException;
import com.bobocode.model.Player;
import com.bobocode.model.Team;
import com.bobocode.service.PlayerService;
import com.bobocode.service.TeamService;
import com.bobocode.util.DataGenerator;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import org.hamcrest.Matchers.*;
import org.hamcrest.MatcherAssert;
import static org.junit.jupiter.api.Assertions.*;

import com.bobocode.util.DataGenerator.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, PersistenceConfig.class})
@Transactional
public class PersistenceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Test
    public void saveNewTeam() {
        Team team = DataGenerator.teamGenerator();
        teamService.createNewTeam(team);
        Assertions.assertNotNull(team.getId());
    }

    @Test
    public void findExistingTeamByName() {
        Team team = new Team();
        team.setName("Liverpool");
        teamService.createNewTeam(team);
        Team liverpool = teamService.findTeamByName("Liverpool");
        MatcherAssert.assertThat(team.getName(), Matchers.is(liverpool.getName()));
    }

    @Test
    public void findNonExistingTeam() {
        Team team = DataGenerator.teamGenerator();
        assertThrows(FootballManagerException.class, () -> teamService.findTeamByName("Bla-bla"));
    }

    @Test
    public void getAllTeams() {
        List<Team> teamList = DataGenerator.teamListGenerator();
        teamList.forEach(teamService::createNewTeam);
        List<Team> savedTeams = teamService.findAllTeams();
        assertNotNull(savedTeams);
        MatcherAssert.assertThat(teamList, Matchers.is(savedTeams));
    }

    @Test
    public void saveNewPlayer() {
        Player player = DataGenerator.playerGenerator();
        assertNotNull(player.getId());
    }

}

