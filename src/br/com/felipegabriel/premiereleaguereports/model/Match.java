package br.com.felipegabriel.premiereleaguereports.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lombok.Data;

@Data
public class Match {
	
	private int round;
	private LocalDate date;
	private String home;
	private String visitor;
	private int homeScore;
	private int visitorScore;
	
	public List<Match> createMatches(List<String> lines) {
		List<Match> matches = new ArrayList<>();
		
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
		
		return matches;
	}
	
}
