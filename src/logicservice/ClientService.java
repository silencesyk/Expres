package logicservice;

import java.io.IOException;
import java.net.UnknownHostException;



public interface ClientService {
		public void init() throws UnknownHostException, IOException;
		public void sendMessage(String msg);
		public String  getMessage();
		
}
