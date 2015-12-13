package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import logicservice.ClientService;

public class Client  implements ClientService{
	
	private String address="127.0.0.1";
	private int port=4700;
	private Socket socket=null;
	private String message=null;
	
	
	@Override
	public void init() throws UnknownHostException, IOException  {
		//客户端初始化
		socket=new Socket(address,port);
		System.out.println("------------Client run-----------");
	}

	@Override
	public void sendMessage(String msg) {
		//客户端发消息
		try {
			System.out.println(msg);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(msg);
			out.flush();
			//out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getMessage() {
		// 客户端收消息
		try{
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			message=in.readLine();
			return message;
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
}
