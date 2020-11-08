package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    int startParam = str.indexOf("=") + 1;
                    int finishParam = str.lastIndexOf(" ");
                    String command = str.substring(startParam, finishParam);

                    switch (command) {
                        case "Hello":
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello\r\n".getBytes());
                            break;
                        case "Exit":
                            server.close();
                            break;
                        default:
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write((command + "\r\n").getBytes());
                    }

                }
            }
        }
    }
}
