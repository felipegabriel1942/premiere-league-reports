package br.com.felipegabriel.premiereleaguereports.models;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.utils.CustomDateUtils;

public class MatchTest {
	
	private Match match;
	
	@BeforeEach
	void beforeEach() {
		match = new Match();
	}	
	
	@Test
	void createMatchesTest() {
		List<String> lines = Arrays.asList("1,Fri Aug 9 2019,Liverpool FC,4-1,Norwich City FC");
		
		List<Match> matches = match.createMatches(lines);
		
		assertTrue(!matches.isEmpty());
		assertTrue(matches.get(0).getHome().equals("Liverpool FC"));
		assertTrue(matches.get(0).getVisitor().equals("Norwich City FC"));
		assertTrue(matches.get(0).getHomeScore() == 4);
		assertTrue(matches.get(0).getVisitorScore() == 1);
		assertTrue(matches.get(0).getRound() == 1);
		assertTrue(matches.get(0).getDate().isEqual(CustomDateUtils.createDate("Fri Aug 9 2019")));
	}
	
	
	public static Match createMockMatch() {
		return Match.builder()
				.round(1)
				.date(CustomDateUtils.createDate("Fri Aug 9 2019"))
				.home("Liverpool FC")
				.visitor("Norwich City FC")
				.homeScore(4)
				.visitorScore(1)
				.build();
	}
}
