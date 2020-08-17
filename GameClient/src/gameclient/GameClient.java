/**
 *
 * @author Simon
 */

package gameclient;

import java.io.*;
import java.net.*;

public class GameClient {    
    
    private Socket gameSoc;
    private GameClientThread gct;
    private static final String HOSTNAME = "10.40.25.71";
    private static final int PORT = 9000;
    private PrintWriter out;
    private BufferedReader in;
    
    public GameClient() {
        
    }
    
    public String connectToServer() {
        try {
            gameSoc = new Socket(HOSTNAME, PORT);
            out = new PrintWriter(gameSoc.getOutputStream(), true);
            in = new BufferedReader(
                new InputStreamReader(
                    gameSoc.getInputStream()));            
            return respondServer();
        } catch (UnknownHostException ex) {
            System.err.println("Don't know about host " + HOSTNAME);
            return "ERROR";
            // System.exit(1);
        } catch (IOException ex) {
            System.err.println("Couldn't get I/O for the connection to " +
                HOSTNAME);
            return "ERROR";
            // System.exit(1);
        }
    }
    
    public void disconnectToServer() {
        try {
            if (gameSoc.isConnected()) {
                gameSoc.close();
            }
        }
        catch (IOException ex) {
            System.err.println("Couldn't get I/O for the connection to " +
                HOSTNAME);
            System.exit(1);
        }        
    }
    public String playGame() {
        requestMsg("PLAY");        
        return respondServer();
    }
    
    public String guessNumber(String guess) {
        requestMsg("GUESS:"+guess);
        return respondServer();
    }
    
    private void requestMsg(String msg) {
        out.println(msg);
    }

    private String respondServer() {
        try {
            return in.readLine();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
            return "ERROR";
        }        
    }
    
}
