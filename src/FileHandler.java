package src;

import java.io.File;
import java.io.IOException;

public class FileHandler {

	public void createCSV(String filename) {
		try {
			String folderName = "CSVs";

			// Create the folder path in the same directory as program
			String folderPath = System.getProperty("user.dir") + File.separator + folderName;
			File folder = new File(folderPath);
			if (folder.mkdirs()) {
				System.out.println("Folder Created: " + folderPath);
			}

			// Place the CSV file into the CSVs folder
			String filePath = folderPath + File.separator + filename + ".csv";
			File csv = new File(filePath);

			// Create the CSV file, check if name already exists
			if (csv.createNewFile()) {
				System.out.println("File created: " + csv.getName());
			} else {
				System.out.println("File exists already: " + csv.getName());
			}

		} catch (IOException e) {
			System.err.print("Error: ");
			e.printStackTrace();
		}
	}

	public void deleteCSV(String filename) {
		try {
			// Get the path for CSV folder
			String filePath = System.getProperty("user.dir") + File.separator + "CSVs" + File.separator + filename
					+ ".csv";
			File csvFile = new File(filePath);

			// Check if the file exists, delete if it does
			if (csvFile.exists()) {
				if (csvFile.delete()) {
					System.out.println("File deleted: " + csvFile.getName());
				} else {
					System.out.println("Failed to delete file: " + csvFile.getName());
				}
			} else {
				System.out.println("File does not exist: " + csvFile.getName());
			}
		} catch (Exception e) {
			System.err.println("Error occurred while trying to delete CSV file named:" + filename);
			e.printStackTrace();
		}
	}

	public File getCSVFile(String filename) {
		// Get the path for CSV folder
		String filePath = System.getProperty("user.dir") + File.separator + "CSVs" + File.separator + filename + ".csv";
		File csvFile = new File(filePath);

		// Check if the file exists, return it if it does
		if (csvFile.exists()) {
			return csvFile;
		} else {
			return null;
		}
	}
}
