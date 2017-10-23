import java.util.*;

public class PantryController {
	private Pantry mPantry;
	private Scanner sc = new Scanner(System.in);

	PantryController(Pantry mPantry) {
		this.mPantry = mPantry;
	}

	private void clearDisplay() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
	}

	private void display() {
		for (int i = 0; i < mPantry.getSize(); i++) {
			System.out.println(mPantry.getAt(i).getName() + "\t" + mPantry.getAt(i).getAmount() + "\t" + mPantry.getAt(i).getUnit());
		}
	}

	private void displayNumbered() {
		for (int i = 0; i < mPantry.getSize(); i++) {
			System.out.println((i+1) + "\t" + mPantry.getAt(i).getName());
		}
	}

	private void add() {

	}

	private void remove() {
		int option;
		clearDisplay();
		displayNumbered();
		System.out.println("Select a number to remove it");
		option = sc.nextInt();
		if (option > mPantry.getSize()) return;
		mPantry.remove(option);		
	}

	private void adjust() {
		
	}

	public void run() {
		//Scanner sc = new Scanner(System.in);
		int option = 0;

		while(true) {
			clearDisplay();
			System.out.println("Your Pantry");
			display();
			System.out.println("\nMenu\n1 to add ingredient\n2 to remove ingredient\n3 to edit ingredient amount\n0 to Quit");
			option = sc.nextInt();
			switch(option) {
				case 0:	return;

				case 1:	add();
				 		break;

				case 2: remove();
						break;

				// case 3: System.out.print("\033[H\033[2J");
				// 		System.out.flush();
				// 		user.getPantry().displayNumbered();
				// 		System.out.println("Select a number to adjust it");
				// 		option = sc.nextInt();
				// 		user.getPantry().adjust(option);
				// 		break;

				default : break;
			}
		}

	}
}