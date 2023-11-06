package test.java.org.ratcm;

import main.java.org.ratcm.CoffeeMaker;
import main.java.org.ratcm.Recipe;

public class CoffeeMakerScenarios {
	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	public CoffeeMakerScenarios() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setUp() throws Exception {
		cm = new CoffeeMaker();

		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");

		// Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");

	}

	private void testMakeCoffee() {
		cm.addRecipe(r1);
		assert (25 == cm.makeCoffee(0, 75));
		System.out.println("testMakeCoffee passed with success");
	}

	private void testMakeCoffeeWithoutEnoughMoney() {
		cm.addRecipe(r1);
		final int moneyAmount = 25;
		assert (moneyAmount < cm.getRecipes()[0].getPrice());
		assert (moneyAmount == cm.makeCoffee(0, moneyAmount));
		System.out.println("testMakeCoffeeWithoutEnoughMemory passed with success");
	}

	private void testMakeMochaWithNoSufficientChocolate() {
		cm.addRecipe(r2);
		assert (75 == cm.makeCoffee(0, 75));
		System.out.println("testMakeMochaWithNoSufficientChocolate passed with success");
	}

	private void testMakingManyCoffeesEmptiesStock() {
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(0, 50));
		assertEquals(0, cm.makeCoffee(0, 50));
		assertEquals(0, cm.makeCoffee(0, 50));
		assertEquals(0, cm.makeCoffee(0, 50));
		assertEquals(0, cm.makeCoffee(0, 50));
		assertEquals(50, cm.makeCoffee(0, 50));
		System.out.println("testMakingManyCoffeesEmptiesStock passed with success");
	}

	private void assertEquals(int expectedValue, int testedValue) {
		assert (expectedValue == testedValue);
	}

	public static void main(String[] args) {
		CoffeeMakerScenarios testScenario = new CoffeeMakerScenarios();
		// Run once at a time (in order to isolate pb)
//		testScenario.testMakeCoffee();
//		testScenario.testMakeCoffeeWithoutEnoughMoney();
//		testScenario.testMakeMochaWithNoSufficientChocolate();
//		testScenario.testMakingManyCoffeesEmptiesStock();
	}

}
