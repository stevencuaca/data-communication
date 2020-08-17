/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkprog;

import java.net.*;
/**
 *
 * @author DeFu PC
 */
public class MyInet {
    public static void main(String args[]) {
        String domain = "www.matanauniversity.ac.id";
        String IP = "";
        InetAddress host = null;
        try {
        host = InetAddress.getByName(domain);
        byte ip[] = host.getAddress();
        for (int i=0; i<ip.length; i++) {
            if (i > 0) {
                IP = IP + ".";
            }
            IP = IP + (ip[i] & 0xff);
        }
        System.out.print("IP dari Domain " + domain + " adalah " + IP);
        System.out.println();
        }   catch(Exception ex) {
                System.out.print("Error"+ex);
            }
    }
}
