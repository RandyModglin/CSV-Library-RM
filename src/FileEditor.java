package src;

import java.io.*;

public class FileEditor {
	public void appendLine(File file, String content) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(content + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.err.print("Error: ");
			e.printStackTrace();
		}
	}

	public void deleteLine(File file, int lineNumber) throws IOException {
		editLine(file, lineNumber, 0, "");
	}

	public void insertLine(File file, int lineNumber, String content) throws IOException {
		editLine(file, lineNumber, 1, content);
	}

	public void replaceLine(File file, int lineNumber, String content) throws IOException {
		editLine(file, lineNumber, 2, content);
	}

	private void editLine(File file, int lineNum, int opCode, String content) throws IOException {
		String folderPath = System.getProperty("user.dir") + File.separator + "CSVs";
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
			System.out.println("Folder Created: CSVs");
		}

		String newFilePath = folderPath + File.separator + file.getName() + ".csv";
		File newFile = new File(newFilePath);

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
					writer.write(content + "\n");
					writer.write(currLine + "\n");
					break;
				case 2: /* Replace */
					writer.write(content + "\n");
					i++;
					break;
				}
			} else {
				/* Add in other lines */
				writer.write(currLine + "\n");
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