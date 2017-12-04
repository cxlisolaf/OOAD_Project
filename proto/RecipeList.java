import java.util.*;

public class RecipeList {
	private List<Recipe> recipeList = new ArrayList<Recipe>();

	RecipeList() {
	}

	public List<Recipe> getRecipeList() {
		return this.recipeList;
	}

	public Recipe getAt(int index) {
		return recipeList.get(index);
	}

	public int getSize() {
		return this.recipeList.size();
	}

	public void add(Recipe newRecipe) {
		recipeList.add(newRecipe);
	}

	public void remove(int index) {
		recipeList.remove(index-1);
	}

	public void edit(int index) {
	}

}