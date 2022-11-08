package telran.appl;

import telran.menu.Menu;
import telran.net.*;
import telran.net.calculator.*;
import telran.view.*;

public class CalculatorAppl {
	private static final int PORT = 2000;
	private static final String HOSTNAME = "localhost";

	public static void main(String[] args) {
		try {
			TcpHandler tcpHandler = new TcpHandler (HOSTNAME, PORT);
			CalculatorProxy calculatorProxy = new CalculatorProxy(tcpHandler);
			var cm = CalculatorMenu.getCalculatorItems();
			Menu menu = new Menu("Main Menu", cm);
			menu.perform(new ConsoleInputOutput());
			tcpHandler.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
