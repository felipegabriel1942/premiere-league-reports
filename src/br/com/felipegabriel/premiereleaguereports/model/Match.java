package br.com.felipegabriel.premiereleaguereports.model;

import static br.com.felipegabriel.premiereleaguereports.utils.CustomDateUtils.createDate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Match {
	
	private int round;
	private LocalDate date;
	private String home;
	private String visitor;
	private int homeScore;
	private int visitorScore;
	
	public List<Match> createMatches(List<String> lines) {	
		return lines.stream()
				.map(this::createMatch)
				.collect(Collectors.toList());
	}
	
	public Match createMatch(String line) {
		String[] splittedLine = line.split(",");
		
		return Match.builder()
				.round(Integer.parseInt(splittedLine[0]))
				.date(createDate(splittedLine[1]))
				.home(splittedLine[2])
				.visitor(splittedLine[4])
				.homeScore(createHomeScore(splittedLine[3]))
				.visitorScore(createVisitorScore(splittedLine[3]))
				.build();
	}
		
	public int createHomeScore(String string) {
		return Integer.parseInt(string.split("-")[0]);
	}
	
	public int createVisitorScore(String string) {
		return Integer.parseInt(string.split("-")[1]);
	}
	
}
