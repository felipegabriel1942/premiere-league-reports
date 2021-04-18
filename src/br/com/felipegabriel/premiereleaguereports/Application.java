package br.com.felipegabriel.premiereleaguereports;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.felipegabriel.premiereleaguereports.model.File;
import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.model.Report;
import br.com.felipegabriel.premiereleaguereports.model.Team;

public class Application {

	public static void main(String[] args) {
		List<String> lines = new File().readFile("src/resources/eng.1.txt");

		List<Match> matches = new Match().createMatches(lines);

		List<Team> teams =  new Team().createTeams(matches);
		
		String report = new Report().createReport(teams);
		
	    try {
			PrintWriter writer = new PrintWriter("C:\\Users\\pinhe\\Documents\\premiere-league-report.html", "UTF-8");
			writer.println(report);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
