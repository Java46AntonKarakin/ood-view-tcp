package telran.net;

import java.io.IOException;
import java.io.Serializable;

public interface NetworkHandler {
	<T> T send (String requestType, Serializable requestData);
	void close() throws IOException;
}