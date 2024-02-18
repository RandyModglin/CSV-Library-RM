package src;

public class TestProgram {

	private static LibraryInterface CSVLibrary;

	public static void main(String[] args) {
		CSVLibrary = new LibraryInterface();

		/* Library creates CSV file */
		test1();

		/* Library creates CSV file */
		test2();

	}

	/* Create CSV File, if successful it will print to Output */
	public static void test1() {
		CSVLibrary.createCSV("file1");
	}

	/* Delete CSV File, if successful it will print to Output */
	public static void test2() {
		CSVLibrary.deleteCSV("file1");
	}
}
