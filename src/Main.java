public class Main {
	public static void main(String[] args) {
	    GatherInput gatherer1 = new GatherInput();
		
		String[] none = {"none"};
		
		System.out.println("What would you like to do?");
		String[] commands = {"save", "load", "delete"};
		String command = gatherer1.gather(commands);

		switch(command) {
			case "save":
				System.out.println("What do you want to save?");
				String data = gatherer1.gather(none);
				System.out.println("Where do you want to save it?");
				String locationToSave = gatherer1.gather(none);
				if (gatherer1.save(locationToSave, data)) {
					System.out.println("Save of \"" + data + "\" in " + locationToSave + " successful.");
				}
				break;
			case "load":
				System.out.println("Where do you want to load from?");
				String locationToLoad = gatherer1.gather(none);
				System.out.println("Data loaded:\n" + gatherer1.load(locationToLoad));
			default:
				break;
		}

	}
}