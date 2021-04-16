package br.com.felipegabriel.premiereleaguereports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import br.com.felipegabriel.premiereleaguereports.model.File;
import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.model.Team;

public class Application {
	
	public static void main(String[] args) {
			
		List<String> lines = new File().readFile("src/resources/eng.1.txt");
		
		List<Match> matches = new ArrayList<>();
		
		// creating list of matches
		lines.forEach(line -> {
			String[] splittedLine = line.split(",");
			Match match = new Match();
			match.setRound(Integer.parseInt(splittedLine[0]));
			match.setDate(LocalDate.parse(splittedLine[1], DateTimeFormatter.ofPattern("E MMM d yyyy", Locale.US)));
			match.setHome(splittedLine[2]);
			match.setVisitor(splittedLine[4]);
			match.setHomeScore(Integer.parseInt(splittedLine[3].split("-")[0]));
			match.setVisitorScore(Integer.parseInt(splittedLine[3].split("-")[1]));
			matches.add(match);
		});
		
		// creating teams
		Set<Team> teams = new HashSet<>();
		
		matches.forEach(match -> {
			Team team = new Team();
			team.setName(match.getHome());
			teams.add(team);
		});
		
		// calculating results
		teams.forEach(team ->
			matches.forEach(match -> {
				if (team.getName().equals(match.getHome())) {
					team.setGoalsFor(team.getGoalsFor() + match.getHomeScore());
					team.setGoalsAgainst(team.getGoalsAgainst() + match.getVisitorScore());
				}
				
				if (team.getName().equals(match.getVisitor())) {
					team.setGoalsFor(team.getGoalsFor() + match.getVisitorScore());
					team.setGoalsAgainst(team.getGoalsAgainst() + match.getHomeScore());
				}
				
				team.setGoalsDifference(team.getGoalsFor() - team.getGoalsAgainst());
			})
		);
		
		teams.forEach(System.out::println);
	}
}
