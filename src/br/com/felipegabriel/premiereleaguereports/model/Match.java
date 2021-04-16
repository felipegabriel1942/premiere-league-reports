package br.com.felipegabriel.premiereleaguereports.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Match {
	
	private int round;
	private LocalDate date;
	private String home;
	private String visitor;
	private int homeScore;
	private int visitorScore;	
	
}
