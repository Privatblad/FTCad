package DCAD;

public class Client {

    static private GUI gui;
    private String mName = null;			 // Klientens namn
    private FEConnection mConnection = null; // Kopplingen till servern

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java Client serverhostname serverportnumber username");
            System.exit(-1);
        }
        try {
            Client instance = new Client(args[2]);
            instance.connectToFE(args[0], Integer.parseInt(args[1]));
        } catch (NumberFormatException e) {
            System.err.println("Error: port number must be an integer.");
            System.exit(-1);
        }
    }

    private Client(String userName) {
        mName = userName;
        // Start up GUI (runs in its own thread)
        gui = new GUI(750, 600);
    }

    private void connectToFE(String hostName, int port) {
        //Create a new server connection
        mConnection = new FEConnection(hostName, port, mName);
     /*   if (mConnection.handshake()) {
            listenForServerMessages();
        } else {
            System.err.println("Unable to connect to server");
        }*/
    }

}


