package br.com.felipegabriel.premiereleaguereports.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class File {
		
	public List<String> readFile(String uri) {
		List<String> lines = new ArrayList<>();
		
		try {
			lines = Files.readAllLines(Paths.get(uri), StandardCharsets.UTF_8);
			
			return lines;
		} catch (IOException e) {
			System.err.println("Error reading file!");
		}
		
		return lines;
	}
}
