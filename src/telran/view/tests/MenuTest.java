package telran.view.tests;

import telran.menu.Menu;
import telran.view.*;

public class MenuTest {

	public static void main(String[] args) {
		Menu menu = new Menu("Main Menu", getSubmenu());
		menu.perform(new ConsoleInputOutput());
	}

	private static Item [] getSubmenu() {
		Item[] res = {
				Item.of("CalendarTest", x -> CalendarTest.getDateOperationsMenu().perform(new ConsoleInputOutput())),
				Item.of("CalculatorTest", x -> CalculatorTest.getNumbersOperationsMenu().perform(new ConsoleInputOutput())),
				Item.exit()
				};
		return res;
	}
	
	private static void launchDateOperations () {
		CalendarTest.getDateOperationsMenu().perform(new ConsoleInputOutput());
	}
	
	private static void launchNumbersOperations () {
		CalculatorTest.getNumbersOperationsMenu().perform(new ConsoleInputOutput());
	}
}
