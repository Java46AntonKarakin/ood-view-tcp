package telran.menu;

import telran.net.calculator.NetCalculatorProxy;
import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorMenu {

	public static Item[] getCalculatorItems(NetCalculatorProxy ncp) {
		Item[] res = {
			Item.of("Add numbers", x -> {
			double[] numbers = enterNumbers(x);
			ncp.add(numbers[0], numbers[1]);
		}), Item.of("Subtract numbers", x -> {
			double[] numbers = enterNumbers(x);
			ncp.subtract(numbers[0], numbers[1]);
		}), Item.of("Multiply numbers", x -> {
			double[] numbers = enterNumbers(x);
			ncp.multiply(numbers[0], numbers[1]);
		}), Item.of("Divide numbers",   x -> {
			double[] numbers = enterNumbers(x);
			ncp.divide(numbers[0], numbers[1]);
		}),
			Item.exit() };
		return res;
	}

	private static double[] enterNumbers(InputOutput io) {
		double[] res = new double[2];
		res[0] = io.readDouble("enter first value", "not value");
		res[1] = io.readDouble("enter second value", "not value");
		return res;
	}
}
