package DCAD;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection implements Runnable {
	// Detta kan se annorlunda ut senare, KOM IHÅG! pga BS
	private Server mServer;
	private Socket mClientSocket;
	private final String mClientName = null; // ÄNDRA!!!!!!

	// två rader mConTries och mDisCon

	private DataOutputStream mOut;
	private DataInputStream mIn;

	public ClientConnection(Socket clientSocket, Server server) {
		mServer 	  = server;
		mClientSocket = clientSocket;
		try {
			mOut = new DataOutputStream(mClientSocket.getOutputStream()); //Skapar ny TCP-con. som kopplar den till socketen
			mIn  = new DataInputStream(mClientSocket.getInputStream());
		} catch (IOException e) {
			System.err.println("Error with Data Stream: " + e.getMessage());
		}
	}

	public String getClientName() { //Tar in namn
		return mClientName;
	}

	public boolean hasName(String testName) { //Kollar klientnamn med testnamn
		return testName.equals(mClientName);
	}

	@Override
	public void run() {
		boolean isConnected = true;
		
		
	}
}
