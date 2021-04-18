package br.com.felipegabriel.premiereleaguereports.models;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.felipegabriel.premiereleaguereports.model.Report;
import br.com.felipegabriel.premiereleaguereports.model.Team;

public class ReportTest {
	
	private Report report;
	
	private List<Team> teams = new ArrayList<>();
	
	@BeforeEach
	void beforeEach() {
		report = new Report();
		teams.add(TeamTest.createMockTeam());
	}
	
	@Test
	void createReportTest() {
		String result = this.report.createReport(teams);
		
		assertTrue(result != null && !result.isEmpty());
	}
}
