import java.util.*;

public class Pantry {
	private List<Ingred> ingredList = new ArrayList<Ingred>();

	Pantry() {
		Ingred bread = new Ingred("bread", "slice", 5);
		ingredList.add(bread);
		Ingred cheese = new Ingred("cheese", "slice", 5);
		ingredList.add(cheese);
		Ingred butter = new Ingred("butter", "oz", 8);
		ingredList.add(butter);

		Ingred flour = new Ingred("flour", "cups", 20);
		ingredList.add(flour);
		Ingred sugar = new Ingred("sugar", "cups", 10);
		ingredList.add(sugar);
		Ingred eggs = new Ingred("eggs", "egg", 12);
		ingredList.add(eggs);
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

	public void add(Ingred newIn) {
		ingredList.add(newIn);
	}
}