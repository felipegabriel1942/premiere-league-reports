package br.com.felipegabriel.premiereleaguereports.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface CustomDateUtils {
		
	public static LocalDate createDate(String string) {
		return LocalDate.parse(string, DateTimeFormatter.ofPattern("E MMM d yyyy", Locale.US));
	}
	
	public static LocalDate createDate(String string, String pattern) {
		return LocalDate.parse(string, DateTimeFormatter.ofPattern(pattern, Locale.US));
	}
}
