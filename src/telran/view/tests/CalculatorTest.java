package telran.view.tests;

import telran.menu.Menu;
import telran.view.*;

public class CalculatorTest {

	public static Menu getNumbersOperationsMenu  () {
		return new Menu("Date Numbers Menu", getItems());
	}

	private static Item[] getItems() {
		Item[] res = { 
				Item.of("Add numbers", CalculatorTest::add),
				Item.of("Subtract numbers", CalculatorTest::subtract),
				Item.of("Multiply numbers", CalculatorTest::multiply),
				Item.of("Divide numbers", CalculatorTest::divide),
				Item.exit()
				};
		return res;
	}

	private static void add(InputOutput io) {
		int [] numbers = enterNumbers(io);
		io.writeLine(numbers[0] + numbers[1]);
	}

	private static void subtract(InputOutput io) {
		int [] numbers = enterNumbers(io);
		io.writeLine(numbers[0] - numbers[1]);
	}

	private static void multiply(InputOutput io) {
		int [] numbers = enterNumbers(io);
		io.writeLine(numbers[0] * numbers[1]);
	}

	private static void divide(InputOutput io) {
		int [] numbers = enterNumbers(io);
		io.writeLine(numbers[0] / numbers[1]);
	}
	
	private static int[] enterNumbers(InputOutput io) {
		int[] res = new int [2];
		res [0] = io.readInt("enter first number", "no number");
		res [1] = io.readInt("enter second number", "no number");
		return res;
	}

}
