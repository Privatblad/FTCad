package DCAD;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class FEClientConnection{
	// Detta kan se annorlunda ut senare, KOM IHÅG! pga BS
	private FE 		mFE;
	private Socket  mClientSocket;
	private String  mPrimaryAddress;
	private int		mPrimaryPort;

	private ObjectOutputStream 	mOut;
	private ObjectInputStream 	mIn;

	public FEClientConnection(Socket clientSocket, FE fe, String primaryAddress, int primaryPort) {
		mClientSocket 	= clientSocket;
		mFE				= fe;		
		mPrimaryAddress = primaryAddress;
		mPrimaryPort 	= primaryPort;
		
		try {
			mOut = new ObjectOutputStream(mClientSocket.getOutputStream()); //Skapar ny TCP-con. som kopplar den till socketen
			mIn  = new ObjectInputStream(mClientSocket.getInputStream());
		} catch (IOException e) { System.err.println("Error with Object Stream: " + e.getMessage()); }
	}
	
	public synchronized void sendRespondMsg(){
		try {
			mOut.writeObject(new PrimaryMsg(true, mPrimaryAddress, mPrimaryPort));
		} catch (IOException e) { System.err.println("Could not write GObject: " + e.getMessage()); }
	}
	
	
}