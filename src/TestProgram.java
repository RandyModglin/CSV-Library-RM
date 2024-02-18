package src;

public class TestProgram {

	private static LibraryInterface CSVLibrary;

	public static void main(String[] args) {
		CSVLibrary = new LibraryInterface();

		/* Library creates CSV file */
		test1();
		/* Library deletes CSV file */
		test2();
		/* Library tries to delete CSV file that doesn't exist, should fail */
		test3();
		/* Library creates 2 CSV file */
		test4();
		/* Append a line to each CSV file */
		test5();

	}

	/* Create CSV File, if successful it will print to Output */
	public static void test1() {
		CSVLibrary.createCSV("file1");
	}

	/* Delete CSV File, if successful it will print to Output */
	public static void test2() {
		CSVLibrary.deleteCSV("file1");
	}

	/* Delete CSV File that doesn't exist, shoul fail */
	public static void test3() {
		CSVLibrary.deleteCSV("file1");
	}

	/* Create 2 CSV Files, if successful it will print to Output */
	public static void test4() {
		CSVLibrary.createCSV("file1");
		CSVLibrary.createCSV("file2");
	}

	/* Append Lines to end of CSV files */
	public static void test5() {
		CSVLibrary.appendLine("file1", ",Heading 1, Heading 2, Heading 3");
		CSVLibrary.appendLine("file2", ",Heading A, Heading B, Heading C");

		CSVLibrary.printCSV("file1");
		CSVLibrary.printCSV("file2");
	}
}
