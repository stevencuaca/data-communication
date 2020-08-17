/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import java.io.*;
import java.net.*;


/**
 *
 * @author Simon
 */
public class GameClientThread extends Thread {
    
    private Socket socket = null;
 
    public GameClientThread(Socket socket) {
        super("Game Multi Server");
        this.socket = socket;
    }
     
    public void run() {
    /*    
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
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
     * 
     */
    }
}
