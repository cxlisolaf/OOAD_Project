import java.util.*;

public class Pantry {
	private List<Ingred> ingredList = new ArrayList<Ingred>();

	Pantry() {
		Ingred bread = new Ingred("bread", "loaf", 1);
		ingredList.add(bread);
	}

	public Ingred getAt(int num) {
		return this.ingredList.get(num);
	}

	public int getSize() {
		return this.ingredList.size();
	}

	public void display() {
		for (int i = 0; i < ingredList.size(); i++) {
			System.out.println(ingredList.get(i).getName() + "\t" + ingredList.get(i).getAmount() + "\t" + ingredList.get(i).getUnit());
		}
	}

	public void displayNumbered() {
		for (int i = 0; i < ingredList.size(); i++) {
			System.out.println((i+1) + "\t" + ingredList.get(i).getName());
		}
	}

	public void remove(int num) {
		ingredList.remove(num-1);
	}

	public void adjust(int num) {
		
	}

	public void add() {
		
	}
}