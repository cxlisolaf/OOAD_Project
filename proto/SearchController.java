import java.util.*;

public class SearchController {
	private RecipeList mRL;
	private User mUser;
	private Scanner sc = new Scanner(System.in);
	private Filterer mFilter;
	private RecipeList SearchResult;

	SearchController (RecipeList mRL, User mUser) {
		this.mRL = mRL;
		this.mUser = mUser;
	}

	private void clearDisplay() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
	}

	public void run() {
		int option;
		while (true) {
			clearDisplay();
			System.out.println("Search");
			System.out.println("\nMenu\n1 to search by ingredients\n2 to search by name\n0 to Quit");
					option = sc.nextInt();
					switch(option) {
						case 0:	return;

						case 1:	mFilter = new IngredFilter(mUser.getPantry());
						 		break;

						case 2: sc.nextLine();
								clearDisplay();
								System.out.println("Enter search term");
								String match = sc.nextLine();
								mFilter = new StringFilter(match);
								break;

						default : break;
					}
			RecipeListController rc = new RecipeListController(mFilter.filter(mRL), mUser.getFavs(), mUser.getHistory(), mUser.getPantry(), 3);
			rc.run();
		}
	}
}


