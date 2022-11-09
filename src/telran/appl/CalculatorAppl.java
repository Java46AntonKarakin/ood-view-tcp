package telran.appl;

import telran.menu.CalculatorMenu;
import telran.menu.Menu;
import telran.net.*;
import telran.net.calculator.*;
import telran.view.*;

public class CalculatorAppl {
	private static final int PORT = 2000;
	private static final String HOSTNAME = "localhost";

	public static void main(String[] args) {
		try {
			// 1.3.1
			TcpHandler tcpHandler = new TcpHandler (HOSTNAME, PORT);
			
			// 1.3.2
			NetCalculatorProxy calculatorProxy = new NetCalculatorProxy(tcpHandler);
			
			Item [] itemsFromNCP = CalculatorMenu.getCalculatorItems(calculatorProxy);
			Menu menu = new Menu("Main Menu", itemsFromNCP);
			menu.perform(new ConsoleInputOutput());
			tcpHandler.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}