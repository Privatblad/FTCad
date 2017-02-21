package DCAD;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection {
	
	private Socket mClientSocket = null;
	private String mServerName	 = null;
	private String mClientName;
	
	private DataOutputStream mOut = null;
	private DataInputStream mIn	  = null;
	
	private int mServerPort = -1;
	//mIsCon????
	
	public ServerConnection(String serverName, int serverPort, String clientName){
		mServerName = serverName;
		mClientName = clientName;
		mServerPort = serverPort;
		
		try {
			mClientSocket = new Socket(serverName, serverPort);
		} catch (IOException e) {
			System.err.println("Could not create ClientSocket: " + e.getMessage());
		}
	}
	
	//Behöver vi receivea något?
	//Behöver vi senda något?
	

	

}
