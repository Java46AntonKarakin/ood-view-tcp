package telran.net;

import java.net.*;

public class TcpServer implements Runnable {
	
	private ApplProtocol protocol;
	private ServerSocket serverSocket;
	private int port;

	public TcpServer(int port, ApplProtocol protocol) throws Exception {
		this.port = port;
		this.protocol = protocol;
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		System.out.println("server is listening on the port " + port);
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				TcpClientServer clientServer = new TcpClientServer(socket, protocol);
				clientServer.run();
			}
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}

}
