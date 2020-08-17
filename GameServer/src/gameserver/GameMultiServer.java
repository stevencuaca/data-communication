/**
 *
 * @author Simon
 */

package gameserver;

import java.io.*;
import java.net.*;

public class GameMultiServer {
    public static void main(String[] args) {
        int port = 9000;
        boolean listening = true;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) { 
            System.out.println("Server running...");
            while (listening) { 
                new GameMultiServerThread(serverSocket.accept()).start();
	    }
        } 
        catch (IOException ex) {
            System.out.println("Error: " + ex +"PORT " +port);
            System.exit(-1);
        }
    }
}
