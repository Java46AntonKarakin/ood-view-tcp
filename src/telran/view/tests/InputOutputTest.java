package telran.view.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;

class InputOutputTest {
	
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
	
	@Test
	void readOptionTest() {
		List <String> list = new ArrayList <>();
		list.add("one");
		list.add("two");
		String res = io.readOption("Enter 'one' or 'two' :", "Something went wrong: ", list);
		io.writeLine(res);
	}
	
//	@Test
	void readDateTest() {
		LocalDate res = io.readDate("Enter date:", "Something went wrong: ");
		io.writeLine(res);
	}
	
//	@Test
	void readDateFormatTest() {
		System.out.println("readDateFormatTest");
		LocalDate res = io.readDate("Enter date according to format:", "Something went wrong: ", "yyyy-MM-dd");
		io.writeLine(res);
	}
	
//	@Test
	void readPredicateTest() {
		String res = io.readPredicate("Enter value according to predicate:", "Something went wrong: ", x->x.length()==7);
		io.writeLine(res);
	}

}
