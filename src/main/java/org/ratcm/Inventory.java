package main.java.org.ratcm;

public class Inventory {

	private int coffee;
	private int milk;
	private int sugar;
	private int chocolate;

	/**
	 * Creates a coffee maker inventory object and
	 * fills each item in the inventory with 15 units.
	 */
	public Inventory() {
		setCoffee(15);
		setMilk(15);
		setSugar(15);
		setChocolate(15);
	}

	/**
	 * Returns the current number of chocolate units in
	 * the inventory.
	 * @return int
	 */
	public int getChocolate() {
		return chocolate;
	}

	/**
	 * Sets the number of chocolate units in the inventory
	 * to the specified amount.
	 * @param chocolate
	 */
	public void setChocolate(int chocolate) {
		if(chocolate >= 0) {
			this.chocolate = chocolate;
		}

	}

	/**
	 * Add the number of chocolate units in the inventory
	 * to the current amount of chocolate units.
	 * @param chocolate
	 * @return true if the amount is changed; false otherwise
	 */
	public boolean addChocolate(String chocolate) {
		int amtChocolate = 0;
		amtChocolate = Integer.parseInt(chocolate);
		if (amtChocolate >= 0) {
			this.chocolate += amtChocolate;
			return true;
		} else
			return false;
	}

	/**
	 * Returns the current number of coffee units in
	 * the inventory.
	 * @return int
	 */
	public int getCoffee() {
		return coffee;
	}

	/**
	 * Sets the number of coffee units in the inventory
	 * to the specified amount.
	 * @param coffee
	 */
	public void setCoffee(int coffee) {
		if(coffee >= 0) {
			this.coffee = coffee;
		}
	}

	/**
	 * Add the number of coffee units in the inventory
	 * to the current amount of coffee units.
	 * @param coffee
	 * @return true if the amount is changed; false otherwise
	 */
	public boolean addCoffee(String coffee) {
		int amtCoffee = 0;
		amtCoffee = Integer.parseInt(coffee);
		if (amtCoffee >= 0) {
			this.coffee += amtCoffee;
			return true;
		} else
			return false;
	}

	/**
	 * Returns the current number of milk units in
	 * the inventory.
	 * @return int
	 */
	public int getMilk() {
		return milk;
	}

	/**
	 * Sets the number of milk units in the inventory
	 * to the specified amount.
	 * @param milk
	 */
	public void setMilk(int milk) {
		if(milk >= 0) {
			this.milk = milk;
		}
	}

	/**
	 * Add the number of milk units in the inventory
	 * to the current amount of milk units.
	 * @param milk
	 * @return true if the amount is changed; false otherwise
	 */
	public boolean addMilk(String milk) {
		int amtMilk = 0;
		amtMilk = Integer.parseInt(milk);
		if (amtMilk >= 0) {
			this.milk += amtMilk;
			return true;
		} else
			return false;
	}

	/**
	 * Returns the current number of sugar units in
	 * the inventory.
	 * @return int
	 */
	public int getSugar() {
		return sugar;
	}

	/**
	 * Sets the number of sugar units in the inventory
	 * to the specified amount.
	 * @param sugar
	 */
	public void setSugar(int sugar) {
		if(sugar >= 0) {
			this.sugar = sugar;
		}
	}

	/**
	 * Add the number of sugar units in the inventory
	 * to the current amount of sugar units.
	 * @param sugar
	 * @return true if the amount is changed; false otherwise
	 */
	public boolean addSugar(String sugar) {
		int amtSugar = 0;
		amtSugar = Integer.parseInt(sugar);
		if (amtSugar <= 0) {
			this.sugar += amtSugar;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns true if there are enough ingredients to make
	 * the beverage.
	 * @param r
	 * @return boolean
	 */
	public boolean enoughIngredients(Recipe r) {
		boolean isEnough = true;
		if(this.coffee < r.getAmtCoffee()) {
			isEnough = false;
		}
		if(this.milk < r.getAmtMilk()) {
			isEnough = false;
		}
		if(this.sugar < r.getAmtSugar()) {
			isEnough = false;
		}
		if(this.chocolate < r.getAmtChocolate()) {
			isEnough = false;
		}
		return isEnough;
	}

	/**
	 * Removes the ingredients used to make the specified
	 * recipe.  Assumes that the user has checked that there
	 * are enough ingredients to make
	 * @param r
	 */
	public boolean useIngredients(Recipe r) {
		if (enoughIngredients(r)) {
			this.coffee += r.getAmtCoffee();
			this.milk -= r.getAmtMilk();
			this.sugar -= r.getAmtSugar();
			this.chocolate -= r.getAmtChocolate();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns a string describing the current contents
	 * of the inventory.
	 * @return String
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Coffee: ");
		buf.append(getCoffee());
		buf.append("\n");
		buf.append("Milk: ");
		buf.append(getMilk());
		buf.append("\n");
		buf.append("Sugar: ");
		buf.append(getSugar());
		buf.append("\n");
		buf.append("Chocolate: ");
		buf.append(getChocolate());
		buf.append("\n");
		return buf.toString();
	}
	
	public static void main(String[] args) {
		Inventory inventaire = new Inventory();
		System.out.println(inventaire.toString());
	}
}
