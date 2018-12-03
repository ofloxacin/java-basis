package com.ofloxacin.corejavaii;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/3 19:10
 */
public class SocketClientTest {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket()) {
            SocketAddress socketAddress = new InetSocketAddress(8189);
            socket.connect(socketAddress, 5000);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            try (Scanner scanner = new Scanner(inputStream);
                 PrintWriter writer = new PrintWriter(outputStream, true)) {
                writer.println("aspirin");

                Thread thread = new Thread(() -> {
                    Scanner sin = new Scanner(System.in);
                    while (!socket.isClosed() && sin.hasNextLine()) {
                        writer.println(sin.nextLine());
                    }
                });
                thread.start();

                while (!socket.isClosed() && scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    System.out.println(message);
                }
            }
        }
    }
}
