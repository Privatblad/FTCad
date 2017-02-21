package DCAD;
//FE st�r f�r Front-end

import java.io.*; 
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.net.Socket;

public class FEConnection {
	
	private Socket mClientSocket 	= null;
	private String mHostName 		= null;
	private String mClientName;
	
	private DataOutputStream mOut 	= null;	//Data skickas, TCP
	private DataInputStream mIn		= null;	//Data tas emot, TCP
	
	private int mServerPort 		= -1; //KANSKE
	private volatile boolean mIsConnected;
	
	
    public FEConnection(String hostName, int port, String clientName) {
        mHostName 	= hostName;
        mServerPort = port;
        mClientName = clientName;
        
        try {
            mClientSocket = new Socket(hostName, port);
        } catch (IOException e) {
            System.err.println("Could not create ClientSocket: " + e.getMessage());
        }
    }

    public boolean handshake(){
    	//Om klienten f�r true s� b�rjar den bara lyssna p� servern
    	try {
			mOut = new DataOutputStream(mClientSocket.getOutputStream()); //Skapar ny TCP-con. som kopplar den till socketen
			mOut.writeBoolean(true); 
    	} catch (IOException e) {
			System.err.println("Error writing boolean with DataOutputStream: " + e.getMessage());
		}
    	
    	boolean connectionTry = false; //Denna variabel l�ser input som f�tts via socketen
    	
    	do {
    		try {
				mIn = new DataInputStream(mClientSocket.getInputStream());
				connectionTry = mIn.readBoolean();	
    		} catch (IOException e) {
    			System.err.println("Error reading boolean with DataInputStream: " + e.getMessage());
			}
    	} while(connectionTry == false);
    	mIsConnected = true;
    	return true;
    }
    
    /*Beh�ver veta att servern �r vid liv, 
    beh�ver G fr�n serv f�r att sl�ppa in klient*/
    
    
    
}
