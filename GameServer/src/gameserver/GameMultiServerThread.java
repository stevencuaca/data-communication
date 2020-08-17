/**
 *
 * @author Simon
 */

package gameserver;

import java.io.*;
import java.net.*;

public class GameMultiServerThread extends Thread {
    private Socket socket = null;
 
    public GameMultiServerThread(Socket socket) {
        super("Game Multi Server");
        this.socket = socket;
    }
     
    public void run() {
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
            String fromClient, fromServer;
            
            GameProtocol gp = new GameProtocol();
            fromServer = gp.processInput(null);
            out.println(fromServer);
            System.out.println("SERVER: "+fromServer);
 
            while ((fromClient = in.readLine()) != null) {
                fromServer = gp.processInput(fromClient);
                out.println(fromServer);
                //
                System.out.println("CLIENT: "+fromClient);
                System.out.println("SERVER: "+fromServer);
                if (fromServer.equals("BYE"))
                    break;
            }
            socket.close();
            System.out.println("Disconnected...");
        } 
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERR: Disconnected...");
        }
    }
}