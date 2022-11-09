package telran.appl;

import telran.net.TcpServer;
import telran.net.calculator.CalculatorImpl;
import telran.net.calculator.CalculatorProtocol;

public class CalculatorServerAppl {
	private static final int PORT = 2000;

	public static void main(String[] args) {
		try {
			TcpServer  server = new TcpServer(PORT, new CalculatorProtocol(new CalculatorImpl()));
			server.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
