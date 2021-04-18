package br.com.felipegabriel.premiereleaguereports.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class Report {

	public String createReport(List<Team> teams) {
		StringBuilder report = new StringBuilder();
		report.append("<!DOCTYPE html>");
		report.append("<html lang=\"en\">");
		report.append("<head>");
		report.append("<meta charset=\"UTF-8\" />");
		report.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		report.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		report.append("<title>premiere-league-2019</title>");
		report.append("<style>");
		report.append("html, body { font-family: arial, sans-serif; }");
		report.append("table {width: 100%; margin-top: 50px; border-collapse: collapse; }");
		report.append("td, th {border: 1px solid rgb(167, 149, 149); text-align: center; padding: 8px; }");
		report.append("tr:nth-child(even) { background-color: #dddddd; }");
		report.append(".print-date { float: right; font-size: 12px; }");
		report.append("</style>");
		report.append("</head>");
		report.append("<body>");
		report.append("<p>Premiere League 2019/2020</p>");
		report.append("<hr />");
		report.append(createTable(teams));
		report.append("<p class=\"print-date\">Impresso " + LocalDate.now() + "</p>");
		report.append("</body>");
		report.append("</html>");
		return report.toString();
	}
	
	public String createTable(List<Team> teams) {
		StringBuilder table = new StringBuilder();
		table.append("<table>");
		
		String[] headers = {"Colocação", "Time", "GP", "GC", "SG", "Pontuação"};
		
		table.append(createTableHeader(headers));
		
		IntStream.range(0, teams.size())
			.forEach(i -> table.append(createTableRow(teams.get(i), i)));
		
		table.append("</table>");
		
		return table.toString();
	}
	
	public String createTableHeader(String[] headers) {
		StringBuilder header = new StringBuilder();
		header.append("<tr>");
		
		Arrays.asList(headers)
			.forEach(headerTitle -> header.append("<th>" + headerTitle + "</th>"));
		
		header.append("</tr>");
		
		return header.toString();
		
	}
	
	public String createTableRow(Team team, int index) {
		StringBuilder row = new StringBuilder();
		row.append("<tr>");
		row.append(td(index + 1));
		row.append(td(team.getName()));
		row.append(td(team.getGoalsFor()));
		row.append(td(team.getGoalsAgainst()));
		row.append(td(team.getGoalsDifference()));
		row.append(td(team.getPoints()));
		row.append("</tr>");
		
		return row.toString();
	}
	
	public String td(Object content) {
		return "<td>" + content + "</td>";
	}
}
