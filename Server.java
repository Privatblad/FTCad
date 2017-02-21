package DCAD;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//
	//

	private ServerSocket mServerSocket;
	private Socket mClientSocket;

	private DataOutputStream mOut = null;

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java Server portnumber");
			System.exit(-1);
		}
		try {
			Server instance = new Server(Integer.parseInt(args[0]));
			// instance.listenForClientMessages();
		} catch (NumberFormatException e) {
			System.err.println("Error: port number must be an integer.");
			System.exit(-1);
		}
	}

	private Server(int portNumber) {
		try {
			mServerSocket = new ServerSocket(portNumber);
			Thread thread = new Thread(new ThreadRemoval());
			thread.start();
		} catch (IOException e) {
			System.err.println("Could not bind ServerSocket: " + e.getMessage());
		}
	}

	class ThreadRemoval implements Runnable {
		@Override
		//Denna metod tar bort bortkopplade klienter var femte sekund
		public void run() {
			while (true) {
				try {
					Thread.sleep(5000);
					//clientRemoval(); Denna metod behöver uppdateras
				} catch (InterruptedException e) {
					System.err.println("Failed to sleep thread: " + e.getMessage());
				}
			}
		}
	}
	
	
	//Behöver skapar replikationer, alternativt två(??)
	//Behöver bestämma ny primär
	//Den nya primären ska meddela klienterna om det nya primären
	//Meddela andra servrar
	//Behöver godkänna klienter via FE 
	//Behöver en vektor som håller alla klienter, typ via ClientCon
	
	//METODER:
	//clientRemoval();
	//listenForClientMessages(); För att lyssna på klienternas begäran
	//addClient();
	//update();
	

	
	
}
