package telran.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class InputOutputTest {
	
	List <String> list = new ArrayList <>();
	InputOutput io = new ConsoleInputOutput();

//	@Test
	void readObjectTest() {
		Integer[] array = io.readObject("Enter numbers separated by space", "no number", s -> {

			String[] strNumbers = s.split(" ");
			return Arrays.stream(strNumbers).map(str -> Integer.parseInt(str)).toArray(Integer[]::new);
		});
		io.writeLine(Arrays.stream(array).collect(Collectors.summarizingInt(x -> x)));
	}

//	@Test
	void readIntMaxTest() {
		int res = io.readInt("Enter numbers in range [1,40]", "no number", 1, 40);
		io.writeLine(res);
	}
	
//	@Test
	void readOptionTest() {
		list.add("one");
		list.add("two");
		String res = io.readOption("Enter value:", "Something went wrong: ", list);
		io.writeLine(res);
	}
	
//	@Test
	void readDateTest() {
		LocalDate res = io.readDate("Enter value:", "Something went wrong: ");
		io.writeLine(res);
	}
	
//	@Test
	void readDateFormatTest() {
		LocalDate res = io.readDate("Enter value:", "Something went wrong: ", "([0-9]){4}\\-([0-9]){2}\\-([0-9]){2}");
		io.writeLine(res);
	}
	
	@Test
	void readPredicateTest() {
		String res = io.readPredicate("Enter value:", "Something went wrong: ", x->x.length()==1);
		io.writeLine(res);
	}

}
