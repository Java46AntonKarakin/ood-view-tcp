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
				Item.of("DateOperationsMenu", MenuTest::launchDateOperations),
				Item.of("NumbersOperationsMenu", MenuTest::launchNumbersOperations),
				Item.exit()
				};
		return res;
	}
	
	private static void launchDateOperations (InputOutput io) {
		CalendarTest.getDateOperationsMenu().perform(io);
	}
	
	private static void launchNumbersOperations (InputOutput io) {
		CalculatorTest.getNumbersOperationsMenu().perform(io);
	}
}
