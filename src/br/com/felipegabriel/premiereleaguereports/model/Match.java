package br.com.felipegabriel.premiereleaguereports.model;

import java.time.LocalDate;

public class Match {
	
	private int round;
	
	private LocalDate date;
	
	private String home;
	
	private String visitor;
	
	private int homeScore;
	
	private int visitorScore;

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(int visitorScore) {
		this.visitorScore = visitorScore;
	}

	@Override
	public String toString() {
		return "Match [round=" + round + ", date=" + date + ", home=" + home + ", visitor=" + visitor + ", homeScore="
				+ homeScore + ", visitorScore=" + visitorScore + "]";
	}
	
	
}
