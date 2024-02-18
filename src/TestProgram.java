package src;

public class TestProgram {

	private static LibraryInterface CSVLibrary;

	public static void main(String[] args) {
		CSVLibrary = new LibraryInterface();

		/* clean-up for repeated testing */
		CSVLibrary.deleteCSV("file1");
		CSVLibrary.deleteCSV("file2");

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
		/* Insert a line to the start of each CSV file */
		test6();
		/* Replace a line in each CSV file */
		test7();

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
		System.out.println("");
		CSVLibrary.appendLine("file1", "Numbers, object 1, object 2, object 3");
		CSVLibrary.appendLine("file2", "Letters, object A, object B, object C");

		System.out.println("File 2: Test 5");
		CSVLibrary.printCSV("file1");
		System.out.println("File 2: Test 5");
		CSVLibrary.printCSV("file2");
	}

	/* Inserting Lines to start of CSV files */
	public static void test6() {
		System.out.println("");
		CSVLibrary.insertLine("file1", 1, ",Heading 1, Heading 2, Heading 3");
		CSVLibrary.insertLine("file2", 1, ",Heading A, Heading B, Heading C");

		System.out.println("File 2: Test 6");
		CSVLibrary.printCSV("file1");
		System.out.println("File 2: Test 6");
		CSVLibrary.printCSV("file2");
	}

	/* Replacing Lines in CSV files */
	public static void test7() {
		System.out.println("");
		CSVLibrary.replaceLine("file1", 2, "Numbers, object 4, object 5, object 6");
		CSVLibrary.replaceLine("file2", 2, "Letters, object D, object E, object F");

		System.out.println("File 1: Test 7");
		CSVLibrary.printCSV("file1");
		System.out.println("File 2: Test 7");
		CSVLibrary.printCSV("file2");
	}
}
