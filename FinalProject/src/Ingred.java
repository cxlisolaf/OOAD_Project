import javax.persistence.*;
@Entity
@Table(name = "Ingredient")
public class Ingred {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="ID")
	private int id;
	@Column(name ="name")
	private String name;
	@Column(name ="unit")
	private String unit;
	@Column(name ="amount")
	private double amount;
	@Column(name ="resource")
	private String resource;

	Ingred(){

	}

	Ingred(String name) {
		this.name = name;
		this.unit = "undef";
		this.amount = 1;
	}

	Ingred(String name, String unit, double amount, String resource) {
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.resource = resource;
	}

	public String getName() {
		return this.name;
	}

	public String getUnit() {
		return this.unit;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getResource() {
		return this.resource;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}