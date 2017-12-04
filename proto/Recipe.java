import java.util.*;

public class Recipe {
	private String name;
	private List<Ingred> ingredList = new ArrayList<Ingred>();
	private String instruct;
	private boolean canon;

	Recipe(String name) {
		this.name = name;
		this.instruct = "";
		this.canon = false;
	}

	public String getName() {
		return this.name;
	}

	public List<Ingred> getIngredList() {
		return this.ingredList;
	}

	public String getInstruct() {
		return this.instruct;
	}

	public boolean getCanon() {
		return this.canon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIngredList(List<Ingred> ingredList) {
		this.ingredList = ingredList;
	}

	public void setInstruct(String instruct) {
		this.instruct = instruct;
	}

	public void setCanon(boolean canon) {
		this.canon = canon;
	}

	public String toString() {
		String ingreds = "";
		for (int i = 0; i < ingredList.size(); i++) {
			ingreds += (ingredList.get(i) + "\n");
		}
		return this.name + "\n" + ingreds + "\n" + this.instruct;
	}

}