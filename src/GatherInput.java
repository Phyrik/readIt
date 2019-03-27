import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class GatherInput {
	public static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
		
	}
	
	public static String checkString(String[] possibilities, String valueEntered) {
		for (String checker : possibilities) {
			if (checker.equals(valueEntered)) {
				return checker;
			}
		}
		return "404";
	}
	
	public static String gather(String[] commands) {
		String[] valuesEntered = sc.nextLine().split(" ");
		String valueEntered = String.join(" ", valuesEntered);
		if (commands[0].equals("none")) {
			return valueEntered;
		}
		
		return checkString(commands, valueEntered);
	}

	public static boolean save(String location, String data) {
		try {
			File fileToSaveTo = new File(location);
			if (fileToSaveTo.exists()) {
				FileWriter writer = new FileWriter(location, true);
				System.out.println("File already exists, writing to " + location + " instead...");
				writer.write(data + "\n");
				writer.close();
				return true;
			} else {
				FileWriter writer = new FileWriter(location, true);
				fileToSaveTo.createNewFile();
				System.out.println("File " + location + " created...");
				writer.write(data + "\n");
				writer.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println("An error occured saving the file.");
			e.printStackTrace();
		}

		return false;
	}

	public static String load(String location) {
		try {
			File fileToWriteTo = new File(location);
			Scanner reader = new Scanner(fileToWriteTo);
			String data = "";
			while (reader.hasNextLine()) {
				data += reader.nextLine() + "\n";
			}
			reader.close();
			return data;
		} catch (FileNotFoundException e) {
			System.out.println("An error occured loading the file.");
			e.printStackTrace();
		}
		return "";
	}
}