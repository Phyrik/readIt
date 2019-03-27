public class Main {
	public static void main(String[] args) {
	    GatherInput gatherer1 = new GatherInput();
		
		String[] none = {"none"};
		System.out.println("What data? (it doesn't matter what you type here if you want to load data)");
		String data = gatherer1.gather(none);
		System.out.println("Where should the data be stored/loaded from? (include file extension)");
		String location = gatherer1.gather(none);

		String[] commands = {"save", "load"};
		System.out.println("What do you want to do to the data?");
		String command = gatherer1.gather(commands);

		switch(command) {
			case "save":
				if (gatherer1.save(location, data)) {
					System.out.println("Save of \"" + data + "\" in " + location + " successful.");
				}
				break;
			case "load":
				System.out.println("Data loaded:\n" + gatherer1.load(location));
			default:
				break;
		}
	}
}