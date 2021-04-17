package br.com.felipegabriel.premiereleaguereports;

import java.util.List;

import br.com.felipegabriel.premiereleaguereports.model.File;
import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.model.Team;

public class Application {
	
	public static void main(String[] args) {
			
		List<String> lines = new File().readFile("src/resources/eng.1.txt");
		
		List<Match> matches = new Match().createMatches(lines);
		
		List<Team> teams = new Team().createTeams(matches);
		
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
		
		// creating report file
//	    try {
//			PrintWriter writer = new PrintWriter("C:\\Users\\pinhe\\Documents\\teste.html", "UTF-8");
//			
//			StringBuilder report = new StringBuilder();
//			report.append(createRow("Relatório temporada 2019 / 2020"));
//			report.append("<hr/>");
//			
//			teams.forEach(team -> report.append(createRow(team.getName())));
//			
//			writer.println(report);
//			writer.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
		teams.forEach(System.out::println);
	}
	
	public static String createRow(String value) {
		return "<p style='color: green;'>" + value + "</p>";
	}
}
