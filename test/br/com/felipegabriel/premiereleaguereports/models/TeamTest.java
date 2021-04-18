package br.com.felipegabriel.premiereleaguereports.models;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.model.Team;
import br.com.felipegabriel.premiereleaguereports.utils.CustomDateUtils;

public class TeamTest {
	
	private Team team;
	
	private List<Match> matches = new ArrayList<>();
	
	@BeforeEach
	void beforeEach() {
		team = new Team();
		matches.add(MatchTest.createMatchMock());
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
	
//	@Test
//	void calculateTeamsResultTest() {
//		List<Team> teams = team.createTeams(matches);
//		
//		teams = team.calculateTeamsResults(teams, matches);
//		
//		assertTrue(!teams.isEmpty());
//		assertTrue(teams.get(0).getPoints() == 3);
//		assertTrue(teams.get(0).getGoalsFor() == 4);
//		assertTrue(teams.get(0).getGoalsAgainst() == 1);
//		assertTrue(teams.get(0).getGoalsDifference() == 3);
//	}

}
