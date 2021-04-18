package br.com.felipegabriel.premiereleaguereports.model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
			.map(team -> sumPointsAsVisitor(team, matches))
			.map(team -> sumPointsAsHome(team, matches))
			.map(this::calculateGoalsDifference)
			.sorted(Comparator.comparingInt(Team::getGoalsDifference).reversed())
			.sorted(Comparator.comparingInt(Team::getPoints).reversed())
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
			.reduce((sum, goals) -> sum + goals);
		
		team.setGoalsFor(team.getGoalsFor() + goalsForHomeSum.orElse(0));
		
		return team;
	}
	
	public Team sumGoalsForAsVisitor(Team team, List<Match> matches) {
		Optional<Integer> goalsForVisitorSum = matches.stream()
			.filter(match -> match.getVisitor().equals(team.getName()))
			.map(Match::getVisitorScore)
			.reduce((sum, goals) -> sum + goals);
			
		team.setGoalsFor(team.getGoalsFor() + goalsForVisitorSum.orElse(0));
		
		return team;
	}
	
	public Team sumGoalsAgainstAsHome(Team team, List<Match> matches) {
		Optional<Integer> goalsAgainstHomeSum = matches.stream()
			.filter(match -> match.getHome().equals(team.getName()))
			.map(Match::getVisitorScore)
			.reduce((sum, goals) -> sum + goals);
			
		team.setGoalsAgainst(team.getGoalsAgainst() + goalsAgainstHomeSum.orElse(0));
		
		return team;
	}
	
	public Team sumGoalsAgainstAsVisitor(Team team, List<Match> matches) {
		Optional<Integer> goalsAgainstVisitorSum = matches.stream()
			.filter(match -> match.getVisitor().equals(team.getName()))
			.map(Match::getHomeScore)
			.reduce((sum, goals) -> sum + goals);
			
		team.setGoalsAgainst(team.getGoalsAgainst() + goalsAgainstVisitorSum.orElse(0));
		
		return team;
	}
	
	
	public Team calculateGoalsDifference(Team team) {
		team.setGoalsDifference(team.getGoalsFor() - team.getGoalsAgainst());
		
		return team;
	}
	
	public Team sumPointsAsVisitor(Team team, List<Match> matches) {
		Optional<Integer> pointsSum = matches.stream()
			.filter(match -> match.getVisitor().equals(team.getName()))
			.map(match -> calculateMatchPoints(match.getVisitorScore(), match.getHomeScore()))
			.reduce((sum, p) -> sum + p);
		
		team.setPoints(team.getPoints() + pointsSum.orElse(0));
		
		return team;
	}
	
	public Team sumPointsAsHome(Team team, List<Match> matches) {
		Optional<Integer> pointsSum = matches.stream()
			.filter(match -> match.getHome().equals(team.getName()))
			.map(match -> calculateMatchPoints(match.getHomeScore(), match.getVisitorScore()))
			.reduce((sum, p) -> sum + p);
		
		team.setPoints(team.getPoints() + pointsSum.orElse(0));
		
		return team;
	}
	
	public int calculateMatchPoints(int goalsFor, int goalsAgainst) {
		int matchPoints = 0;
		
		if (goalsFor > goalsAgainst) {
			matchPoints = 3;
		}
		
		if (goalsFor == goalsAgainst) {
			matchPoints = 1;
		}
		
		return matchPoints;
	} 
}
