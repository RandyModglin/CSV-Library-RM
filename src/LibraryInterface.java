package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LibraryInterface {

	private final FileHandler handler = new FileHandler();
	private final FileEditor editor = new FileEditor();

	public void createCSV(String filename) {
		File currFile = handler.getCSVFile(filename);

		if (currFile == null) {
			handler.createCSV(filename);
			System.out.println("Created File: " + filename);
		} else {
			System.out.println("File already exists");
		}
	}

	public void printCSV(String filename) {
		File currFile = handler.getCSVFile(filename);

		if (currFile != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist");
		}
	}

	public void deleteCSV(String filename) {
		File currFile = handler.getCSVFile(filename);

		if (currFile != null) {
			handler.deleteCSV(filename);
			System.out.println("Deleted File: " + filename);
		} else {
			System.out.println("File doesn't exists");
		}
	}
}
