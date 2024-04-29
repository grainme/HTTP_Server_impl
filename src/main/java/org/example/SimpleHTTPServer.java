package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.Scanner;

public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true){
            try (Socket socket = server.accept()) {
                Scanner sc = new Scanner(socket.getInputStream());
                String line = sc.nextLine();
                while (!line.isEmpty()){
                    Date today = new Date();
                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today + " " + line;
                    socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                    line = sc.nextLine();
                }

            }
        }
    }
}