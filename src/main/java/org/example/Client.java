package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException {
        String host = "netology.homework";
        InetAddress inetAddress = InetAddress.getLocalHost();
        int port = 1234;
        try (Socket clientSocket = new Socket(inetAddress, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Sam");
            final String resp = in.readLine();
            System.out.println(resp);
            out.println("no");
            final String resp2 = in.readLine();
            System.out.println(resp2);
            out.println("Bye!");
            final String resp3 = in.readLine();
            System.out.println(resp3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}