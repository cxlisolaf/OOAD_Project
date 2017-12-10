import java.util.*;

public class Proto {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User(args[0]);
		int option = 0;

		//System.out.println("Welcome " + user.getName());
		RecipeList mRL = new RecipeList();
		fillRecipes(mRL);

		while (true) {
			clearDisplay();
			System.out.println("Welcome " + user.getName());
			System.out.println("Menu\n1 to view Pantry\n2 to view Recipes\n3 to view Favorites\n4 to view Histroy\n5 to Search\n0 to Quit");
			option = sc.nextInt();

			switch(option) {
				case 0:	clearDisplay();
						return;

				case 1:	PantryController pc = new PantryController(user.getPantry());
						pc.run();
						pc = null;
						break;
				
				case 2:	RecipeListController rc = new RecipeListController(user.getRecipeList(),user.getFavs(),user.getHistory(),user.getPantry(),0);
						rc.run();
						rc = null;
						break;
				
				case 3:	RecipeListController rc1 = new RecipeListController(user.getFavs(),user.getFavs(),user.getHistory(),user.getPantry(),1);
						rc1.run();
						rc1 = null;
						break;

				case 4:	RecipeListController rc2 = new RecipeListController(user.getHistory(),user.getFavs(),user.getHistory(),user.getPantry(),2);
						rc2.run();
						rc2 = null;
						break;

				case 5: SearchController srchc = new SearchController(mRL, user);
						srchc.run();
						srchc = null;
						break;

				default: break;
			}
		}
	}

	static void clearDisplay() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
	}

	static void fillRecipes(RecipeList mRL) {
		Recipe gc = new Recipe ("Grilled Cheese");
		gc.setInstruct("Grill it up!");
		List<Ingred> gcList = new ArrayList<Ingred>();
		Ingred gc1 = new Ingred("cheese", "slice", 1.0);
		Ingred gc2 = new Ingred("bread", "slice", 2.0);
		Ingred gc3 = new Ingred("butter", "oz", 2.0);
		gcList.add(gc1);
		gcList.add(gc2);
		gcList.add(gc3);
		gc.setIngredList(gcList);

		mRL.add(gc);
	}

	// static void pantryView(User user) {
	// 	Scanner sc = new Scanner(System.in);
	// 	int option = 0;

	// 	while(true) {
	// 		System.out.print("\033[H\033[2J");
	// 		System.out.flush();
	// 		System.out.println(user.getName() + "'s Pantry");
	// 		user.getPantry().display();
	// 		System.out.println("\nMenu\n1 to add ingredient\n2 to remove ingredient\n3 to edit ingredient amount\n0 to Quit");
	// 		option = sc.nextInt();
	// 		switch(option) {
	// 			case 0:	clearDisplay();
	// 					return;

	// 			case 1:	user.getPantry().add();
	// 					break;

	// 			case 2: System.out.print("\033[H\033[2J");
	// 					System.out.flush();
	// 					user.getPantry().displayNumbered();
	// 					System.out.println("Select a number to remove it");
	// 					option = sc.nextInt();
	// 					user.getPantry().remove(option);
	// 					break;

	// 			case 3: System.out.print("\033[H\033[2J");
	// 					System.out.flush();
	// 					user.getPantry().displayNumbered();
	// 					System.out.println("Select a number to adjust it");
	// 					option = sc.nextInt();
	// 					user.getPantry().adjust(option);
	// 					break;

	// 			default : break;
	// 		}
	// 	}
	// }

}