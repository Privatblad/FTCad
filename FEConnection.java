package DCAD;
//FE st�r f�r Front-end

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class FEConnection {
	
	private Socket mClientSocket 	= null;
	private String mHostName 		= null;
	
	private ObjectOutputStream mOut 	= null;	//Object skickas, TCP
	private ObjectInputStream mIn		= null;	//Object tas emot, TCP
	
	private int mServerPort = -1; //KANSKE
	private volatile boolean mIsConnected;
	
	
    public FEConnection(String hostName, int port) {
        mHostName 	= hostName;
        mServerPort = port;
        
        try {
            mClientSocket = new Socket(hostName, port);
        } catch (IOException e) {
            System.err.println("Could not create ClientSocket: " + e.getMessage());
        }
    }

    public boolean handshake(){
    	//Om klienten f�r true s� b�rjar den bara lyssna p� servern
    	try {
			mOut = new ObjectOutputStream(mClientSocket.getOutputStream()); //Skapar ny TCP-con. som kopplar den till socketen
    	} catch (IOException e) {
			System.err.println("Error with ObjectOutputStream: " + e.getMessage());
		}
    	boolean connectionTry = false; //Denna variabel l�ser input som f�tts via socketen
    	
    	do {
    		try {
				mIn = new ObjectInputStream(mClientSocket.getInputStream());
    		} catch (IOException e) {
    			System.err.println("Error reading boolean with ObjectInputStream: " + e.getMessage());
			}
    	} while(connectionTry == true);
    	mIsConnected = true; //KANSKE TA BORT DETTA!
    	return true;
    }
    
    /*Beh�ver veta att servern �r vid liv, 
    beh�ver G fr�n serv f�r att sl�ppa in klient*/

}
