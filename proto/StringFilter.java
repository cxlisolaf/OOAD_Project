import java.util.*;

public class StringFilter implements Filterer {
	private String match;

	StringFilter (String match) {
		this.match = match;
	}

	public RecipeList filter(RecipeList input) {
		RecipeList output = new RecipeList();
		for (int i = 0; i < input.getSize(); i++) {
			Recipe curr = input.getAt(i);
			String rName = curr.getName();
			if (rName.toLowerCase().contains(match.toLowerCase())) {
				output.add(curr);
			}
		}
		return output;
	}
}
