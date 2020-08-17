/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Simon
 */
public class GameClientOLD {
    public static void main(String[] args) {
        String hostName = "10.40.25.71";
        int portNumber = 9000;
        try (
            Socket gameSoc = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(gameSoc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(gameSoc.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("BYE"))
                    break;
                
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException ex) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
