package br.com.felipegabriel.premiereleaguereports.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Team {
	
	private String name;
	private int points;
	private int goalsFor;
	private int goalsAgainst;
	private int goalsDifference;
	
}
