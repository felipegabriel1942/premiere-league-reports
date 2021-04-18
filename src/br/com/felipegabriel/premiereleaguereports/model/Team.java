package br.com.felipegabriel.premiereleaguereports.model;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
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
			.map(team -> sumGoalsForAsHome(team, matches))
			.map(team -> sumGoalsForAsVisitor(team, matches))
			.map(team -> sumGoalsAgainstAsHome(team, matches))
			.map(team -> sumGoalsAgainstAsVisitor(team, matches))
			.map(this::calculateGoalsDifference)
			.distinct()
			.collect(Collectors.toList());
	}
	
	public Team createTeam(String teamName) {
		return Team.builder()
			.name(teamName)
			.build();
	}
	
	public Team sumGoalsForAsHome(Team team, List<Match> matches) {
		Optional<Integer> goalsForHomeSum = matches.stream()
			.filter(match -> match.getHome().equals(team.getName()))
			.map(Match::getHomeScore)
			.reduce(sum);
		
		team.setGoalsFor(team.getGoalsFor() + goalsForHomeSum.orElse(0));
		
		return team;
	}
	
	public Team sumGoalsForAsVisitor(Team team, List<Match> matches) {
		Optional<Integer> goalsForVisitorSum = matches.stream()
			.filter(match -> match.getVisitor().equals(team.getName()))
			.map(Match::getVisitorScore)
			.reduce(sum);
			
		team.setGoalsFor(team.getGoalsFor() + goalsForVisitorSum.orElse(0));
		
		return team;
	}
	
	public Team sumGoalsAgainstAsHome(Team team, List<Match> matches) {
		Optional<Integer> goalsAgainstHomeSum = matches.stream()
			.filter(match -> match.getHome().equals(team.getName()))
			.map(Match::getVisitorScore)
			.reduce(sum);
			
		team.setGoalsAgainst(team.getGoalsAgainst() + goalsAgainstHomeSum.orElse(0));
		
		return team;
	}
	
	public Team sumGoalsAgainstAsVisitor(Team team, List<Match> matches) {
		Optional<Integer> goalsAgainstVisitorSum = matches.stream()
			.filter(match -> match.getVisitor().equals(team.getName()))
			.map(Match::getHomeScore)
			.reduce(sum);
			
		team.setGoalsAgainst(team.getGoalsAgainst() + goalsAgainstVisitorSum.orElse(0));
		
		return team;
	}
	
	public Team calculateGoalsDifference(Team team) {
		team.setGoalsDifference(team.getGoalsFor() - team.getGoalsAgainst());
		return team;
	}
	
	BinaryOperator<Integer> sum = (ac, g) -> ac + g;
	
}
