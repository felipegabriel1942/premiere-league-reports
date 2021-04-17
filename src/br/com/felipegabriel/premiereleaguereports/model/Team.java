package br.com.felipegabriel.premiereleaguereports.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
	
	private String name;
	private int points;
	private int goalsFor;
	private int goalsAgainst;
	private int goalsDifference;
	
	public List<Team> createTeams(List<Match> matches) {
		return matches.stream()
			.map(Match::getHome)
			.map(this::createTeam)
			.distinct()
			.collect(Collectors.toList());
	
	}
	
	public Team createTeam(String teamName) {
		return Team.builder()
			.name(teamName)
			.build();
	}
}
