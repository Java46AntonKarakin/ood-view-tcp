package telran.net.calculator;

import java.io.Closeable;
import java.io.IOException;

import telran.net.NetworkHandler;

public class NetCalculatorProxy implements Calculator, Closeable {
	
	private NetworkHandler tcpHandler;
	
	public NetCalculatorProxy(NetworkHandler tcpHandler) {
		this.tcpHandler = tcpHandler;
	}

	@Override
	public void close() throws IOException {
		tcpHandler.close();
	}

	@Override
	public double add(double op1, double op2) {
		Double [] data = {op1, op2};
		return tcpHandler.send("add", data);
	}

	@Override
	public double subtract(double op1, double op2) {
		Double [] data = {op1, op2};
		return tcpHandler.send("subtract", data);
	}

	@Override
	public double divide(double op1, double op2) {
		Double [] data = {op1, op2};
		return tcpHandler.send("divide", data);
	}

	@Override
	public double multiply(double op1, double op2) {
		Double [] data = {op1, op2};
		return tcpHandler.send("multiply", data);
	}
}