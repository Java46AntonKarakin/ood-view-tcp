package telran.net.calculator;

import java.io.Closeable;
import java.io.IOException;

import telran.net.NetworkHandler;

public class CalculatorProxy implements Calculator, Closeable {
	
	CalculatorImpl calcImpl = new CalculatorImpl();
	private NetworkHandler networkHandler;
	
	public CalculatorProxy(NetworkHandler networkHandler) {
		this.networkHandler = networkHandler;
	}

	@Override
	public void close() throws IOException {
		networkHandler.close();
	}

	@Override
	public double add(double op1, double op2) {
		networkHandler.send("add", calcImpl.add(op1, op2));
		return calcImpl.add(op1, op2);
	}

	@Override
	public double subtract(double op1, double op2) {
		networkHandler.send("subtract", calcImpl.subtract(op1, op2));
		return calcImpl.subtract(op1, op2);
	}

	@Override
	public double divide(double op1, double op2) {
		networkHandler.send("divide", calcImpl.divide(op1, op2));
		return calcImpl.divide(op1, op2);
	}

	@Override
	public double multiply(double op1, double op2) {
		networkHandler.send("multiply", calcImpl.multiply(op1, op2));
		return calcImpl.multiply(op1, op2);
	}
	

}
