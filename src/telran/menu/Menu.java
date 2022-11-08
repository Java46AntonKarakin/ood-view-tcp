package telran.menu;

import java.util.*;
import java.util.stream.IntStream;
import telran.view.*;

public class Menu implements Item {

	private static final int N_ASTERICS = 20;
	private String name;
	private ArrayList<Item> items;

	public Menu(String name, Item... items) {
		this(name, new ArrayList<>(Arrays.asList(items)));
	}

	public Menu(String name, ArrayList<Item> items) {
		this.name = name;
		this.items = items;
	}

	@Override
	public String displayName() {
		return name;
	}

	@Override
	public void perform(InputOutput io) {
		while (true) {
			try {
				displayMenu(io);
				int itemNumber = io.readInt("enter item number", "wrong item number ", 1, items.size());
				Item item = items.get(itemNumber - 1);
				item.perform(io);
				if (item.isExit()) {
					break;
				}
			} catch (Exception e) {
				io.writeLine(e.getMessage());
			}
		}
	}

	private void displayMenu(InputOutput io) {
		io.writeLine("*".repeat(N_ASTERICS));
		io.writeObject(" ".repeat(N_ASTERICS / 4));
		io.writeLine(name);
		io.writeLine("*".repeat(N_ASTERICS));
		IntStream.rangeClosed(0, items.size()-1)
				.forEach(i -> io.writeLine(String.format("%d. %s", i+1, items.get(i).displayName())));
	}

	@Override
	public boolean isExit() {
		return false;
	}

}
