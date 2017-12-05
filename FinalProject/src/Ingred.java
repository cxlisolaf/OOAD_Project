import javax.persistence.*;
@Entity
@Table(name = "OOAD")
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

	Ingred(){

	}

	Ingred(String name) {
		this.name = name;
		this.unit = "undef";
		this.amount = 1;
	}

	Ingred(String name, String unit, double amount) {
		this.name = name;
		this.unit = unit;
		this.amount = amount;
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

	public void setAmount(double amount) {
		this.amount = amount;
	}
}