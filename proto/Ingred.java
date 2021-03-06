public class Ingred {
	private String name;
	private String unit;
	private double amount;

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
		return this.name.toLowerCase();
	}

	public String getUnit() {
		return this.unit.toLowerCase();
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return this.name + ": " + this.amount + " " + this.unit;
	}
}