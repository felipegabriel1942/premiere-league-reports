package br.com.felipegabriel.premiereleaguereports.models;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.model.Team;

public class TeamTest {
	
	private Team team;
	
	private List<Match> matches = new ArrayList<>();
	
	@BeforeEach
	void beforeEach() {
		team = new Team();
		matches.add(MatchTest.createMockMatch());
	}
	
	@Test
	void createTeamsTest() {
		List<Team> teams = team.createTeams(matches);
		
		assertTrue(!teams.isEmpty());
		assertTrue(teams.get(0).getPoints() == 3);
		assertTrue(teams.get(0).getGoalsFor() == 4);
		assertTrue(teams.get(0).getGoalsAgainst() == 1);
		assertTrue(teams.get(0).getGoalsDifference() == 3);
	}
	
	public static Team createMockTeam() {
		return Team.builder()
				.name("Liverpool FC")
				.goalsFor(4)
				.goalsAgainst(2)
				.goalsDifference(2)
				.points(3)
				.build();
	}
}
