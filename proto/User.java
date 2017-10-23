public class User {
	private String name;
	private Pantry mPantry;

	User(String name) {
		this.name = name;
		this.mPantry = new Pantry();
	}

	public String getName() {
		return this.name;
	}

	public Pantry getPantry() {
		return this.mPantry;
	}

	// public void runPC() {
	// 	mPC.run();
	// }
}