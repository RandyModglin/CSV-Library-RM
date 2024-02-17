package src;

import java.io.*;

public class FileEditor {

	private final FileHandler handler = new FileHandler();

	public void appendLine(String fileName, String content) {
		try {
			File currFile = handler.getCSVFile(fileName);
			FileWriter fr = new FileWriter(currFile, true);
			fr.write(content);
		} catch (IOException e) {
			System.err.print("Error: ");
			e.printStackTrace();
		}
	}

	public void deleteLine(String fileName, int lineNumber) throws IOException {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editLine(currFile, lineNumber, 0, "");
		}
	}

	public void insertLine(String fileName, int lineNumber, String content) throws IOException {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editLine(currFile, lineNumber, 1, content);
		}
	}

	public void replaceLine(String fileName, int lineNumber, String content) throws IOException {
		File currFile = handler.getCSVFile(fileName);

		if (currFile != null) {
			editLine(currFile, lineNumber, 2, content);
		}
	}

	private void editLine(File file, int lineNum, int opCode, String content) throws IOException {
		File newFile = new File("temp.tmp");

		/* Create reader and writer */
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

		String currLine;
		int i = 1;
		/* Look for relevant line to change */
		while ((currLine = reader.readLine()) != null) {
			if (i == lineNum) {
				switch (opCode) {
				case 0: /* Remove */
					break;
				case 1: /* Insert */
					writer.write(content);
					break;
				case 2: /* Replace */
					writer.write(content);
					i++;
					break;
				}
			} else {
				/* Add in other lines */
				writer.write(content);
			}
			i++;
		}

		/* Clean Up */
		writer.flush();
		writer.close();
		reader.close();

		file.delete();
		newFile.renameTo(file);
	}
}