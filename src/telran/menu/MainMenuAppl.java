package telran.menu;

import telran.view.*;
import telran.view.tests.CalculatorTest;
import telran.view.tests.CalendarTest;

public class MainMenuAppl {

	public static void main(String[] args) {
		Menu menu = new Menu("Main Menu", getSubmenu());
		menu.perform(new ConsoleInputOutput());
	}

	private static Item [] getSubmenu() {
		Item[] res = {
				Item.of("DateOperationsMenu", MainMenuAppl::launchDateOperations),
				Item.of("NumbersOperationsMenu", MainMenuAppl::launchNumbersOperations),
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
