import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class PantryController {
	private Pantry mPantry;
	private Scanner sc = new Scanner(System.in);
    private SessionFactory factory;

	PantryController(Pantry mPantry) {
		this.mPantry = mPantry;
		try {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Ingred.class)
					.buildSessionFactory();
		}catch(Exception e){
			System.out.println(e);
		}
        this.mPantry.setSessionFactory(factory);
	}

	private void clearDisplay() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
	}

	private void display() {
		mPantry.display();
	}

	private void displayNumbered() {
		for (int i = 0; i < mPantry.getSize(); i++) {
			System.out.println((i+1) + "\t" + mPantry.getAt(i).getName());
		}
	}

	private void add() {
		String name;
		String unit;
		double amount;
		System.out.println("Enter name of Ingredient");
		name = sc.next();
		System.out.println("Enter name of Unit");
		unit = sc.next();
		System.out.println("Enter Anmount");
		amount = sc.nextDouble();
		Ingred newIn = new Ingred(name, unit, amount);
		mPantry.add(newIn);
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
		int option;
		double amount;
		clearDisplay();
		displayNumbered();
		System.out.println("Select a number to adjust it");
		option = sc.nextInt()-1;
		if (option > mPantry.getSize()) return;
		System.out.println(mPantry.getAt(option).getName() + "\t" + mPantry.getAt(option).getAmount() + "\t" + mPantry.getAt(option).getUnit());		
		System.out.println("Enter new amount");
		amount = sc.nextDouble();
		if (amount == 0.0) {
			mPantry.remove(option+1);	
		}
		else {
			mPantry.getAt(option).setAmount(amount);
		}
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

				case 3: adjust();
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