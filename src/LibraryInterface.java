package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LibraryInterface {

	private final FileHandler handler = new FileHandler();
	private final FileEditor editor = new FileEditor();

	public void createCSV(String filename) {
		handler.createCSV(filename);
	}

	public void printCSV(String filename) {
		File currFile = handler.getCSVFile(filename);

		if (currFile != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(currFile))) {
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteCSV(String fileName) {
		handler.deleteCSV(fileName);
	}

	public void appendLine(String fileName, String content) {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editor.appendLine(currFile, content);
			System.out.println("Appending to: " + fileName);
		} else {
			System.out.println("File doesn't exists");
		}
	}

	public void deleteLine(String fileName, int lineNum) throws IOException {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editor.deleteLine(currFile, lineNum);
		} else {
			System.out.println("File doesn't exists");
		}

	}

	public void insertLine(String fileName, int lineNum, String content) throws IOException {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editor.insertLine(currFile, lineNum, content);
		} else {
			System.out.println("File doesn't exists");
		}
	}

	public void replaceLine(String fileName, int lineNum, String content) throws IOException {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editor.replaceLine(currFile, lineNum, content);
		} else {
			System.out.println("File doesn't exists");
		}
	}
}
