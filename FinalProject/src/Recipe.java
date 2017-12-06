import java.util.*;
import javax.persistence.*;
@Entity
@Table(name = "Recipe")

public class Recipe{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="ID")
	private int id;
	@Column(name ="name")
	private String name;
	@Column(name ="instruct")
	private String instruct;
	@Column(name ="canon")
	private boolean canon;

	private List<Ingred> ingredList = new ArrayList<Ingred>();

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