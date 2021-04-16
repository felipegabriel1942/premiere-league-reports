package br.com.felipegabriel.premiereleaguereports;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		List<String> lines = Collections.emptyList();
		
		try {
			lines = Files.readAllLines(Paths.get("src/resources/eng.1.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lines.forEach(System.out::println);
	}
}
