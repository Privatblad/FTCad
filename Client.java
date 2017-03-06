package DCAD;

public class Client {
	static private GUI 		 mGui;
	private FEConnection 	 mFEConnection = null; // Kopplingen till servern
	private ServerConnection mServerConnection;
	
	public static void main(String[] args) {
		if (args.length < 3) {
			System.err.println("Usage: java Client hostname FEportnumber username serverportnumber");
			System.exit(-1);
		}
		try {
			Client instance = new Client();
			instance.connectToFE(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		} catch (NumberFormatException e) {
			System.err.println("Error: port number must be an integer.");
			System.exit(-1);
		}
	}

	private Client() {	}
	
    private void connectToFE(String hostName, int FEport, int serverPort) {
        mFEConnection = new FEConnection(hostName, FEport); //Create a new FEconnection
        
        if (mFEConnection.handshake()) {
        	//Behöver kopplas till servern via ServerConnection
        	mServerConnection = new ServerConnection(hostName, serverPort);
        	
        	if(mServerConnection.handshake()){
        		listenForServerMessages();
        	}
        } else { System.err.println("Unable to connect to server"); }
    }
    
    private void listenForServerMessages(){
		mGui = new GUI(750, 600, mServerConnection);
        mGui.addToListener();		
		do{
			mGui.updateObjectList(mServerConnection.receivePaintings());
		} while(true);
    }    
}
