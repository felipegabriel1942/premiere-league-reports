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
	}

}
