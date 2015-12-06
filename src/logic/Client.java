package logic;

import java.io.IOException;
import java.net.UnknownHostException;



public interface Client {
		public void init() throws UnknownHostException, IOException;
		public void sendMessage(String msg);
		public String  getMessage();
		
}
