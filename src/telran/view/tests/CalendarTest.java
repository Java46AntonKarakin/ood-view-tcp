package telran.view.tests;

import java.time.*;
import java.time.temporal.ChronoUnit;
import telran.menu.Menu;
import telran.view.*;

public class CalendarTest {

	private final static String DATE_AFTER_DAYS = "Date after given number days";
	private final static String DATE_BEFORE_DAYS = "Date before given number days";
	private final static String DAYS_BETWEEN_DATES = "Number days between two dates";
	private final static String CURRENT_AGE = "Age according to the birthdate";
	private final static String WRONG_DATE_FORMAT = "input value doesn't fit format needed";
	private final static String HINT_DATE_FORMAT = "in format \"YYYY-MM-DD\"";

	public static Menu getDateOperationsMenu () {
		return new Menu("Date Operations Menu", getItems());
	}

	private static Item[] getItems() {
		Item[] res = { 
				Item.of(DATE_AFTER_DAYS, CalendarTest::dateAftrDays),
				Item.of(DATE_BEFORE_DAYS, CalendarTest::dateBfrDays),
				Item.of(DAYS_BETWEEN_DATES, CalendarTest::daysBtwDates), 
				Item.of(CURRENT_AGE, CalendarTest::currAge),
				Item.exit()
				};
		return res;
	}

	private static void dateAftrDays(InputOutput io) {
		var inputValue = enterNumbers(io, "days after today");
		io.writeLine(LocalDate.now().plus(inputValue, ChronoUnit.DAYS));
	}

	private static void dateBfrDays(InputOutput io) {
		var inputValue = enterNumbers(io, "days befor today");
		io.writeLine(LocalDate.now().minus(inputValue, ChronoUnit.DAYS));
	}

	private static void daysBtwDates(InputOutput io) {
		var firstDate = io.readDate("first date " + HINT_DATE_FORMAT, WRONG_DATE_FORMAT);
		var secondDate = io.readDate("second date " + HINT_DATE_FORMAT, WRONG_DATE_FORMAT);
		io.writeLine(ChronoUnit.DAYS.between(firstDate, secondDate));
	}

	private static void currAge(InputOutput io) {
		LocalDate inputValue = io.readDate("date of birth " + HINT_DATE_FORMAT, WRONG_DATE_FORMAT);
		io.writeLine(inputValue.until(LocalDate.now()).getYears());
	}

	private static int enterNumbers(InputOutput io, String inputType) {
		return io.readInt("enter " + inputType + ": ", "input is not " + inputType);
	}
}
