import java.util.*;

public class IngredFilter implements Filterer {
	private Pantry mPantry;

	IngredFilter (Pantry mPantry) {
		this.mPantry = mPantry;
	}

	public RecipeList filter(RecipeList input) {
		RecipeList output = new RecipeList();
		for (int i = 0; i < input.getSize(); i++) {
			Recipe curr = input.getAt(i);
			List<Ingred> iList = curr.getIngredList();
			if (ingredMatch(iList)) {
				output.add(curr);
			}
		}
		return output;
	}

	private boolean ingredMatch(List<Ingred> iList) {
		for (int i = 0; i < iList.size(); i++) {
			String iName = iList.get(i).getName();
			String iUnit = iList.get(i).getUnit();
			double iAmount = iList.get(i).getAmount();
			for (int j = 0; j < mPantry.getSize(); j++) {
				if (mPantry.getAt(j).getName().equals(iName)) {
					if (mPantry.getAt(j).getUnit().equals(iUnit)) {
						if (mPantry.getAt(j).getAmount() - iAmount >= 0.0) {
							break;
						}
					}
				}
				if(j == mPantry.getSize()-1) {
					return false;
				}
			}
		}
		return true;
	}
}
