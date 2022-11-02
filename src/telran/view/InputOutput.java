package telran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface InputOutput {

	default void close() {
	}

	String readString(String prompt);

	void writeObject(Object obj);

	default void writeLine(Object obj) {
		String str = obj + "\n";
		writeObject(str);
	}

	default <R> R readObject(String prompt, String errorPrompt, Function<String, R> mapper) {
		R result = null;
		while (true) {
			String str = readString(prompt);
			try {
				result = mapper.apply(str);
				break;
			} catch (Exception e) {
				writeLine(errorPrompt + e.getMessage());
			}
		}
		return result;
	}

	default Integer readInt(String prompt, String errorPrompt) {
		return readObject(prompt, errorPrompt, Integer::parseInt);
	}

	default Integer readInt(String prompt, String errorPrompt, int min, int max) {
		return readObject(prompt, errorPrompt, s -> {
			int num = Integer.parseInt(s);
			if (num < min) {
				throw new RuntimeException("less than " + min);
			}
			if (num > max) {
				throw new RuntimeException("greater than " + max);
			}
			return num;
		});
	}

	default Long readLong(String prompt, String errorPrompt) {
		return readObject(prompt, errorPrompt, Long::parseLong);
	}

	default String readOption(String prompt, String errorPrompt, List<String> options) {
		return readObject(prompt, errorPrompt, s -> {
			String input = s.toString();
			return options.stream().anyMatch(x -> x.equals(input)) ? input : errorPrompt;
		});
	}

	default LocalDate readDate(String prompt, String errorPrompt) {
		return readObject(prompt, errorPrompt, s -> {
			String input = s.toString();
			try {
				return LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
			} catch (DateTimeParseException e) {
				throw new RuntimeException(" Incorect input value: input should match " + "'yyyy-MM-dd';");
			}
		});
	}
	
	default LocalDate readDate(String prompt, String errorPrompt, String format) {
		return readObject(prompt, errorPrompt, s -> {
			String input = s.toString();
			DateTimeFormatter x = null;
			try {
				x = DateTimeFormatter.ofPattern(format);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(" Incorect input value: doesn't match the given format");
			}
			return LocalDate.parse(input, x);
		});
	}
	
	default String readPredicate(String prompt, String errorPrompt, Predicate <String> predicate) {
		return readObject(prompt, errorPrompt, s -> {
			String input = s.toString();
			if (!predicate.test(input)) {
				throw new RuntimeException(" Incorect input value: doesn't match the given predicate");
			}
			return input;
		});
	}
	

}
