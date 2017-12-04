public class User {
	private String name;
	private Pantry mPantry;
	private RecipeList mRecipeList;
	private RecipeList favs;
	private RecipeList history;

	User(String name) {
		this.name = name;
		this.mPantry = new Pantry();
		this.mRecipeList = new RecipeList();
		this.favs = new RecipeList();
		this.history = new RecipeList();
	}

	public String getName() {
		return this.name;
	}

	public Pantry getPantry() {
		return this.mPantry;
	}

	public RecipeList getRecipeList() {
		return this.mRecipeList;
	}

	public RecipeList getFavs() {
		return this.favs;
	}

	public RecipeList getHistory() {
		return this.history;
	}
	// public void runPC() {
	// 	mPC.run();
	// }
}