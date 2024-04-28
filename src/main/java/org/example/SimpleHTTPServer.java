package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true){
            final Socket client = server.accept();
            Scanner sc = new Scanner(client.getInputStream());
            String line;
            do {
                line = sc.nextLine();
                System.out.println(line);
            }while(!line.isEmpty());
        }
    }
}