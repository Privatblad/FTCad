package DCAD;
//FE står för Front-end

import java.io.IOException;
import java.net.Socket;

public class FEConnection {

    private Socket mClientSocket 	= null;
    private String mHostName 		= null;
    private String mClientName;

    private int mServerPort 		= -1; //KANSKE

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

}


