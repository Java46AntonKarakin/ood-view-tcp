package telran.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

public interface NetworkHandler extends Closeable{
	<T> T send (String requestType, Serializable requestData);
	void close() throws IOException;
}