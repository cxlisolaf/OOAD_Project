import java.util.*;

public class Proto {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User(args[0]);
		int option = 0;

		//System.out.println("Welcome " + user.getName());

		while (true) {
			clearDisplay();
			System.out.println("Welcome " + user.getName());
			System.out.println("Menu\n1 to view Pantry\n2 to view Recipes\n3 to view Favorites\n4 to view Histroy\n0 to Quit");
			option = sc.nextInt();

			switch(option) {
				case 0:	clearDisplay();
						return;

				case 1:	PantryController pc = new PantryController(user.getPantry());
						pc.run();
						pc = null;
						break;
				default: break;
			}
		}
	}

	static void clearDisplay() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
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