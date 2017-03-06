package DCAD;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FE {
	private ServerSocket mFESocket;
	private Socket 		 mClientSocket;
	
	private String 		mPrimaryAddress; //vill lagra den första serverns port och adress
	private int 		mPrimaryPort;	 // dvs primären

	private ObjectOutputStream mOut = null;

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java Server portnumber");
			System.exit(-1);
		}
		try {
			FE instance = new FE(Integer.parseInt(args[0]));
			instance.listenForClientHandshake();
		} catch (NumberFormatException e) {
			System.err.println("Error: port number must be an integer.");
			System.exit(-1);
		}
	}

	private FE(int portNumber) {
		try {
			mFESocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			System.err.println("Could not bind Front End-Socket: " + e.getMessage());
		}
	}

	private void listenForClientHandshake() {
		System.out.println("Waiting for handshake...!");
		do {
			FEClientConnection feClientConnection;
			try {
				mClientSocket = mFESocket.accept();
			} catch (IOException e) {
				System.err.println("Error while accepting packet: " + e.getMessage());
			}	//HÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄR!
			
				// ÄNDRA ALLA STRING TILL INET
			
			
			//feClientConnection = new FEClientConnection(mClientSocket, this);
//			feClientConnection.sendRespondMsg();
		} while (true);
	}
	
	// Veta vilken primärSer
	// Skicka klienten till primären

}
