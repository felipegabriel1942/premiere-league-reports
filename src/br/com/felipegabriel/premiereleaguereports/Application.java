package br.com.felipegabriel.premiereleaguereports;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.felipegabriel.premiereleaguereports.model.Match;
import br.com.felipegabriel.premiereleaguereports.model.Team;

public class Application {
	
	public static void main(String[] args) {
		List<String> lines = Collections.emptyList();
		
		// reading file
		try {
			lines = Files.readAllLines(Paths.get("src/resources/eng.1.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		
		teams.forEach(System.out::println);
	}
}
