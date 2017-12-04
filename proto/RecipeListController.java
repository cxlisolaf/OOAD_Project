import java.util.*;

public class RecipeListController {
	private RecipeList mRC;
	private RecipeList mF;
	private RecipeList mH;
	private Scanner sc = new Scanner(System.in);
	int type;

	RecipeListController(RecipeList mRC, RecipeList mF, RecipeList mH, int type) {
		this.mRC = mRC;
		this.mF = mF;
		this.mH = mH;
		this.type = type;
	}

	private void clearDisplay() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
	}

	private void display() {
		for (int i = 0; i < mRC.getSize(); i++) {
			System.out.println((i+1) + "\t" + mRC.getAt(i).getName());
		}
	}

	private void view() {
		int option;
		clearDisplay();
		display();
		System.out.println("Select a number to view it");
		option = sc.nextInt()-1;
		Recipe mR = mRC.getAt(option);
		clearDisplay();
		System.out.println(mR);
		System.out.println("\n1 to add to favorites, 2 to add to history, 0 to quit");
		option = sc.nextInt();
		if (option == 1) {
			mF.add(mR);
		}
		if (option == 2) {
			mH.add(mR);
		}
	}

	private void add() {
		clearDisplay();
		sc.nextLine();
		String name;
		System.out.println("Enter name of recipe");
		name = sc.nextLine();
		Recipe mR = new Recipe(name);
		System.out.println("Enter ingredient name");
		String ingredName = sc.next();
		List<Ingred> iList = new ArrayList<Ingred>();
		while (!ingredName.equals("0")) {
			System.out.println("Enter ingredient units");
			String unit = sc.next();
			System.out.println("Enter ingredient amount");
			double amount = sc.nextDouble();
			Ingred mI = new Ingred(ingredName, unit, amount);
			iList.add(mI);
			System.out.println("Enter ingredient name (0 to end)");
			ingredName = sc.next();
		}
		mR.setIngredList(iList);
		sc.nextLine();
		System.out.println("Enter instructions");
		String instructions = sc.nextLine();
		mR.setInstruct(instructions);
		mRC.add(mR);
	}

	private void remove() {
		int option;
		clearDisplay();
		display();
		System.out.println("Select a number to remove it");
		option = sc.nextInt();
		mRC.remove(option);
	}

	public void run() {
		//Scanner sc = new Scanner(System.in);
		int option = 0;

		if (type == 0) {
			while(true) {
				clearDisplay();
				System.out.println("Your Recipes");
				display();
				System.out.println("\nMenu\n1 to view\n2 to add\n3 to remove\n0 to Quit");
				option = sc.nextInt();
				switch(option) {
					case 0:	return;

					case 1:	view();
					 		break;

					case 2: add();
							break;

					case 3: remove();
							break;

					default : break;
				}
			}
		}
		else {
			while(true) {
				clearDisplay();
				System.out.println("Your Recipes");
				display();
				System.out.println("\nMenu\n1 to view\n2 to remove\n0 to Quit");
				option = sc.nextInt();
				switch(option) {
					case 0:	return;

					case 1:	view();
					 		break;

					case 2: remove();
							break;

					default : break;
				}
			}
		}

	}
}